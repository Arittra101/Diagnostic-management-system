/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.sql.Connection;
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

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Add_RecepController implements Initializable {

    @FXML
    private ComboBox<String> Rgender;
    @FXML
    private DatePicker Rjoindate;
    @FXML
    private TextField Rname;
    @FXML
    private TextField Rphone;
    @FXML
    private TextField Rpassword;

    Connection con;
    String name;
    String gender;
    String phn;
    String join;
    String password;
    
     ObservableList<String> ComboGender = FXCollections.observableArrayList("Male", "Female");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          Rgender.setItems(ComboGender);
          con= Database_Connection.Connection();
        
    }    

    @FXML
    private void addButton(ActionEvent event) {
        
         name=Rname.getText().toString();
        gender=Rgender.getValue().toString();
        phn= Rphone.getText().toString();
        join=Rjoindate.getValue().toString();
        password=Rpassword.getText().toString();
        
        try{
            
            Statement st=con.createStatement();
            String query="insert into Receptionist (R_Name,R_Gender,R_Phone,R_joiningDate,R_Password) values ('"+ name+ "','"+gender+"','"+phn+"','"+join+"','"+password+"')";
            st.execute(query);
            
        }catch(Exception e)
        {
            System.out.println("Problem ="+e);
        }
        Rname.setText("");
        Rphone.setText("");
        Rgender.setValue("");
        Rjoindate.setValue(null);
        Rpassword.setText("");
       

        
    }

    @FXML
    private void backButton(ActionEvent event) {
    }
    
}
