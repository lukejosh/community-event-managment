package models;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Sai on 30/08/2016.
 */

@Entity
public class User extends Model {
    public static Finder<Long, User> find = new Finder<Long,User>(User.class);

    @Id
    protected Integer ID;
    protected String email;
    protected String facebook;
    protected String name;
    protected Double donationsToDate; //resets each year
    protected Integer privilege;
    protected String phoneNumber;
    protected String password;
    protected String dietaryRequirements;
    protected Boolean disabilityAccess;
    protected String search;



//    public User (String name, String email, String password){
//        //default constructor
//
//        //TODO get a fresh ID from database
//        this.name = name;
//        this.email = email;
//        this.facebook = "";
//        this.password = password;
//
//        this.phoneNumber = "";
//        this.privilege = 0;
//        this.donationsToDate = 0.0;
//    }
//
//    public User (String name, String email,String password, String phoneNumber){
//        //TODO get fresh ID from database
//        this.name = name;
//        this.email = email;
//        this.facebook = "";
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//
//        this.privilege = 0;
//        this.donationsToDate = 0.0;
//    }

    public Integer getID(){return this.ID;}
    public String getName(){ return this.name;}
    public String getEmail(){return this.email;}
    public String getFacebook(){return this.facebook;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public Double getDonationsToDate(){return this.donationsToDate;}
    public Integer getPrivilege(){return this.privilege;}
    public String getPassword(){return this.password;}
    public String getDietaryRequirements(){ return this.dietaryRequirements;}
    public Boolean getDisabilityAccess(){return this.disabilityAccess;}

    public void setEmail(String email){this.email = email;}
    public void setName(String name){this.name = name;}
    public void setFacebook(String facebook){this.facebook = facebook;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
    public void setPrivilege(Integer privilege){this.privilege = privilege;}
    public void setPassword(String password){this.password = password;}
    public void setDisabilityAccess(Boolean disabilityAccess){this.disabilityAccess = disabilityAccess;}
    public void setDietaryRequirements(String dietaryRequirements){this.dietaryRequirements = dietaryRequirements;}

    public void addDonation(Double donation){
        this.donationsToDate += donation;
    }

    public void resetDonation(){
        this.donationsToDate = 0.0;
    }



}
