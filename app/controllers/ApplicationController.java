package controllers;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import utils.Navbar;
import views.html.*;
import models.*;
import play.*;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
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

    private Navbar getNavbar(){
        String user = session("connected");
        Navbar navbar;
        if(user != null){
            navbar = new Navbar(User.find.byId(Long.parseLong(user)));
        }

        else{
            navbar = new Navbar(formFactory.form(User.class));
        }

        return navbar;
    }

    public Result index() {
        Navbar navbar = getNavbar();
        List<Event> events = new Event.Finder(Integer.class, Event.class).all();
        return ok(index.render(navbar, events));

    }

    public Result createEvent(){
        //takes you to the createEvent page
        List<Event> events = new Event.Finder(Integer.class, Event.class).all();
        Navbar navbar = getNavbar();
        Form<Event> eventForm = formFactory.form(Event.class);
        return ok(createevent.render(navbar, events, eventForm));
    }

    public Result getEvent(int id){
        Navbar navbar = getNavbar();
        Event resultEvent = Event.find.byId(Integer.toUnsignedLong(id));
        return ok(event.render(navbar, resultEvent));
    }

    public Result saveEvent(){
        Form<Event> eventForm = formFactory.form(Event.class).bindFromRequest();
        eventForm.get().save();
        return createEvent();
    }

    public Result allEvents(){
        Navbar navbar = getNavbar();
        List<Event> resultEvents = Event.find.all();

        return ok(allevents.render(navbar, resultEvents));
    }

    public Result login(){
        Map<String, String> userData = formFactory.form(User.class).data();
        String email = userData.get("email");
        String password = userData.get("password");

        List<User> result = User.find.where().ilike("email", email).orderBy("ID asc").findPagedList().getList();

        if(result.get(0).getPassword().equals(password)){
            session("connected", result.get(0).getID().toString());
        }

        else{
            return badRequest();
        }

        return index();
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
