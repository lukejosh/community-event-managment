package models;

import org.apache.maven.model.Model;

import java.time.LocalDateTime;
import java.util.*;

//import java.util.


/**
 * Created by Sai on 29/08/2016.
 */
public class Event  extends Model {
    public String eventName;
    public double cost;
    public double donationsTotal;
    public LocalDateTime eventDateTime;
    public boolean publicPrivate;
    public String venue;
    public int capacity;
    public ArrayList<ArrayList<Integer>> attendeesCurrent; //
    public TreeMap<Integer, Double> donationsPersonal;   //Int user ID, double for donation
    public int[] volunteersNeeded;  //split default into four departments
    public int[] volunteersAcquired;


    /**
     * Constructor sets base event info
     *
     */
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






}
