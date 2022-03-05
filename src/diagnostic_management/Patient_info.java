/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagnostic_management;

/**
 *
 * @author SC
 */
public class Patient_info {
    
    private String P_ID,p_Name,p_age,p_bloodGrp,p_gender,p_phoneNumber,p_quota;

    public Patient_info(String P_ID, String p_Name, String p_age, String p_bloodGrp, String p_gender, String p_phoneNumber, String p_quota) {
        this.P_ID = P_ID;
        this.p_Name = p_Name;
        this.p_age = p_age;
        this.p_bloodGrp = p_bloodGrp;
        this.p_gender = p_gender;
        this.p_phoneNumber = p_phoneNumber;
        this.p_quota = p_quota;
    }

    public String getP_ID() {
        return P_ID;
    }

    public void setP_ID(String P_ID) {
        this.P_ID = P_ID;
    }

    public String getP_Name() {
        return p_Name;
    }

    public void setP_Name(String p_Name) {
        this.p_Name = p_Name;
    }

    public String getP_age() {
        return p_age;
    }

    public void setP_age(String p_age) {
        this.p_age = p_age;
    }

    public String getP_bloodGrp() {
        return p_bloodGrp;
    }

    public void setP_bloodGrp(String p_bloodGrp) {
        this.p_bloodGrp = p_bloodGrp;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public String getP_phoneNumber() {
        return p_phoneNumber;
    }

    public void setP_phoneNumber(String p_phoneNumber) {
        this.p_phoneNumber = p_phoneNumber;
    }

    public String getP_quota() {
        return p_quota;
    }

    public void setP_quota(String p_quota) {
        this.p_quota = p_quota;
    }
    
    
}
