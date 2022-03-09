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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Gopal Saha
 */
public class Result_ListController implements Initializable {

    @FXML
    private TableColumn<result_list, String> patint_id;
    @FXML
    private TableColumn<result_list, String> test_name;
    @FXML
    private TableColumn<result_list, String> sample_date;
    @FXML
    private TableColumn<result_list, String> deliveryDate;
    @FXML
    private TableColumn<result_list, String> testResult;
    @FXML
    private TableColumn<result_list, String> patho_id;

    Connection con;
     ObservableList<result_list> info = FXCollections.observableArrayList();
    @FXML
    private AnchorPane testResultPane;
    @FXML
    private TableView<result_list> table;
    @FXML
    private TextField bill_patientid;
    @FXML
    private TextField bill_total;
    private TextField bill_discount;
    @FXML
    private TextField bill_payable;
    @FXML
    private TextField discount;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         con = Database_Connection.Connection();
         String query1 = " select  testlist.patient_id,testlist.Test_name,testlist.Test_SamplereciveDate,testlist.Test_DeleverDate,testlist.Tester_id,TestResult.Result  from testList RIGHT JOIN TestResult on testlist.Test_id=TestResult.Test_id";

         info_fetch(query1);
    }  
 
    @FXML
    private void totalBill(ActionEvent event) {
        
        try{
             double dis=Double.parseDouble(discount.getText().toString());
             
        dis=dis/100;
        
         int total=Integer.parseInt(bill_total.getText());
        System.out.println(total);
        double t=total- (total*dis);
        
        bill_payable.setText(String.valueOf(t));
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
       
        

    }

    @FXML
    private void search(ActionEvent event) throws SQLException {
        String s2=bill_patientid.getText().toString();
        String s1="select  testlist.patient_id,testlist.Test_name,testlist.Test_Price,testlist.Test_SamplereciveDate,testlist.Test_DeleverDate,testlist.Tester_id,TestResult.Result\n" +
"from testList INNER JOIN TestResult\n" +
"on testlist.Test_id=TestResult.Test_id AND testlist.patient_id='"+s2+"'";
        info_fetch(s1);
         info_fetch1();     
    }
          

       public void info_fetch(String query) {
           info.clear();
            patint_id.setCellValueFactory(new PropertyValueFactory("patient_id"));
            test_name.setCellValueFactory(new PropertyValueFactory("test_name"));
            sample_date.setCellValueFactory(new PropertyValueFactory("sample_date"));
            deliveryDate.setCellValueFactory(new PropertyValueFactory("delivery_date"));
            testResult.setCellValueFactory(new PropertyValueFactory("result"));
            patho_id.setCellValueFactory(new PropertyValueFactory("petho_id"));
            
            
            
           try{
//            String query = " select  testlist.patient_id,testlist.Test_name,testlist.Test_SamplereciveDate,testlist.Test_DeleverDate,testlist.Tester_id,TestResult.Result  from testList RIGHT JOIN TestResult on testlist.Test_id=TestResult.Test_id";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String pid=rs.getString("patient_id");
                String t_name=rs.getString("Test_name");
                String s_date=rs.getString("Test_SamplereciveDate");
                String d_date=rs.getString("Test_DeleverDate");
                String petho=rs.getString("Tester_id");
                String res=rs.getString("Result");
                
                result_list rst=new result_list(pid,t_name,s_date,d_date,res,petho);
                info.add(rst);
            }
            table.setItems(info);
    
    
           }catch(Exception e)
           {
               System.out.println(e);
           }     
        }
       
        public void info_fetch1() throws SQLException{
            try{
             String pid_bill=bill_patientid.getText().toString();
             String q2="select SUM(testlist.Test_Price) as bill from testList RIGHT JOIN TestResult on testlist.Test_id=TestResult.Test_id group by testlist.patient_id having testlist.patient_id='"+ pid_bill +"'";
             int s = 0;
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(q2);
            while(rs1.next())
            {
                s=Integer.parseInt(rs1.getString("bill"));
            }
            bill_total.setText(String.valueOf(s));
                System.out.println(s);
            
            
            }catch(Exception e)
            {
                System.out.println(e);
            }

        }  

        
    
}
