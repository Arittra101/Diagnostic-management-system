/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Add_resultController implements Initializable {

    @FXML
    private AnchorPane testResult_Pane;
    @FXML
    private TextField testID;
    @FXML
    private TextField testResult;
    @FXML
    private TextField pathologistID;
    @FXML
    private DatePicker delivaryDate;
    
    String t_id;
    String t_res;
    String petho_id;
    String del_date;
    
    Connection con;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con=Database_Connection.Connection();
        testID.setText(Test_ListController.Test_Id);
        pathologistID.setText(FXMLDocumentController.Path_Id);
        
        
    }    

    @FXML
    private void add_activity(ActionEvent event) throws SQLException {
        t_id=testID.getText().toString();
        t_res=testResult.getText().toString();
        petho_id=pathologistID.getText().toString();
        del_date=delivaryDate.getValue().toString();
        
       
        
        
     try{    
         
        Statement st=con.createStatement();
        String query=" insert into TestResult values('"+t_id+"','"+t_res+"')";
        st.execute(query);
        
        String query2="update testlist set Test_DeleverDate= '"+del_date+"',Tester_id='"+petho_id+"' where Test_id='"+t_id+"'";
        st.execute(query2);
        }catch(Exception e)
        {
            System.out.println("Query 2 "+e);
        }
        testResult.setText("");
        testID.setText("");
    }

    @FXML
    private void back_activity(ActionEvent event) {
        
    }
    
}
