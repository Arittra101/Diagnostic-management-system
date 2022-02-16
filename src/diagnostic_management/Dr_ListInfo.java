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
public class Dr_ListInfo {
    private String D_id,D_Name,D_Phone,D_Special,D_VH,D_vf,D_Rnm,D_sts;

    public Dr_ListInfo(String D_id, String D_Name, String D_Phone, String D_Special, String D_VH, String D_vf, String D_Rnm, String D_sts) {
        this.D_id = D_id;
        this.D_Name = D_Name;
        this.D_Phone = D_Phone;
        this.D_Special = D_Special;
        this.D_VH = D_VH;
        this.D_vf = D_vf;
        this.D_Rnm = D_Rnm;
        this.D_sts = D_sts;
    }
    public String getD_id() {
        return D_id;
    }

    public void setD_id(String D_id) {
        this.D_id = D_id;
    }

    public String getD_Name() {
        return D_Name;
    }

    public void setD_Name(String D_Name) {
        this.D_Name = D_Name;
    }

    public String getD_Phone() {
        return D_Phone;
    }

    public void setD_Phone(String D_Phone) {
        this.D_Phone = D_Phone;
    }

    public String getD_Special() {
        return D_Special;
    }

    public void setD_Special(String D_Special) {
        this.D_Special = D_Special;
    }

    public String getD_VH() {
        return D_VH;
    }

    public void setD_VH(String D_VH) {
        this.D_VH = D_VH;
    }

    public String getD_vf() {
        return D_vf;
    }

    public void setD_vf(String D_vf) {
        this.D_vf = D_vf;
    }

    public String getD_Rnm() {
        return D_Rnm;
    }

    public void setD_Rnm(String D_Rnm) {
        this.D_Rnm = D_Rnm;
    }

    public String getD_sts() {
        return D_sts;
    }

    public void setD_sts(String D_sts) {
        this.D_sts = D_sts;
    }

    
}
