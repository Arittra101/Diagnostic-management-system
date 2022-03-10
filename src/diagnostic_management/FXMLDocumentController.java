/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import static java.sql.JDBCType.INTEGER;
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
    
    
    public static String Path_Id;
    private Label label;
    @FXML
    private PasswordField password;
    @FXML
    private TextField uid;
    
  
    
    Connection con;
    String U_id;
    String pword; 
    String db_password;
    String fxml_name;
    String query;
    String Pass_column;
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
        if( Integer.parseInt(U_id)>=100&& Integer.parseInt(U_id)<200)
        {
              query="Select A_Password from Admins where A_ID = "+U_id;
              fxml_name="Home_Page.fxml";
              Pass_column="A_Password";
        } 
        else if(Integer.parseInt(U_id)>=200&& Integer.parseInt(U_id)<300)
        {
          
            query="Select R_Password from Receptionist where R_ID = "+U_id;
            fxml_name="Recep_Home.fxml"; 
            Pass_column="R_Password";
        }
        else if(Integer.parseInt(U_id)>=300&& Integer.parseInt(U_id)<400)
        {
            query="Select d_pass from doctor where d_ID = "+U_id;
            fxml_name="Dr_Home.fxml"; 
            Pass_column="d_pass";
            ApointmentListController.loginDr=Integer.valueOf(U_id);
            
        }
        else if(Integer.parseInt(U_id)>=600&& Integer.parseInt(U_id)<700)
        {
            query="Select p_Password from Pathologist where p_ID = "+U_id;
            fxml_name="Pathologist_Home.fxml"; 
            Pass_column="p_Password";
            Path_Id = U_id;
            
        }
       
        ResultSet rs= st.executeQuery(query);
        while(rs.next())
        {
               db_password=rs.getString(Pass_column);
               System.out.println("Password ="+db_password);
        }
        if(db_password.equals(pword))
        {
            Parent pane =FXMLLoader.load(getClass().getResource(fxml_name));
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
