package com.demo.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class OAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthApplication.class, args);
		try {

			OAuthApplication pkce = new OAuthApplication();

			String codeVerifier = pkce.generateCodeVerifier();
			System.out.println("Code verifier = " + codeVerifier);

			String codeChallenge = pkce.generateCodeChallange(codeVerifier);
			System.out.println("Code challenge = " + codeChallenge);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
			Logger.getLogger(OAuthApplication.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	String generateCodeVerifier() throws UnsupportedEncodingException {
		SecureRandom secureRandom = new SecureRandom();
		byte[] codeVerifier = new byte[32];
		secureRandom.nextBytes(codeVerifier);
		return Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier);
	}

	String generateCodeChallange(String codeVerifier) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] bytes = codeVerifier.getBytes("US-ASCII");
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(bytes, 0, bytes.length);
		byte[] digest = messageDigest.digest();
		return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
	}
}
