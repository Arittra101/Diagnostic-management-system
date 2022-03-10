/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Previous_patientController implements Initializable {

    @FXML
    private AnchorPane PreviousPane;
    @FXML
    private TableView<Dr_apointList> Pre_apoint_table;
    @FXML
    private TableColumn<Dr_apointList, String> Pr_id;
    @FXML
    private TableColumn<Dr_apointList, String> Pr_Name;
    @FXML
    private TableColumn<Dr_apointList, String> Pr_age;
    @FXML
    private TableColumn<Dr_apointList, String> Pre_bloodgroup;
    @FXML
    private TableColumn<Dr_apointList, String> Pre_phoneNum;
    @FXML
    private TableColumn<Dr_apointList, String> Pre_quota;

    Connection con;
    ObservableList<Dr_apointList> PreApoint_info = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           con = Database_Connection.Connection();
           info_fetch();
    }   
    
    
       public void info_fetch() {
        
        
        Pr_id.setCellValueFactory(new PropertyValueFactory("ap_id"));
        Pr_Name.setCellValueFactory(new PropertyValueFactory("ap_name"));
        Pr_age.setCellValueFactory(new PropertyValueFactory("ap_age"));
        Pre_bloodgroup.setCellValueFactory(new PropertyValueFactory("ap_bloodgroup"));
        Pre_phoneNum.setCellValueFactory(new PropertyValueFactory("ap_phn"));
        Pre_quota.setCellValueFactory(new PropertyValueFactory("ap_quota"));
  

        
        
        
        try {
            System.out.println(ApointmentListController.loginDr);
            String query = "select patient.p_ID,patient.p_Name,patient.p_age,p_bloodGrp,patient.p_phoneNumber,patient.p_quota from patient RIGHT JOIN Apointment on patient.p_ID=Apointment.p_ID where Apointment.d_ID='" + ApointmentListController.loginDr + "' and Apointment.Done='1' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                System.out.println("am i");
                    String aId = rs.getString("p_ID");
                   String  aName = rs.getString("p_Name");
                   String aAge = rs.getString("p_age");
                   String aBg = rs.getString("p_bloodGrp");
                   String aPhn = rs.getString("p_phoneNumber");
                   String aQt = rs.getString("p_quota");
                   
                   Dr_apointList dp = new Dr_apointList(aId,aName,aAge,aBg,aPhn,aQt);
                   PreApoint_info.add(dp);
                   
            }
            Pre_apoint_table.setItems(PreApoint_info);
        } catch (Exception e) {
                System.out.println(e);
        }

    }
    
}
