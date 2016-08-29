package controllers;

import play.mvc.*;

import views.html.*;
/**
 * Created by luke on 29/08/16.
 */
public class EventController extends Controller {
    public Result event() {
        return ok("I am an event page");
    }
}
