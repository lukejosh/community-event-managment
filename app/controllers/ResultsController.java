package controllers;

import models.Event;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.results;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by luke on 29/08/16.
 */
public class ResultsController extends Controller {

    public Result search(){
        Event[] sampleSearchResults = new Event[3];
        sampleSearchResults[0] = new Event("Falls Festival", LocalDateTime.of(2016, 12, 31, 12, 00),
                "North Byron Parklands", 30000, 350.0, new int[5], true);

        sampleSearchResults[1] = new Event("Listen Out Festival", LocalDateTime.of(2016, 12, 31, 12, 00),
                "The Sporting Fields", 5000, 115.0, new int[5], true);

        sampleSearchResults[2] = new Event("Oktoberfest", LocalDateTime.of(2016, 10, 8, 12, 00),
                "Brisbane Showgrounds", 20000, 25, new int[5], true);


        return ok(results.render(Arrays.asList(sampleSearchResults)));
    }
}
