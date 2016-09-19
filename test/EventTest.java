import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Event;

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
public class EventTest {

    //Create Event Object
    Event testEvent = new Event("Test Event Name", 100.00, 10.00, "My House");

    @Test
    public void testEventName() {
        assertEquals("Test Event Name", testEvent.getEventName());
    }

    @Test
    public void testEventCost() {
        assertEquals(100.00, testEvent.getCost(), 0.0);
    }

    @Test
    public void testEventTotalDonations() {
        assertEquals(10.00, testEvent.getDonationsTotal(), 0.0);
    }

    @Test
    public void testEventVenue() {
        assertEquals("My House", testEvent.getVenue());
    }

    @Test
    public void testPrivateEvent() {
        assertEquals(false, testEvent.getPrivacy());
    }

    @Test
    public void testChangePrivateEvent() {
        testEvent.setPrivacy(true);
        assertEquals(true, testEvent.getPrivacy());
    }

    @Test
    public void testChangeEventName() {
        testEvent.setEventName("New Event Name");
        assertEquals("New Event Name", testEvent.getEventName());
    }

    @Test
    public void testChangeEventCost() {
        testEvent.setCost(50.00);
        assertEquals(50.00, testEvent.getCost(), 0.0);
    }

}
