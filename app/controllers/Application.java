package controllers;

import play.*;
import play.api.templates.Html;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result greet(String name) {
		return ok(index.render("Hello " + name + "." ));
	}

	public static Result guest() {
		Html html = new Html("<div id='title'>Hello Guest</div><a href='/Coco'>Greet Coco</a>");
		return ok(main.render("Hello Guest", html));
	}
	
	public static Result coco() {
		Html html = new Html("Hello Coco!");
		return ok(main.render("Hello Coco", html));
	}
	
}