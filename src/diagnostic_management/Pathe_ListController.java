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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Pathe_ListController implements Initializable {

    @FXML
    private AnchorPane PethPane;
    @FXML
    private TableView<path_info> Peth_table;
    @FXML
    private TableColumn<path_info, String> Pa_id;
    @FXML
    private TableColumn<path_info, String> Pa_Name;
    @FXML
    private TableColumn<path_info, String> Pa_gen;
    @FXML
    private TableColumn<path_info, String> pa_Joi;
    @FXML
    private TableColumn<path_info, String> pa_pass;
    @FXML
    private TableColumn<path_info, String> pa_phone;
    Connection con;
    ObservableList<path_info> path_info = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = Database_Connection.Connection();
        refresh_fetch();
    }

    public void info_fetch() {

        Pa_id.setCellValueFactory(new PropertyValueFactory("Pa_id"));
        Pa_Name.setCellValueFactory(new PropertyValueFactory("Pa_Name"));
        Pa_gen.setCellValueFactory(new PropertyValueFactory("Pa_gen"));
        pa_Joi.setCellValueFactory(new PropertyValueFactory("pa_Joi"));
        pa_pass.setCellValueFactory(new PropertyValueFactory("pa_pass"));
        pa_phone.setCellValueFactory(new PropertyValueFactory("pa_phone"));

        try {
            System.out.println(ApointmentListController.loginDr);
            String query = "Select * from Pathologist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("am i");

                String p_ID = rs.getString("p_ID");
                String p_Name = rs.getString("p_Name");
                String p_Gender = rs.getString("p_Gender");  //here age is ap id
                String p_joiningDate = rs.getString("p_joiningDate");
                String p_Password = rs.getString("p_Password");
                String p_Phone = rs.getString("p_Phone");

                path_info dp = new path_info(p_ID, p_Name, p_Gender, p_joiningDate, p_Password, p_Phone);
                path_info.add(dp);
                

            }
            Peth_table.setItems(path_info);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void refresh_fetch() {
        path_info.clear();
        info_fetch();
    }

}
