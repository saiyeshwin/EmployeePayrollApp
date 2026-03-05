package com.seveneleven.authentication;
import java.util.*;
public class AuthenticationService {
    private Map<String,User> users = new HashMap<>();
    private int maxAttempts = 3;
    public void registerUser(String username,String password,String role){
        if(role.equalsIgnoreCase("EMPLOYEE")){
            users.put(username,new RegularEmployee(username,password));
        }
        else if(role.equalsIgnoreCase("MANAGER")){
            users.put(username,new Manager(username,password));
        }
        System.out.println("User registered successfully!");
    }
    public Session login(Scanner sc){
        int attempts = 0;
        while(attempts < maxAttempts){
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            User user = users.get(username);
            if(user != null && user.authenticate(username,password)){
                System.out.println("Login Successful!");
                System.out.println("Role: " + user.getRole());
                Session session = new Session(username);
                showDashboard(user.getRole());
                return session;
            }
            attempts++;
            System.out.println("Invalid credentials. Attempts left: " + (maxAttempts-attempts));
        }
        System.out.println("Max login attempts reached.");
        return null;
    }
    private void showDashboard(String role){
        System.out.println("\nDashboard");
        if(role.equals("EMPLOYEE")){
            System.out.println("Employee Dashboard");
//            System.out.println("View Payslip | Update Profile");
        }
        else{
            System.out.println("Manager Dashboard");
//            System.out.println("Approve Leaves | View Reports");
        }
    }
}
