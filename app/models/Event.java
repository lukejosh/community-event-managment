package models;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import com.avaje.ebean.Model;

import java.time.LocalDateTime;
import java.util.*;



/**
 * Created by Sai on 29/08/2016.
 */

@Entity
public class Event extends Model{
    @Id
    protected Integer ID;
    protected Integer managerID;
    protected String eventName;
    protected Double cost;
    protected Double donationsTotal;
    protected Date eventDate;
    protected Boolean publicPrivate = false;
    protected String venue;
    protected Integer capacity;
    protected Integer numAttending; // a count of attendees
    protected ArrayList<ArrayList<Integer>> attendeesCurrent; // a register of attendees | format [User ID],[number attending]
    protected TreeMap<Integer, Double> donationsPersonal;   //Int user ID, double for donation
    protected String volunteersNeeded;
    protected String volunteersAcquired;
    protected String imageLink;



    //protected int[] volunteersAcquired;
    public static Finder<Long, Event> find = new Finder<Long,Event>(Event.class);


    public int getID(){return this.ID;}
    public String getEventName() {return this.eventName;}
    public Double getCost() {return this.cost;}
    public Double getDonationsTotal() { return this.donationsTotal;}
    public Date getEventDate(){ return this.eventDate;}
    public Boolean getPrivacy(){return this.publicPrivate;}
    public String getVenue(){ return this.venue;}
    public Integer getCapacity(){ return this.capacity;}
    public ArrayList<ArrayList<Integer>> getAttendeesCurrent(){return this.attendeesCurrent;}
    public TreeMap<Integer, Double> getDonationsPersonal(){return this.donationsPersonal;}
    public Integer getManagerID(){return this.managerID;}
    public String getVolunteersNeeded(){return this.volunteersNeeded;}
    public String getVolunteersAcquired(){return this.volunteersAcquired;}
    public String getImageLink(){return this.imageLink;}
    public Integer getNumAttending() {return numAttending;}


    public void setEventName(String eventName){this.eventName = eventName;}
    public void setCost(Double cost){this.cost = cost;}
    public void setDonationsTotal(Double donationsTotal){this.donationsTotal = donationsTotal;}
    public void setEventDate(Date eventDate){this.eventDate = eventDate;}
    public void setPrivacy(Boolean publicPrivate){this.publicPrivate = publicPrivate;}
    public void setVenue(String venue){this.venue = venue;}
    public void setCapacity(Integer capacity){this.capacity = capacity;}
    public void setImageLink(String imageLink){this.imageLink = imageLink;}
    public void setVolunteersNeeded(String volunteersNeeded){this.volunteersNeeded = volunteersNeeded;}
    public void setVolunteersAcquired(String volunteersAcquired){this.volunteersAcquired = volunteersAcquired;}
    public void setNumAttending(Integer numAttending) {this.numAttending = numAttending;}


    public void addAttendee(Integer userID, Integer numGuests) {
        ArrayList<Integer> attendee = new ArrayList<Integer>();
        attendee.add(userID);
        attendee.add(numGuests);

        this.attendeesCurrent.add(attendee);
    }

    public void addDonation(Integer userID, Double donation) {
        this.donationsTotal += donation;

        if (this.donationsPersonal.containsKey(userID)) {
            Double currentDonation = this.donationsPersonal.get(userID);        //CHECK
            this.donationsPersonal.replace(userID, currentDonation + donation);

        } else {
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
