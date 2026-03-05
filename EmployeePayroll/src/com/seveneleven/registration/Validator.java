package com.seveneleven.registration;
import java.util.regex.*;
public class Validator {
	public static void validateEmail(String email) throws ValidationException{
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        boolean matched=Pattern.matches(emailRegex, email);
        if(!matched) {
        	throw new ValidationException("Invalid email");
        }
	}
	public static void validatePhone(String phone) throws ValidationException{
		String phoneRegex = "^[6-9]\\d{9}$";
        boolean matched=Pattern.matches(phoneRegex, phone);
        if(!matched) {
        	throw new ValidationException("Invalid phone");
        }
	}
	public static void validateEmployeeID(String employeeID) throws ValidationException{
		String employeeIDRegex = "^EMP-[0-9]{4}$";
        boolean matched=Pattern.matches(employeeIDRegex, employeeID);
        if(!matched) {
        	throw new ValidationException("Invalid employee ID");
        }
	}
}
