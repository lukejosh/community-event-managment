package models;

import org.apache.maven.model.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;



/**
 * Created by Sai on 29/08/2016.
 */
public class Event  extends Model {
    protected String eventName;
    protected Double cost;
    protected Double donationsTotal;
    protected LocalDateTime eventDateTime;
    protected Boolean publicPrivate;
    protected String venue;
    protected Integer capacity;
    protected ArrayList<ArrayList<Integer>> attendeesCurrent; //
    protected TreeMap<Integer, Double> donationsPersonal;   //Int user ID, double for donation
    protected int[] volunteersNeeded;  //split default into four departments
    protected int[] volunteersAcquired;


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
        this.donationsPersonal = new TreeMap<Integer, Double>();
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

    public String geteventName() {return this.eventName;}
    public Double getCost() {return this.cost;}
    public Double getDonationsTotal() { return this.donationsTotal;}
    public LocalDateTime getEventDateTime(){ return this.eventDateTime;}
    public Boolean getPrivacy(){return this.publicPrivate;}
    public String getVenue(){ return this.venue;}
    public Integer getCapacity(){ return this.capacity;}
    public ArrayList<ArrayList<Integer>> getAttendeesCurrent(){return this.attendeesCurrent;}
    public TreeMap<Integer, Double> getDonationsPersonal(){return this.donationsPersonal;}


    public void setEventName(String eventName){this.eventName = eventName;}
    public void setCost(Double cost){this.cost = cost;}
    public void setDonationsTotal(Double donationsTotal){this.donationsTotal = donationsTotal;}
    public void setEventDateTime(LocalDateTime eventDateTime){this.eventDateTime = eventDateTime;}
    public void setPrivacy(Boolean publicPrivate){this.publicPrivate = publicPrivate;}
    public void setVenue(String venue){this.venue = venue;}
    public void setCapacity(Integer capacity){this.capacity = capacity;}
    public int[] getVolunteersNeeded(){return this.volunteersNeeded;}
    public int[] getVolunteersAcquired(){return this.volunteersAcquired;}

    public void addAttendee(Integer userID, Integer numGuests){
        ArrayList<Integer> attendee = new ArrayList<Integer>();
        attendee.add(userID);
        attendee.add(numGuests);

        this.attendeesCurrent.add(attendee);
    }

    public void addDonation(Integer userID, Double donation){
        this.donationsTotal += donation;

        if (this.donationsPersonal.containsKey(userID)) {
            Double currentDonation = this.donationsPersonal.get(userID);        //CHECK
            this.donationsPersonal.replace(userID,currentDonation + donation );

        }else{
            this.donationsPersonal.put(userID, donation);
        }

        // TODO add donation to user who donated
        /**
         * create list of users
         *
         * var = get user(userID).donations
         * user(userID).addDonation(Double donation + var )
         */

    }















}
