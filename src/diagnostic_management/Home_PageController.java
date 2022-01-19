/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Home_PageController implements Initializable {

   ObservableList<String> use = FXCollections.observableArrayList("Longin/LogOut", "Change PassWord");
      ObservableList<String> rec = FXCollections.observableArrayList("New Patient entry","Old Patient","Payment/Due Collection",
             "Collection History","Patient List","Doctor Referral ","Doctor Referral payment","View all transactions","Expense Entry");
      ObservableList<String> lab1 = FXCollections.observableArrayList("Add test Result","Panding List","Report done Status");
      
        ObservableList<String> admini=FXCollections.observableArrayList("Add user","View User","Add referral Doctor","Referral Doctor Payment","Income");
      
    @FXML
    ComboBox<String> Admini ;
    @FXML
    private ComboBox<String> User;
    @FXML
    private ComboBox<String> Rec;
    @FXML
    private ComboBox<String> Lab;
    @FXML
    private AnchorPane parentpane;
     
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         User.setItems(use);
         Rec.setItems(rec);
         Lab.setItems(lab1);
         Admini.setItems(admini);
        
    }    

    @FXML
    private void Add_patient(ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Add_Patient.fxml"));
        parentpane.getChildren().setAll(pane);
    }   
    
}
