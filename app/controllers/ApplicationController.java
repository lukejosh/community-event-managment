package controllers;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import models.*;

import javax.inject.Inject;

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

    public Result event(){
        return ok(event.render());
    }

    public Result saveUser(){
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        User test = userForm.get();
        System.out.println(userForm.toString());
        return index();
    }
}
