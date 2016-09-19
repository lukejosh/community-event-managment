import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.User;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

/**
 * Created by Will on 19/09/2016.
 */
public class UserTest {


    //Create User Object
    User testUser = new User("test@mail.com", "Test Name", "0434120472", "safePassword", "fun event");

    @Test
    //Test userEmail
    public void userEmail() {
        assertEquals("test@mail.com", testUser.getEmail());
    }

    @Test
    //test User Name
    public void userName() {
        assertEquals("Test Name", testUser.getName());
    }

    @Test
    //Test Uer Phone Numeber
    public void userPhoneNumber() {
        assertEquals("0434120472", testUser.getPhoneNumber());
    }

    @Test
    //Test user Password
    public void userPassword() {
        assertEquals("0434120472", testUser.getPhoneNumber());
    }

    @Test
    //Test user search
    public void userSearch() {
        assertEquals("fun event", testUser.getSearch());
    }

    //Change User Properties
    @Test
    public void changeUserEmail() {
        testUser.setEmail("newEmail@mail.com");
        assertEquals("newEmail@mail.com", testUser.getEmail());
    }

    @Test
    //Change the user name and ensure it returns correctly
    public void changeUserName() {
        testUser.setName("New Name");
        assertEquals("New Name", testUser.getName());
    }

    @Test
    //Change user phone number
    public void changeUserPhoneNumber() {
        testUser.setPhoneNumber("0423574189");
        assertEquals("0423574189", testUser.getPhoneNumber());
    }

    @Test
    //Change User password
    public void changeUserPassword() {
        testUser.setPassword("hello");
        assertEquals("hello", testUser.getPassword());
    }

    @Test
    //Change User Search
    public void changeUserSearch() {
        testUser.setSearch("new search");
        assertEquals("new search", testUser.getSearch());
    }

    @Test
    //Test User donations
    public void userDonation() {
        assertEquals(0.0, testUser.getDonationsToDate(), 0.0);
    }

    @Test
    //Add a donation
    public void userAddDonation() {
        testUser.addDonation(30.00);
        assertEquals(30.00, testUser.getDonationsToDate(), 0.0);
    }

    @Test
    //Add two donations
    public void userAddDonationTwice() {
        testUser.addDonation(32.00);
        testUser.addDonation(38.00);
        assertEquals(70.00, testUser.getDonationsToDate(), 0.0);
    }

    @Test
    //Add donation and the reset to ensure it equals 0
    public void userResetDonations() {
        testUser.addDonation(30.00);
        testUser.resetDonation();
        assertEquals(0.0, testUser.getDonationsToDate(), 0.0);
    }


}
