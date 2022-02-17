/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Patient_ListController implements Initializable {

    private TableColumn<Patient_info, String> T_pid;
    private TableColumn<Patient_info, String> T_PName;
    private TableColumn<Patient_info, String> T_Page;
    private TableColumn<Patient_info, String> T_PBrp;
    private TableColumn<Patient_info, String> T_Pg;
    private TableColumn<Patient_info, String> T_phn;
    private TableColumn<Patient_info, String> T_PQ;
    private TextField PId;
    @FXML
    private TableView<Patient_info> Patient_List;

    Connection conn;
    ObservableList<Patient_info> Patient_info = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> T_Rid;
    @FXML
    private TableColumn<?, ?> T_RName;
    @FXML
    private TableColumn<?, ?> T_Rg;
    @FXML
    private TableColumn<?, ?> T_Rhn;
    @FXML
    private TableColumn<?, ?> T_RJd;
    @FXML
    private TableColumn<?, ?> T_Rrs;
    @FXML
    private TableColumn<?, ?> T_Rps;
    @FXML
    private TextField RId;
    @FXML
    private Button RSrch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        conn = Database_Connection.Connection();
        String query = "select * from patient";
        refresh_fresh(query);
    }

    private void P_Search(ActionEvent event) {

        String query = "select * from patient where  p_ID='" + PId.getText() + "'";
        refresh_fresh(query);
    }

    public void fetch_info(String query) {
        T_pid.setCellValueFactory(new PropertyValueFactory("p_ID"));
        T_PName.setCellValueFactory(new PropertyValueFactory("p_Name"));
        T_Page.setCellValueFactory(new PropertyValueFactory("p_age"));
        T_PBrp.setCellValueFactory(new PropertyValueFactory("p_bloodGrp"));
        T_Pg.setCellValueFactory(new PropertyValueFactory("p_gender"));
        T_phn.setCellValueFactory(new PropertyValueFactory("p_phoneNumber"));
        T_PQ.setCellValueFactory(new PropertyValueFactory("p_quota"));

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Patient_info.add(new Patient_info(rs.getString("p_ID"), rs.getString("p_Name"), rs.getString("p_age"), rs.getString("p_bloodGrp"), rs.getString("p_gender"),
                        rs.getString("p_phoneNumber"), rs.getString("p_quota")));
            }
            Patient_List.setItems(Patient_info);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void refresh_fresh(String query) {
        Patient_info.clear();
        fetch_info(query);
    }

    private void reset_search(ActionEvent event) {

       String query = "select * from patient";
        refresh_fresh(query);
    }

    @FXML
    private void R_Search(ActionEvent event) {
    }

    @FXML
    private void Rec_reset_search(ActionEvent event) {
    }

}
