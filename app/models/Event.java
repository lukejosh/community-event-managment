package models;

import org.apache.maven.model.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;



/**
 * Created by Sai on 29/08/2016.
 */
public class Event  extends Model {
    public String eventName;
    public Double cost;
    public Double donationsTotal;
    public LocalDateTime eventDateTime;
    public Boolean publicPrivate;
    public String venue;
    public Integer capacity;
    public ArrayList<ArrayList<Integer>> attendeesCurrent; //
    public TreeMap<Integer, Double> donationsPersonal;   //Int user ID, double for donation
    public int[] volunteersNeeded;  //split default into four departments
    public int[] volunteersAcquired;


    /**
     * Constructor sets base event info
     */
    public Event (String eventName){

        /**
         * default constructor
         */
        this.eventName = eventName;

        this.donationsTotal = 0.0;
        this.volunteersAcquired = new int[]{0,0,0,0};
        this.attendeesCurrent = new ArrayList<ArrayList<Integer>>();
        this.donationsPersonal = new TreeMap<Integer, Double>();
    }

    public Event (String eventName, LocalDateTime eventDateTime){
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;

        this.donationsTotal = 0.0;
        this.volunteersAcquired = new int[]{0,0,0,0};
        this.attendeesCurrent = new ArrayList<ArrayList<Integer>>();
        this.donationsPersonal = new TreeMap<Integer, Double>()
    }

    public Event (String eventName, LocalDateTime eventDateTime, String venue, int capacity, double cost, int[] volunteersNeeded, boolean publicPrivate){

        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
        this.publicPrivate = publicPrivate;
        this.venue = venue;
        this.capacity = capacity;
        this.cost = cost;
        this.volunteersNeeded = volunteersNeeded;


        this.donationsTotal = 0.0;
        this.volunteersAcquired = new int[]{0,0,0,0};
        this.attendeesCurrent = new ArrayList<ArrayList<Integer>>();
        this.donationsPersonal = new TreeMap<Integer, Double>();
    }

    /*public String geteventName() {return this.eventName;}
    public Double getCost() {return this.cost;}
    public Double getDonationsTotal() { return this.donationsTotal;}
    public LocalDateTime getEventDateTime(){ return this.eventDateTime;}
    public Boolean getPrivacy(){return this.publicPrivate;}
    public String getVenue(){ return this.venue}
    public Integer getCapacity(){ return this.capacity;}
    public ArrayList<ArrayList<Integer>> getAttendeesCurrent(){return this.attendeesCurrent;}
    public TreeMap<Integer, Double> getDonationsPersonal(){return this.donationsPersonal}
    public int[] getVolunteersNeeded(){return this.volunteersNeeded;}
    public int[] getVolunteersAcquired(){return this.volunteersAcquired;}

    public void setEventName(String eventName){this.eventName = eventName;}
    public void setCost(Double cost){this.cost = cost;}
    public void setDonationsTotal*/// we can just use public variables hey















}
