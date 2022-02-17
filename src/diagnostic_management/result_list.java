/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

/**
 *
 * @author Gopal Saha
 */
public class result_list {
    private String patient_id,test_name,sample_date,delivery_date,result,petho_id;

    public result_list(String patient_id, String test_name, String sample_date, String delivery_date, String result, String petho_id) {
        this.patient_id = patient_id;
        this.test_name = test_name;
        this.sample_date = sample_date;
        this.delivery_date = delivery_date;
        this.result = result;
        this.petho_id = petho_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getSample_date() {
        return sample_date;
    }

    public void setSample_date(String sample_date) {
        this.sample_date = sample_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPetho_id() {
        return petho_id;
    }

    public void setPetho_id(String petho_id) {
        this.petho_id = petho_id;
    }
    
}
