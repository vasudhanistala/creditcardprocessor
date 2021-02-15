package com.creditcard.springtest.beans.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberConstraintValidator implements ConstraintValidator<CardNumber,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		int nDigits = value.length();
		int nSum = 0;
	    boolean isSecond = false;
	    
	    //code to validate Luhn 10  
	    for (int i = nDigits - 1; i >= 0; i--) 
	    {
	        int d = value.charAt(i) - '0';
	 
	        if (isSecond == true)
	            d = d * 2;
	 
	        // add two digits to handle
	        // cases that make two digits 
	        // after doubling
	        nSum += d / 10;
	        nSum += d % 10;
	 
	        isSecond = !isSecond;
	    }
	    return (nSum % 10 == 0);
	}
}


