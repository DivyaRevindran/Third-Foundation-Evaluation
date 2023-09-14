package com.nissan.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {

	// name validation
	public boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^ A-Za-z]");
			Matcher nameMatcher = namePattern.matcher(name);
			if (nameMatcher.find()) {

				throw new InvalidNameException("Hey! Invalid Name");

			} 
			
			else if(name.length()>30) {
				throw new InvalidNameException("Hey! Invalid Name");
			}
			
			else {
				bool = true;

			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;

	}

	public boolean checkAccNumber(int accNo) {
		String acNo=Integer.toString(accNo);
		boolean bool = false;
		try {
			Pattern pattern = Pattern.compile("[^0-9]");

			Matcher matcher = pattern.matcher(acNo);
			boolean finder = matcher.find();
			if (finder) {
				throw new Exception("Hey! Invalid account Number");
			} else if (acNo.length() != 9) {
				throw new Exception("Hey! Invalid account Number");
			} else {
				bool = true;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return bool;
	}

	public boolean checkMobileNumber(String mob) {
		boolean bool = false;
		try {

			Pattern pattern = Pattern.compile("[^0-9]");

			Matcher matcher = pattern.matcher(mob);
			boolean finder = matcher.find();
			if (finder) {
				throw new Exception("Hey! Invalid Mobile Number");
			} else if (mob.length() != 10) {
				throw new Exception("Hey! Invalid Mobile Number");
			} else {
				bool = true;
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return bool;

	}
}
