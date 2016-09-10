package controllers;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import models.*;
import play.*;
import javax.inject.Inject;
import java.util.List;
import static play.mvc.Results.ok;
import static play.libs.Json.toJson;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApplicationController  extends Controller {

    private FormFactory formFactory;

    @Inject
    public ApplicationController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result index() {
        //Creates a list of events to put into the index page by id
        List<Event> events = new Event.Finder(Integer.class, Event.class).all();

        Form<User> userForm = formFactory.form(User.class);
        return ok(index.render(userForm, events));
    }

    public Result createEvent(){
        //takes you to the createEvent page
        List<Event> events = new Event.Finder(Integer.class, Event.class).all();
        Form<User> userForm = formFactory.form(User.class);
        Form<Event> eventForm = formFactory.form(Event.class);
        return ok(createevent.render(userForm, events, eventForm));
    }

    public Result getEvent(int id){
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        Event resultEvent = Event.find.byId(Integer.toUnsignedLong(id));
        return ok(event.render(userForm, resultEvent));
    }

    public Result saveEvent(){
        Form<Event> eventForm = formFactory.form(Event.class).bindFromRequest();
        eventForm.get().save();
        return createEvent();
    }

    public Result allEvents(){
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        List<Event> resultEvents = Event.find.all();

        return ok(allevents.render(userForm, resultEvents));
    }

    public Result saveUser(){
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        userForm.get().save();
        return index();
    }

    //Code to dynamically grab recent events from the database by primary key integer (id) in sequence (recently added first).

    public Result getRecentEvents(){
        //list of events, all events by primary key (integer).
        List<Event> events = new Event.Finder(Integer.class, Event.class).all();
        //return as the list
        return ok(toJson(events));
    }

}
