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
public class TestInfo {
    
    private String t_id,t_name,t_recive,t_pid;

    public TestInfo(String t_id, String t_name, String t_recive, String t_pid) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_recive = t_recive;
        this.t_pid = t_pid;
    }

    public String getT_id() {
        return t_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_recive() {
        return t_recive;
    }

    public void setT_recive(String t_recive) {
        this.t_recive = t_recive;
    }

    public String getT_pid() {
        return t_pid;
    }

    public void setT_pid(String t_pid) {
        this.t_pid = t_pid;
    }
    
}
