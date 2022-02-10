/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import static diagnostic_management.Database_Connection.Connection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Add_PatientController implements Initializable {

    Connection conn;

    @FXML
    TableView<Table_Patient> table;
    
    @FXML
    private TableColumn<Table_Patient, String> T_age;
    
    @FXML
    private TableColumn<Table_Patient, String> T_gender;

    @FXML
    private TableColumn<Table_Patient, String> T_name;

    @FXML
    private TableColumn<Table_Patient, String> T_phone;
    
 

    @FXML
    private TextField name;
    @FXML
    private TextField phn;
    @FXML
    private TextField age;
    @FXML
    private ComboBox<String> gender;

    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    ObservableList<Table_Patient> patient_info = FXCollections.observableArrayList();

    //arraylist
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Database_Connection.Connection();
        conn = Database_Connection.con;

        gender.setItems(genderList);

        fetch_info();

    }

    @FXML
    private void Save(ActionEvent event) throws SQLException {
        String Pname = name.getText();
        String P_age = age.getText();
        String p_phn = phn.getText();
        String gnd = gender.getValue();


        String insert_query = "insert into DG_user values('" + Pname + "','" + P_age + "','" + p_phn + "','" + gnd + "')";
        Statement st = conn.createStatement();
        st.executeUpdate(insert_query);
            
         patient_info.clear();
        fetch_info();
    }

    public void fetch_info() {

        T_name.setCellValueFactory(new PropertyValueFactory("name"));
        T_age.setCellValueFactory(new PropertyValueFactory("age"));
        T_phone.setCellValueFactory(new PropertyValueFactory("phone"));
        T_gender.setCellValueFactory(new PropertyValueFactory("gender"));

        try {
            Statement st = conn.createStatement();
            String fetch_query = "select * from DG_user";
            ResultSet rs = st.executeQuery(fetch_query);

            while (rs.next()) {

                String name = rs.getString("name");
                String age = rs.getString("age");
                String Phone = rs.getString("Phone");
                String Gender = rs.getString("Gender");
                patient_info.add(new Table_Patient(name, age, Phone, Gender));
            }
            table.setItems(patient_info);
        } catch (Exception e) {

        }

    }
    
    @FXML
    void Refresh(ActionEvent event) {
        
           patient_info.clear();
            fetch_info();
    }

}
