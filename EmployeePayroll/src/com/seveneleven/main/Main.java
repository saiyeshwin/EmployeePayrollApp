// Use Case 01: Employee Registration
// Take input from user, Validate input,Create objects,Persist data and Display confirmation
// @author Developer
// @version 1.0
package com.seveneleven.main;
import java.io.IOException;
import java.util.Scanner;

import com.seveneleven.authentication.*;
import com.seveneleven.registration.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Registration");
		try {
			System.out.print("Enter Employee ID(EMP-XXXX):");
			String empId=sc.nextLine();
			Validator.validateEmployeeID(empId);
			System.out.print("Enter Name:");
			String name=sc.nextLine();
			System.out.print("Enter Email: ");
			String email=sc.nextLine();
			Validator.validateEmail(email);
			System.out.print("Enter Phone Number: ");
			String phone=sc.nextLine();
			Validator.validatePhone(phone);
			System.out.print("Create Username: ");
			String username=sc.nextLine();
			System.out.print("Create Password: ");
			String password=sc.nextLine();
			System.out.print("Enter role(Employee/Manager):");
			String role=sc.nextLine();
			UserAccount userAccount=new UserAccount(username, password);
			Employee employee=new Employee(empId, name, phone, email, userAccount);
			employee.persist();
			System.out.println("\nEmployee Registered Successfully!\n");
			System.out.println(employee);
			AuthenticationService auth = new AuthenticationService();
			auth.registerUser(username, password, role);
			System.out.println("\nLogin");
		    Session session = auth.login(sc);
		    if(session != null)
		            System.out.println(session);

		} 
		catch (ValidationException e) {
			System.out.println("\nValidation Failed:" + e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("\nError saving employee data!");
		}
	}
}