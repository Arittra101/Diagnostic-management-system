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
public class Pathologist_HomeController implements Initializable {

    @FXML
    private AnchorPane mainPane;
    @FXML
    private AnchorPane pathologist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void test_list(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Test_List.fxml"));
         mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void add_result(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Add_result.fxml"));
         mainPane.getChildren().setAll(pane);
    }

    @FXML
    private void logOutAction(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("LogIN.fxml"));
         pathologist.getChildren().setAll(pane);
    }
    
}
