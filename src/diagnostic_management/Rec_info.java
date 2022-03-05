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
public class Rec_info {

    private String R_ID, R_Name, R_Phone, R_joiningDate, R_ResignDate, R_Password;

    public Rec_info(String R_ID, String R_Name, String R_Phone, String R_joiningDate, String R_ResignDate, String R_Password) {
        this.R_ID = R_ID;
        this.R_Name = R_Name;
        this.R_Phone = R_Phone;
        this.R_joiningDate = R_joiningDate;
        this.R_ResignDate = R_ResignDate;
        this.R_Password = R_Password;
    }

    public String getR_ID() {
        return R_ID;
    }

    public void setR_ID(String R_ID) {
        this.R_ID = R_ID;
    }

    public String getR_Name() {
        return R_Name;
    }

    public void setR_Name(String R_Name) {
        this.R_Name = R_Name;
    }

    public String getR_Phone() {
        return R_Phone;
    }

    public void setR_Phone(String R_Phone) {
        this.R_Phone = R_Phone;
    }

    public String getR_joiningDate() {
        return R_joiningDate;
    }

    public void setR_joiningDate(String R_joiningDate) {
        this.R_joiningDate = R_joiningDate;
    }

    public String getR_ResignDate() {
        return R_ResignDate;
    }

    public void setR_ResignDate(String R_ResignDate) {
        this.R_ResignDate = R_ResignDate;
    }

    public String getR_Password() {
        return R_Password;
    }

    public void setR_Password(String R_Password) {
        this.R_Password = R_Password;
    }

}
