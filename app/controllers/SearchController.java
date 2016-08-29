package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by luke on 29/08/16.
 */
public class SearchController extends Controller {
    public Result search(){
        return ok("I am a search page");
    }
}
