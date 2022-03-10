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
public class path_info {
    
    public String Pa_id,Pa_Name,Pa_gen,pa_Joi,pa_pass,pa_phone;

    public path_info(String Pa_id, String Pa_Name, String Pa_gen, String pa_Joi, String pa_pass, String pa_phone) {
        this.Pa_id = Pa_id;
        this.Pa_Name = Pa_Name;
        this.Pa_gen = Pa_gen;
        this.pa_Joi = pa_Joi;
        this.pa_pass = pa_pass;
        this.pa_phone = pa_phone;
    }

    public String getPa_id() {
        return Pa_id;
    }

    public void setPa_id(String Pa_id) {
        this.Pa_id = Pa_id;
    }

    public String getPa_Name() {
        return Pa_Name;
    }

    public void setPa_Name(String Pa_Name) {
        this.Pa_Name = Pa_Name;
    }

    public String getPa_gen() {
        return Pa_gen;
    }

    public void setPa_gen(String Pa_gen) {
        this.Pa_gen = Pa_gen;
    }

    public String getPa_Joi() {
        return pa_Joi;
    }

    public void setPa_Joi(String pa_Joi) {
        this.pa_Joi = pa_Joi;
    }

    public String getPa_pass() {
        return pa_pass;
    }

    public void setPa_pass(String pa_pass) {
        this.pa_pass = pa_pass;
    }

    public String getPa_phone() {
        return pa_phone;
    }

    public void setPa_phone(String pa_phone) {
        this.pa_phone = pa_phone;
    }
    
    
}
