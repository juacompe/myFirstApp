package test;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import org.junit.Test;

public class TestWithFakeApplication {
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