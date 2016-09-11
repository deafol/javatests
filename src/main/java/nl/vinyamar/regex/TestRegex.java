package nl.vinyamar.regex;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;


public class TestRegex {


	@Test
	public void testMatch() throws Exception {
		Pattern pattern = Pattern.compile("(release|hotfix)/.+");
		assertTrue(pattern.matcher("hotfix/15.2").find());
		assertTrue(pattern.matcher("release/15.2").find());
	}

	@Test
	public void testSplit() throws Exception {
		String[] result = "hello:world".split(":");
		assertTrue(result.length == 2);

		result = "hello world".split(":");
		assertTrue(result.length == 1);
	}
}
