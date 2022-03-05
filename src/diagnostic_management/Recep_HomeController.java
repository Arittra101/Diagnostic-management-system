/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.io.IOException;
import java.net.URL;
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
public class Recep_HomeController implements Initializable {


    @FXML
    private AnchorPane Reception_Pane;
    @FXML
    private AnchorPane viewPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void patientList(ActionEvent event) throws IOException {
        try{
              Parent pane=FXMLLoader.load(getClass().getResource("Patient_List.fxml"));
               viewPane.getChildren().setAll(pane);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
           
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("LogIN.fxml"));
            Reception_Pane.getChildren().setAll(pane);
    }

    @FXML
    private void Rec_docList(ActionEvent event) throws IOException {
             Parent pane=FXMLLoader.load(getClass().getResource("Dr_List.fxml"));
            viewPane.getChildren().setAll(pane);
    }

    @FXML
    private void add_patient(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("patientAdd.fxml"));
        viewPane.getChildren().setAll(pane);
    }

    @FXML
    private void testAdd(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Add_test.fxml"));
        viewPane.getChildren().setAll(pane);
    }
    
}
