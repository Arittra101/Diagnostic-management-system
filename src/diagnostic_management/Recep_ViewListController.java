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
public class Recep_ViewListController implements Initializable {

    @FXML
    private TableView<Rec_info> Recep_List;
    @FXML
    private TableColumn<Rec_info, String> T_Rid;
    @FXML
    private TableColumn<Rec_info, String> T_RName;
    @FXML
    private TableColumn<Rec_info, String> T_Rphn;
    @FXML
    private TableColumn<Rec_info, String> T_Rjoin;
    @FXML
    private TableColumn<Rec_info, String> T_Rres;
    @FXML
    private TableColumn<Rec_info, String> T_Rpass;
    @FXML
    private TextField RId;
    @FXML
    private Button RSrch;

    Connection conn;
    ObservableList<Rec_info> Recep_info = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn = Database_Connection.Connection();
        String query = "select * from Receptionist";
        refresh_fresh(query);
    }

    @FXML
    private void Rec_Search(ActionEvent event) {

        String query = "select * from Receptionist where  R_ID='" + RId.getText() + "'";
        refresh_fresh(query);

    }

    public void fetch_recpInfo(String query) {

        T_Rid.setCellValueFactory(new PropertyValueFactory("R_ID"));
        T_RName.setCellValueFactory(new PropertyValueFactory("R_Name"));
        T_Rphn.setCellValueFactory(new PropertyValueFactory("R_Phone"));
        T_Rjoin.setCellValueFactory(new PropertyValueFactory("R_joiningDate"));
        T_Rres.setCellValueFactory(new PropertyValueFactory("R_ResignDate"));
        T_Rpass.setCellValueFactory(new PropertyValueFactory("R_Password"));

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Recep_info.add(new Rec_info(rs.getString("R_ID"), rs.getString("R_Name"), rs.getString("R_Phone"), rs.getString("R_joiningDate"), rs.getString("R_ResignDate"),
                        rs.getString("R_Password")));
            }
            Recep_List.setItems(Recep_info);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void refresh_fresh(String query) {
        Recep_info.clear();
        fetch_recpInfo(query);
    }

    @FXML
    private void Rec_reset_search(ActionEvent event) {

        String query = "select * from Receptionist";
        refresh_fresh(query);
    }

}
