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
public class Admini_optionController implements Initializable {

    @FXML
    private AnchorPane adminiOptionPane;
    @FXML
    private AnchorPane Admini_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add_Doctor(ActionEvent event) throws IOException {
         Parent pane=FXMLLoader.load(getClass().getResource("Add_Dr.fxml"));
         adminiOptionPane.getChildren().setAll(pane);
    }
    
}
