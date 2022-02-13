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
public class Dr_apointList {
    private String ap_id,ap_name,ap_age,ap_bloodgroup,ap_phn,ap_quota;

    public Dr_apointList(String ap_id, String ap_name, String ap_age, String ap_bloodgroup, String ap_phn, String ap_quota) {
        this.ap_id = ap_id;
        this.ap_name = ap_name;
        this.ap_age = ap_age;
        this.ap_bloodgroup = ap_bloodgroup;
        this.ap_phn = ap_phn;
        this.ap_quota = ap_quota;
    }

    public String getAp_id() {
        return ap_id;
    }

    public void setAp_id(String ap_id) {
        this.ap_id = ap_id;
    }

    public String getAp_name() {
        return ap_name;
    }

    public void setAp_name(String ap_name) {
        this.ap_name = ap_name;
    }

    public String getAp_age() {
        return ap_age;
    }

    public void setAp_age(String ap_age) {
        this.ap_age = ap_age;
    }

    public String getAp_bloodgroup() {
        return ap_bloodgroup;
    }

    public void setAp_bloodgroup(String ap_bloodgroup) {
        this.ap_bloodgroup = ap_bloodgroup;
    }

    public String getAp_phn() {
        return ap_phn;
    }

    public void setAp_phn(String ap_phn) {
        this.ap_phn = ap_phn;
    }

    public String getAp_quota() {
        return ap_quota;
    }

    public void setAp_quota(String ap_quota) {
        this.ap_quota = ap_quota;
    }
    
    
    
    
}
