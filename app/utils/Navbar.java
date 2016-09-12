package utils;

import models.User;
import play.data.Form;
import play.data.FormFactory;

import javax.inject.Inject;

/**
 * Created by luke on 5/09/16.
 */
public class Navbar {
    public Form<User> userForm;
    public User loggedInUser;

    public Navbar(User user){
        this.loggedInUser = user;
    }

    public Navbar(Form<User> form){
        userForm = form;
    }
}
