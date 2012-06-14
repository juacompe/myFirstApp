package test;

import static org.junit.Assert.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import play.mvc.Content;
import play.mvc.Result;

public class FunctionalTest {

	/*
	 * test template 
	 */
	@Test
	public void renderTemplate() {
	  Content html = views.html.index.render("Coco");
	  assertThat(contentType(html)).isEqualTo("text/html");
	  assertThat(contentAsString(html)).contains("Coco");
	}

	/*
	 * test controller
	 */
	@Test
	public void callIndex() {
	    Result result = callAction(
	      controllers.routes.ref.Application.greet("Kiki")
	    );
	    assertThat(status(result)).isEqualTo(OK);
	    assertThat(contentType(result)).isEqualTo("text/html");
	    assertThat(charset(result)).isEqualTo("utf-8");
	    assertThat(contentAsString(result)).contains("Hello Kiki");
	}
}
