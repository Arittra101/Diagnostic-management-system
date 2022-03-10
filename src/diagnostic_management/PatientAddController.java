/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class PatientAddController implements Initializable {

    @FXML
    private ComboBox<String> drName;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private ComboBox<String> bloodGroup;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private TextField phone;
    @FXML
    private ComboBox<String> quota;
    @FXML
    private ComboBox<String> type;
    @FXML
    private DatePicker visitingdate;

    ObservableList<String> Combogeder = FXCollections.observableArrayList("Male", "Female");
    ObservableList<String> ComboBlood = FXCollections.observableArrayList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
    ObservableList<String> ComboQuota = FXCollections.observableArrayList("Poor", "Feedom Fighter");
    ObservableList<String> ComboDrName = FXCollections.observableArrayList("Arittra", "Pronay");
    ObservableList<String> ComboDrtype = FXCollections.observableArrayList("Radiologists", "Neurologists", "Hematologists", "Gastroenterologists", "Endocrinologists", "Dermatologists", "Cardiologists");

    String pName;
    String pAge;
    String pGender;
    String pBlood;
    String pQuota;
    String pPhn;
    String pDrName;
    String pDrType;
    LocalDate pVisitDate;
    
    int patient_id=0;
    int doctor_id=0;

    Connection con;
    @FXML
    private AnchorPane addPatientPane;
    @FXML
    private Text AartText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        gender.setItems(Combogeder);
        quota.setItems(ComboQuota);
        bloodGroup.setItems(ComboBlood);
        type.setItems(ComboDrtype);
        drName.setItems(ComboDrName);

        con = Database_Connection.Connection();
    }

    @FXML
    private void addbutton_Action(ActionEvent event) {
        pName = name.getText();
        pAge = age.getText();
        pGender = gender.getValue();
        pBlood = bloodGroup.getValue();
        pQuota = quota.getValue();
        pPhn = phone.getText();
        pDrName = drName.getValue();
        pDrType = type.getValue();
        pVisitDate = visitingdate.getValue();
        System.out.println(pVisitDate);

        try {
            Statement st = con.createStatement();
            String query = "insert into patient values ( '" + pName + "','" + pAge + "','" + pBlood + "','" + pGender + "','" + pPhn + "','" + pQuota + "','" + pDrName + "','" + pDrType + "','"+pVisitDate+"')";
            String query1 ="select d_id from doctor where  d_Name='"+pDrName+"' AND d_type='"+pDrType+"'";
            String query2 ="select p_ID from patient where p_Name='"+pName+"' AND p_age='"+pAge+"' AND p_bloodGrp='"+pBlood+"'";
           
            ResultSet rs1=st.executeQuery(query1);
            while(rs1.next())
            {
                doctor_id=rs1.getInt("d_ID");
            }
            if(doctor_id==0)
            {
                Alert al= new Alert(Alert.AlertType.WARNING);
                 al.setTitle("Error");
                 al.setContentText("Invalid Dr Name & Catago");
                 al.showAndWait();
                 throw new Exception();
            }
            
            st.execute(query);
            
            name.setText("");
            age.setText("");
            gender.setValue("");
            bloodGroup.setValue("");
            quota.setValue("");
            phone.setText("");
            drName.setValue("");
            type.setValue("");
            visitingdate.setValue(LocalDate.now());
            

            
            rs1=st.executeQuery(query2);
            while(rs1.next())
            {
                patient_id=rs1.getInt("p_ID");
            }
            System.out.println("Doctor ID ="+doctor_id);
            System.out.println("Patient ID="+patient_id);
            
            String query3="insert into Apointment  values ('"+patient_id+"','"+doctor_id+"','0')";
            st.execute(query3);
            
            doctor_id=0;
            patient_id=0;
            
        } catch (Exception e) {
            System.out.println("Exception =" + e);
        }
    }

    @FXML
    private void backButton_Action(ActionEvent event) throws IOException
    {
        Parent pane = FXMLLoader.load(getClass().getResource("Recep_view.fxml"));
        addPatientPane.getChildren().setAll(pane);
    }

}
