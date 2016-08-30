package models;

import org.apache.maven.model.Model;
import java.util.*;

/**
 * Created by Sai on 30/08/2016.
 */
public class User extends Model {
    public String email;
    public String facebook;
    public String name;
    public Double donationsToDate; //resets each year
    public Integer privilege;
    public String phoneNumber;


    public User (String name, String email){
        //default constructor

        this.name = name;
        this.email = email;
        this.facebook = "";

        this.phoneNumber = "";
        this.privilege = 0;
        this.donationsToDate = 0.0;
    }

    public User (String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.facebook = "";
        this.phoneNumber = phoneNumber;

        this.privilege = 0;
        this.donationsToDate = 0.0;
    }



}
