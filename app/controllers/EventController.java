package controllers;

import models.Event;
import play.mvc.*;

import views.html.*;

import java.time.LocalDateTime;

public class EventController extends Controller {
    private Event testEvent = new Event("Test Event", LocalDateTime.of(2016, 10, 10, 12, 00), "Test Venue", 100, 20.50, new int[3], true);
    public Result event() {
        return ok(event.render(testEvent));
    }
}
