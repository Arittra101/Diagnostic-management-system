/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author SC
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private PasswordField password;
    @FXML
    private TextField uid;
    
    Connection con;
    String U_id;
    String pword; 
    String db_password;
    @FXML
    private AnchorPane longinPane;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         con=Database_Connection.Connection();
    }    

    @FXML
    private void Signin_Button(ActionEvent event) throws SQLException, IOException {
        U_id=uid.getText().toString();
        pword=password.getText().toString();
        
        Statement st= con.createStatement();
        String query="Select A_Password from Admins where A_ID = "+U_id;
        ResultSet rs= st.executeQuery(query);
        while(rs.next())
        {
               db_password=rs.getString("A_Password");
               System.out.println("Password ="+db_password);
        }
        if(db_password.endsWith(pword))
        {
            Parent pane =FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
            longinPane.getChildren().setAll(pane);
        }
        else
        {
         Alert al= new Alert(Alert.AlertType.WARNING);
         al.setTitle("Error");
         al.setContentText("Invalid Username & password");
         al.showAndWait();
        }
     
        
    }
    
}
