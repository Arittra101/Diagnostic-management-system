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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Add_DrController implements Initializable {

    @FXML
    private TableView<Dr_info> Dr_Table;

    @FXML
    private TableColumn<Dr_info, String> T_Did;

    @FXML
    private TableColumn<Dr_info, String> T_Dname;

    @FXML
    private TableColumn<Dr_info, String> T_Dpass;

    @FXML
    private TableColumn<Dr_info, String> T_Dphone;

    @FXML
    private TableColumn<Dr_info, String> T_Drn;

    @FXML
    private TableColumn<Dr_info, String> T_Ds;

    @FXML
    private TableColumn<Dr_info, String> T_Dst;

    @FXML
    private TableColumn<Dr_info, String> T_Dvf;

    @FXML
    private TableColumn<Dr_info, String> T_Dvh;

    @FXML
    private Button Dr_Back;

    @FXML
    private Button Dr_InfroDelete;

    @FXML
    private Button Dr_Insert;

    @FXML
    private ComboBox<String> Dr_feeTy;

    @FXML
    private TextField Dr_name;

    @FXML
    private TextField Dr_phnNum;

    @FXML
    private TextField Dr_room;

    @FXML
    private ComboBox<String> Dr_special;

    @FXML
    private ComboBox<String> Dr_status;

    @FXML
    private TextField Dr_visitFee;

    @FXML
    private TextField Dr_visitHour;

    @FXML
    private AnchorPane drPane;

    ObservableList<String> ComboactiveStatus = FXCollections.observableArrayList("Available", "Unavailable");
    ObservableList<String> CombofeeType = FXCollections.observableArrayList("Poor Fee", "Freedom Fighters Fee");
    ObservableList<String> ComboSpecial = FXCollections.observableArrayList("Radiologists", "Neurologists", "Hematologists", "Gastroenterologists", "Endocrinologists", "Dermatologists", "Cardiologists");

    ObservableList<Dr_info> Doctor_info = FXCollections.observableArrayList();

    Connection con;

    String Dname;
    String DroomNumber;
    String DpNumber;
    String DvFee;
    String DvHour;
    String DfeeType;
    String Dtype;
    String Dpassword;

    String DStatus;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Dr_status.setItems(ComboactiveStatus);
        Dr_special.setItems(ComboSpecial);
        Dr_feeTy.setItems(CombofeeType);
        con = Database_Connection.Connection();
        refresh_and_fetch();
    }

    @FXML
    private void Add(ActionEvent event) {

        Dname = Dr_name.getText().toString();
        DroomNumber = Dr_room.getText().toString();
        DpNumber = Dr_phnNum.getText().toString();
        DvFee = Dr_visitFee.getText().toString();
        DvHour = Dr_visitHour.getText().toString();
        DfeeType = Dr_feeTy.getValue().toString();
        Dtype = Dr_special.getValue().toString();
        DStatus = Dr_status.getValue().toString();
        Dpassword=password.getText().toString();

        try {
            Statement st = con.createStatement();
            String add_doctorQuery = "insert into doctor values('" + Dname + "','" + Dtype+ "','" + DroomNumber
                    + "','" + DpNumber + "','" + DvFee + "','" + DvHour + "','" + DfeeType + "','" + DStatus + "','" + Dpassword + "')";

            st.execute(add_doctorQuery);
            refresh_and_fetch();

            System.out.println("Suuceess");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("admini_option.fxml"));
        drPane.getChildren().setAll(pane);
    }

    @FXML
    void delete(ActionEvent event) {
            ObservableList<Dr_info>dlist;
            dlist = Dr_Table.getSelectionModel().getSelectedItems();
            
            String id = dlist.get(0).getD_id();
            String dquery ="Delete from doctor where d_ID = '"+id+"'";
            
        try {
            Statement st =con.createStatement();
            st.execute(dquery);
            refresh_and_fetch();
            
        } catch (SQLException ex) {
            Logger.getLogger(Add_DrController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetch_info() {

        T_Did.setCellValueFactory(new PropertyValueFactory("D_id"));
        T_Dname.setCellValueFactory(new PropertyValueFactory("D_Name"));
        T_Dphone.setCellValueFactory(new PropertyValueFactory("D_Phone"));
        T_Ds.setCellValueFactory(new PropertyValueFactory("D_Special"));
        T_Dvh.setCellValueFactory(new PropertyValueFactory("D_VH"));
        T_Dvf.setCellValueFactory(new PropertyValueFactory("D_vf"));
        T_Drn.setCellValueFactory(new PropertyValueFactory("D_Rnm"));
        T_Dst.setCellValueFactory(new PropertyValueFactory("D_sts"));
        T_Dpass.setCellValueFactory(new PropertyValueFactory("D_ps"));

        try {

            Statement st = con.createStatement();
            String fetchDrInfo_Query = "Select * from doctor";
            ResultSet rs = st.executeQuery(fetchDrInfo_Query);
           

            while (rs.next()) {
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
                String d_pass = rs.getString("d_pass");
                   // System.out.println(d_special);
                Doctor_info.add(new Dr_info(s_id, d_name, d_phoneNumber, d_special, d_visitHour, d_visitingFee, d_room, d_Status, d_pass));

            }
            Dr_Table.setItems(Doctor_info);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void refresh_and_fetch() {
        Doctor_info.clear();
        fetch_info();
    }

}
