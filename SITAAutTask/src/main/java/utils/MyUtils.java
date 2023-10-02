package main.java.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MyUtils {
	
	public static String urlEncode(String url) {
		String encodedURL=URLEncoder.encode(url,StandardCharsets.UTF_8);
		return encodedURL;
	}

}
