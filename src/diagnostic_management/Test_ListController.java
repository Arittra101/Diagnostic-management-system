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
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Test_ListController implements Initializable {

    public static String Test_Id;
    Connection con;
      @FXML
    private AnchorPane mainPane;
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

    
    ObservableList<TestInfo> T_info = FXCollections.observableArrayList();
    @FXML
    private Button addresult;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = Database_Connection.Connection();
        System.out.println(FXMLDocumentController.Path_Id);
        refresh_and_fetch(); 
    }

    public void Test_info_fetch() {

        String query = "select testlist.Test_id as Test_Id ,testlist.patient_id  as P_ID,testlist.Test_name \n"
                + "as T_Name,testlist.Test_SamplereciveDate as T_rcv\n"
                + " from testList INNER JOIN TestResult\n"
                + "on testlist.Test_id=TestResult.Test_id";
        
        String query1 = "Select * from doctor ";

        tab_testid.setCellValueFactory(new PropertyValueFactory("t_id"));
        tab_testName.setCellValueFactory(new PropertyValueFactory("t_name"));
        tab_rec.setCellValueFactory(new PropertyValueFactory("t_recive"));
        tab_patient.setCellValueFactory(new PropertyValueFactory("t_pid"));

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
               
                System.out.println("sd");
                String t_id = rs.getString("Test_Id");
                String t_name = rs.getString("T_Name");
                String t_recive = rs.getString("T_rcv");
                String t_pid = rs.getString("P_ID");
        

                T_info.add(new TestInfo(t_id, t_name, t_recive, t_pid));
            }
           
            testList_table.setItems(T_info);
             System.out.println("Dsf");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void refresh_and_fetch() {
        T_info.clear();
        Test_info_fetch();

    }
    
  

    @FXML
    private void Add_result(ActionEvent event) throws IOException {
         ObservableList<TestInfo> sl_info = FXCollections.observableArrayList();
         sl_info = testList_table.getSelectionModel().getSelectedItems();
         Test_Id = sl_info.get(0).getT_id();
         
//         Parent pane=FXMLLoader.load(getClass().getResource("Add_result.fxml"));
//         Stage stage = new Stage();
//         stage.setScene(new Scene(pane));
//         stage.show();
         
        
    }
}
