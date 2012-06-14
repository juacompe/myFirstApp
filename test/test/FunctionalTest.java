package test;

import static org.junit.Assert.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import play.mvc.Content;
import play.mvc.Result;
import play.test.TestBrowser;

import play.libs.F.*;
import play.mvc.*;
import play.test.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

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
	
	/*
	 * test route
	 */
	@Test
	public void badRoute() {
		Result result = routeAndCall(fakeRequest(GET, "/xx/Kiki"));
		assertThat(result).isNull();
	}
	
/*	@Test
	public void testInServer() {
	  running(testServer(3333), new Callback0() {
	      public void invoke() {
	         assertThat(
	           WS.url("http://localhost:3333").get().get().status
	         ).isEqualTo(OK);
	      }
	  });
	}*/
	
	@Test
	public void runInBrowser() {
	    running(testServer(3333), HTMLUNIT, new Callback<TestBrowser>() {
	        public void invoke(TestBrowser browser) {
	           browser.goTo("http://localhost:3333/guest");
	           assertThat(browser.$("#title").getTexts().get(0)).isEqualTo("Hello Guest");
	           browser.$("a").click();
	           assertThat(browser.url()).isEqualTo("http://localhost:3333/Coco");
//	           assertThat(browser.$("#title", 0).getText()).isEqualTo("Hello Coco");
	        }
	    });
	}
}
