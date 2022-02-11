/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Add_RecptionistController implements Initializable {
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField phone;
    
    @FXML 
    private TextField password;

    @FXML
    private ComboBox<String> gender;
    @FXML
    private DatePicker joindate;
    
    Connection con;
    String Rname;
    String Rgender;
    String Rphn;
    String Rjoin;
    String Rpassword;
    
    
    ObservableList<String> ComboGender = FXCollections.observableArrayList("Male", "Female");
    @FXML
    private AnchorPane recptionist_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gender.setItems(ComboGender);
        con= Database_Connection.Connection();
        
        // TODO
    }    


    @FXML
    private void back_button_Action(ActionEvent event) {
    }

    @FXML
    private void add_button_Action(ActionEvent event) throws SQLException {
        Rname=name.getText().toString();
        Rgender=gender.getValue().toString();
        Rphn= phone.getText().toString();
        Rjoin=joindate.getValue().toString();
        Rpassword=password.getText().toString();
        
        try{
            
            Statement st=con.createStatement();
            String query="insert into Receptionist (R_Name,R_Gender,R_Phone,R_joiningDate,R_Password) \n" +
"values "+Rname+","+Rgender+","+Rphn+","+Rjoin+","+Rpassword;
            st.execute(query);
            
        }catch(Exception e)
        {
            System.out.println("Problem ="+e);
        }
        name.setText("");
        phone.setText("");
        gender.setValue("");
        joindate.setValue(null);
        password.setText("");
       
       
    }
    
}
