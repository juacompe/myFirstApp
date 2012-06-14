package test;

import models.Computer;

import org.junit.Test;

import play.libs.F.*;
import play.mvc.*;
import play.test.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class SimpleTest {
	@Test
	public void simpleCheck() {
		int a = 1 + 1;
		assertThat(a).isEqualTo(2);
	}
	
	@Test
	public void findById() {
		running(fakeApplication(), new Runnable() {
			
			@Override
			public void run() {
//				TODO realize this test
//				Computer macintosh = Computer.find.byId(21L);
//				assertThat(macintosh.name).isEqualTo("Macintosh");
//				assertThat(formatted(macintosh.introduced)).isEqualTo(
//						"1984-01-24");
			}
		});
	}
}
