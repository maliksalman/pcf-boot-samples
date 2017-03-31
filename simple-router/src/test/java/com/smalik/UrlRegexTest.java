package com.smalik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class UrlRegexTest {

	@Test
	public void testRegex() {
		
		Pattern pattern = Pattern.compile("([^/]*//)([^/]*)(/.*)");
		Matcher matcher = pattern.matcher("http://someserver:8080/somepath/somemorepath/bla;JSESSIONID=143342342342343");
		
		boolean matches = matcher.matches();
		String replacement = null;
		if (matches) {
			replacement =  matcher.group(1) + "someotherserver:1234" + matcher.group(3);
		}
		
		Assert.assertTrue(matches);
		Assert.assertEquals("http://someotherserver:1234/somepath/somemorepath/bla;JSESSIONID=143342342342343", replacement);
	}
}
