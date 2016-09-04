package controllers;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import models.*;

import javax.inject.Inject;

import java.util.List;

import static play.mvc.Results.ok;

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
        Form<User> userForm = formFactory.form(User.class);
        return ok(index.render(userForm));
    }

    public Result getEvent(int id){
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        Event resultEvent = Event.find.byId(Integer.toUnsignedLong(id));
        return ok(event.render(userForm, resultEvent));
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
}
