/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class ApointmentListController implements Initializable {

    @FXML
    private AnchorPane apointListPane;
    @FXML
    private TableColumn<Dr_apointList, String> id;
    @FXML
    private TableColumn<Dr_apointList, String> name;
    @FXML
    private TableColumn<Dr_apointList, String> age;
    @FXML
    private TableColumn<Dr_apointList, String> bloodgroup;
    @FXML
    private TableColumn<Dr_apointList, String> phoneNum;
    @FXML
    private TableColumn<Dr_apointList, String> quota;

    public static int loginDr;
    Connection con;
    @FXML
    private TableView<Dr_apointList> apoint_table;
    
     ObservableList<Dr_apointList> Apoint_info = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = Database_Connection.Connection();
        refresh_fetch();
    }

    public void info_fetch() {
        
        
        id.setCellValueFactory(new PropertyValueFactory("ap_id"));
        name.setCellValueFactory(new PropertyValueFactory("ap_name"));
        age.setCellValueFactory(new PropertyValueFactory("ap_age"));
        bloodgroup.setCellValueFactory(new PropertyValueFactory("ap_bloodgroup"));
        phoneNum.setCellValueFactory(new PropertyValueFactory("ap_phn"));
        quota.setCellValueFactory(new PropertyValueFactory("ap_quota"));
  

        
        
        
        try {
            System.out.println(ApointmentListController.loginDr);
            String query = "select Apointment.apointment_id, patient.p_ID,patient.p_Name,patient.p_age,p_bloodGrp,patient.p_phoneNumber,patient.p_quota from patient RIGHT JOIN Apointment on patient.p_ID=Apointment.p_ID where d_ID='" + ApointmentListController.loginDr + "' and Apointment.Done='0'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                System.out.println("am i");
                
                    String aId = rs.getString("p_ID");
                   String  aName = rs.getString("p_Name");
                   String apnId = rs.getString("apointment_id");  //here age is ap id
                   String aBg = rs.getString("p_bloodGrp");
                   String aPhn = rs.getString("p_phoneNumber");
                   String aQt = rs.getString("p_quota");
                 
                   
                   Dr_apointList dp = new Dr_apointList(aId,aName,apnId,aBg,aPhn,aQt);
                   Apoint_info.add(dp);
                   
            }
            apoint_table.setItems(Apoint_info);
        } catch (Exception e) {
                System.out.println(e);
        }

    }

    @FXML
    private void AP_Done(ActionEvent event) {
        
        ObservableList<Dr_apointList> Apoint_info = FXCollections.observableArrayList();
        Apoint_info = apoint_table.getSelectionModel().getSelectedItems();
        
        String query = "Update Apointment set Done = '1' where apointment_id='"+Apoint_info.get(0).getAp_age()+"'";
        try{
                Statement st = con.createStatement();
                st.execute(query);
                refresh_fetch();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            
    
       
    }
    
    public void refresh_fetch()
    {
        Apoint_info.clear();
        info_fetch();
    }

}
