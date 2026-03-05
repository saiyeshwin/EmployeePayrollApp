// Use Case 05 :Dashboard Display
// DisplayS recent payslips (top 3) AND Show YTD earnings summary
// @author: Developer
// @version: 5.0
package com.seveneleven.main;
import java.io.IOException;
import java.util.*;
import com.seveneleven.registration.*;
import com.seveneleven.authentication.*;
import com.seveneleven.payroll.*;
import com.seveneleven.dashboard.*;
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
            System.out.print("Enter Role (EMPLOYEE / MANAGER): ");
            String role = sc.nextLine();
            UserAccount account = new UserAccount(username,password);
            Employee employee = new Employee(empId,name,phone,email,account);
            employee.persist();
            System.out.println("\nEmployee Registered Successfully!");
            System.out.println(employee);
            AuthenticationService auth = new AuthenticationService();
            auth.registerUser(username,password,role);
            System.out.println("\nLogin");
            Session session = auth.login(sc);
            if(session!=null){
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
                Payslip payslip = payroll.generatePayslip(employee,month,basic,hra,da,allowances);
                System.out.println(payslip);
                System.out.println("\nPayslip Download");
                Payslip original = new Payslip(
                        employee.getEmpID(),
                        employee.getName(),
                        month,
                        payslip.getNetPay()
                );
                System.out.println("\nOriginal Payslip:");
                System.out.println(original);
                try{
                    Payslip cloned = (Payslip)original.clone();
                    if(original.equals(cloned)){
                        System.out.println("Verified: Download copy is equal to original.");
                    }
                    System.out.println("Original hashcode: "+original.hashCode());
                    System.out.println("Cloned hashcode: "+cloned.hashCode());
                    DownloadToken token = new DownloadToken();
                    if(!token.isExpired()){
                        FileService fs = new FileService();
                        String txt = fs.savePayslipAsText(cloned);
                        String pdf = fs.savePayslipAsPdf(cloned);
                        System.out.println("\nPayslip Download Successful.");
                        System.out.println("Saved as text file: "+txt);
                        System.out.println("Saved as pdf file: "+pdf);
                    }
                }
                catch(Exception e){
                    System.out.println("Error during payslip download.");
                }
                System.out.println("\nDashboard Display");
                ArrayList<Payslip> payslips = new ArrayList<>();
                payslips.add(new Payslip(empId,name,"Jan 2026",32000));
                payslips.add(new Payslip(empId,name,"Feb 2026",33000));
                payslips.add(new Payslip(empId,name,"Mar 2026",34000));
                payslips.add(new Payslip(empId,name,"Apr 2026",35000));

                Dashboard dashboard = DashboardFactory.getDashboard(role);

                if(dashboard!=null){
                    dashboard.display(payslips,employee);
                }
            }
        }
        catch(ValidationException e){
            System.out.println("Validation Error: "+e.getMessage());
        }
        catch(IOException e){
            System.out.println("Error saving employee data!");
        }
    }
}
