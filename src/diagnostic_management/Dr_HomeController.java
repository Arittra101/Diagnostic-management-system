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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Dr_HomeController implements Initializable {

    @FXML
    private AnchorPane drPane;
    @FXML
    private AnchorPane dr_home;
    
    public static int loginDr;
    
  
    
    Connection con;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // System.out.println("Login Dr "+Dr_HomeController.loginDr);
       con=Database_Connection.Connection();
    }    

    @FXML
    private void apointMentList(ActionEvent event) throws SQLException, IOException {
      Parent pane = FXMLLoader.load(getClass().getResource("ApointmentList.fxml"));
      dr_home.getChildren().setAll(pane);
        
    }

    @FXML
    private void previousPane(ActionEvent event) {
    }

    @FXML
    private void ediit_Profile(ActionEvent event) {
    }

    @FXML
    private void logout_button(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("LogIN.fxml"));
        drPane.getChildren().setAll(pane);
    }
    
}
