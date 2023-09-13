package com.nissan.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {

	// name validation
	public boolean isNameValid(String name) {
		System.out.println("in validation");
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^ A-Za-z]");
			Matcher nameMatcher = namePattern.matcher(name);
			if (nameMatcher.find()) {

				throw new InvalidNameException("Hey! Invalid Name");

			} else {
				bool = true;
				
			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;

	}
}
