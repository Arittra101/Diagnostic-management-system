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
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Gopal Saha
 */
public class Add_testController implements Initializable {

    @FXML
    private TextField patientID;
    @FXML
    private TextField testPrice;
    @FXML
    private DatePicker reciveDate;
    @FXML
    private ComboBox<String> testName;
    
    String patient_id;
    String tPrice;
    String trecive;
    String tName;
    Connection con;
    ObservableList<String> testListCombo=FXCollections.observableArrayList("Urin Test","Blood Test","Covid Test");
    @FXML
    private AnchorPane test_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       con=Database_Connection.Connection();
       testName.setItems(testListCombo);
    
    }    

    @FXML
    private void add_Action(ActionEvent event) throws SQLException {
        patient_id=patientID.getText().toString();
        tName=testName.getValue().toString();
        tPrice=testPrice.getText().toString();
        trecive=reciveDate.getValue().toString();
        int price_test=Integer.valueOf(tPrice);
        Statement st=con.createStatement();
        
        String query="insert into testlist(patient_id,Test_name,Test_Price,Test_SamplereciveDate) values ('"+patient_id+"','"+tName+"','"+price_test+"','"+trecive+"')";
        st.execute(query);
        
        testName.setValue("");
        testPrice.setText("");
        
    }

    @FXML
    private void back_Action(ActionEvent event) throws IOException {
                Parent pane = FXMLLoader.load(getClass().getResource("Recep_view.fxml"));
                test_pane.getChildren().setAll(pane);
    }
    
}
