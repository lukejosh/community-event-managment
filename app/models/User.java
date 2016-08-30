package models;

import org.apache.maven.model.Model;
import java.util.*;

/**
 * Created by Sai on 30/08/2016.
 */
public class User extends Model {
    public Integer ID;
    public String email;
    public String facebook;
    public String name;
    public Double donationsToDate; //resets each year
    public Integer privilege;
    public String phoneNumber;


    public User (String name, String email){
        //default constructor

        //TODO get a fresh ID from database
        this.name = name;
        this.email = email;
        this.facebook = "";

        this.phoneNumber = "";
        this.privilege = 0;
        this.donationsToDate = 0.0;
    }

    public User (String name, String email, String phoneNumber){
        //TODO get fresh ID from database
        this.name = name;
        this.email = email;
        this.facebook = "";
        this.phoneNumber = phoneNumber;

        this.privilege = 0;
        this.donationsToDate = 0.0;
    }

    public Integer getID(){return this.ID;}
    public String getName(){ return this.name;}
    public String getEmail(){return this.email;}
    public String getFacebook(){return this.facebook;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public Double getDonationsToDate(){return this.donationsToDate;}
    public Integer getPrivilege(){return this.privilege;}


    public void setEmail(String email){this.email = email;}
    public void setName(String name){this.name = name;}
    public void setFacebook(String facebook){this.facebook = facebook;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
    public void setPrivilege(Integer privilege){this.privilege = privilege;}

    public void addDonation(Double donation){
        this.donationsToDate += donation;
    }

    public void resetDonation(){
        this.donationsToDate = 0.0;
    }



}
