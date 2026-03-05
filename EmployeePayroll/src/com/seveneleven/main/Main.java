// Use Case 03: Payslip Generation
// Collect salary components
// Use PayrollService to calculate deductions
// Generate formatted payslip
// @author: Developer
// @version: 3.0
package com.seveneleven.main;
import com.seveneleven.registration.*;
import com.seveneleven.authentication.*;
import com.seveneleven.payroll.*;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Employee Registartion");
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            Validator.validateEmployeeID(empId);
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            Validator.validateEmail(email);
            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();
            Validator.validatePhone(phone);
            System.out.print("Create Username: ");
            String username = sc.nextLine();
            System.out.print("Create Password: ");
            String password = sc.nextLine();
            System.out.print("Enter role(Employee/Manager):");
			String role=sc.nextLine();
            UserAccount account = new UserAccount(username, password);
            Employee employee = new Employee(empId, name, phone, email, account);
            employee.persist();
            System.out.println("\nEmployee Registered Successfully!");
            System.out.println(employee);

            AuthenticationService auth = new AuthenticationService();
            auth.registerUser(username, password,role);
            System.out.println("\nLogin");
            Session session = auth.login(sc);
            if (session != null) {
                System.out.println(session);

                System.out.println("\nGenerate Payslip");
                System.out.print("Enter Month: ");
                String month = sc.nextLine();
                System.out.print("Enter Basic Salary: ");
                double basic = sc.nextDouble();
                System.out.print("Enter HRA: ");
                double hra = sc.nextDouble();
                System.out.print("Enter DA: ");
                double da = sc.nextDouble();
                System.out.print("Enter Allowances: ");
                double allowances = sc.nextDouble();
                PayrollService payroll = new PayrollService();

                Payslip payslip = payroll.generatePayslip(
                        employee,month, basic,hra,da,allowances
                );
                System.out.println(payslip);
            }

        }
        catch (ValidationException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error saving employee data!");
        }
    }
}