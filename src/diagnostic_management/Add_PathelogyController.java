/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Add_PathelogyController implements Initializable {

    Connection con;
    
     @FXML
    private ComboBox<String> gender;

    @FXML
    private DatePicker joinDate;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private AnchorPane pathologist_pane;

    @FXML
    private TextField phone;

    String P_name;
    String P_phn;
    String P_password;
    String P_gender;
    String P_joindate;
    
    ObservableList<String>genderList=FXCollections.observableArrayList("Male","Female");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        gender.setItems(genderList);
        con=Database_Connection.Connection();
    }    

    @FXML
    private void add_action(ActionEvent event) {
        P_name=name.getText().toString();
        P_gender=gender.getValue().toString();
        P_phn=phone.getText().toString();
        P_joindate=joinDate.getValue().toString();
        P_password=password.getText().toString();
        
        try{
            Statement st=con.createStatement();
            String add_query="insert into Pathologist (p_Name,p_Gender,p_Phone,p_joiningDate,p_Password) values ('"+P_name+"','"+P_gender+"','"+P_phn+"','"+P_joindate+"','"+P_password+"')";
            st.execute(add_query);
        }catch(Exception e)
        {
            System.out.println("Exception in Pathologist :"+e);
        }
        name.setText("");
        gender.setValue("");
        phone.setText("");
        joinDate.setValue(LocalDate.MAX);
        password.setText("");
        
    }

    @FXML
    private void back_Action(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("admini_option.fxml"));
        pathologist_pane.getChildren().setAll(pane);
        
    } 
    
}
