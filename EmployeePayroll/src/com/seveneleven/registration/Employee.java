package com.seveneleven.registration;
import java.io.*;
public class Employee {
	private String empID;
	private String name;
	private String phone;
	private String email;
	private UserAccount account;
	public Employee(String empID, String name, String phone, String email, UserAccount account) {
		this.empID = empID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.account = account;
	}
	public String toString() {
		return "EmpID=" + empID + "\nName=" + name + "\nPhone=" + phone + "\nEmail=" + email;
	}
	public void persist() throws IOException {
		 FileWriter fw = new FileWriter("employee_data.txt", true);
	     fw.write(this.toString() + "\n");
	     fw.close();
	}
}
