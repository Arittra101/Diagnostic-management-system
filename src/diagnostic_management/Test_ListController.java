/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Test_ListController implements Initializable {

    @FXML
    private TableView<TestInfo> testList_table;
    @FXML
    private TableColumn<TestInfo, String> tab_testid;
    @FXML
    private TableColumn<TestInfo, String> tab_testName;
    @FXML
    private TableColumn<TestInfo, String> tab_rec;
    @FXML
    private TableColumn<TestInfo, String> tab_patient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
