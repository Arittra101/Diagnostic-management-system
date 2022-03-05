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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SC
 */
public class Dr_ListController implements Initializable {

    @FXML
    private TextField DSid;
    @FXML
    private ComboBox<String> DScm;
    @FXML
    private Button DSbtn;

    /**
     * Initializes the controller class.
     */
    Connection con;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_Did;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_DName;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_DPh;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_DSp;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_DVh;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_Dvf;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_DR;
    @FXML
    private TableColumn<Dr_ListInfo, String> TL_DS;
    @FXML
    private TableView<Dr_ListInfo> Dr_TableList;
    String nullType = "Without Type";
    String nullid = "Without Id";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = Database_Connection.Connection();
        DScm.setItems(ComboSpecial);
         DScm.setValue("Without Type");
         DSid.setText("Without Id");
    }

    ObservableList<String> ComboSpecial = FXCollections.observableArrayList("Without Type", "Radiologists", "Neurologists", "Hematologists", "Gastroenterologists",
            "Endocrinologists", "Dermatologists", "Cardiologists");
    ObservableList<Dr_ListInfo> drinfo = FXCollections.observableArrayList();

    @FXML
    private void Search(ActionEvent event) {
        
        refresh_and_fetch();
        
    }

    public void Doctor_info_fetch() {

        String query = "";
        String type = DScm.getValue();
        String Did = DSid.getText();

        if (type.equals(nullType) && Did.equals(nullid)) {
            query = "select * from doctor";
            System.out.println(query);
        } else if (!type.equals(nullType) && Did.equals(nullid)) {
            query = "select * from doctor where  d_type='" + type + "'";
            System.out.println(query);
        } else if (type.equals(nullType) && !Did.equals(nullid)) {
            query = "select * from doctor where  d_ID='" + Did + "' ";
            System.out.println(query);
        } else if (!type.equals(nullType) && !Did.equals(nullid)) {
            query = "select * from doctor where  d_ID='" + Did + "' AND d_type='" + type + "'";
            System.out.println(query);
        }

        System.out.println(query);

        TL_Did.setCellValueFactory(new PropertyValueFactory("D_id"));
        TL_DName.setCellValueFactory(new PropertyValueFactory("D_Name"));
        TL_DPh.setCellValueFactory(new PropertyValueFactory("D_Phone"));
        TL_DSp.setCellValueFactory(new PropertyValueFactory("D_Special"));
        TL_DVh.setCellValueFactory(new PropertyValueFactory("D_VH"));
        TL_Dvf.setCellValueFactory(new PropertyValueFactory("D_vf"));
        TL_DR.setCellValueFactory(new PropertyValueFactory("D_Rnm"));
        TL_DS.setCellValueFactory(new PropertyValueFactory("D_sts"));
        
        try{
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                int id = rs.getInt("d_ID");
                String s_id = String.valueOf(id);
                String d_name = rs.getString("d_Name");
                String d_room = rs.getString("d_RoomNumber");
                String d_phoneNumber = rs.getString("d_phoneNumber");
                String d_visitingFee = rs.getString("d_visitingFee");
                String d_visitHour = rs.getString("d_visitHour");
                String d_discountType = rs.getString("d_discountType");
                String d_special = rs.getString("d_Type");
                String d_Status = rs.getString("d_Status");
                
                 drinfo.add(new Dr_ListInfo(s_id, d_name, d_phoneNumber, d_special, d_visitHour, d_visitingFee, d_room, d_Status));
            }
            Dr_TableList.setItems(drinfo);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    
    public void refresh_and_fetch()
    {
        drinfo.clear();
        Doctor_info_fetch();
        
    }

}
