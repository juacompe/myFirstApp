package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result greet(String name) {
		return ok(index.render("Hello " + name + "." ));
	}

}