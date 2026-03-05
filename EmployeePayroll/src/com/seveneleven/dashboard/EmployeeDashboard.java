package com.seveneleven.dashboard;
import java.util.*;
import com.seveneleven.payroll.Payslip;
import com.seveneleven.registration.Employee;
public class EmployeeDashboard implements Dashboard {
    public void display(ArrayList<Payslip> payslips, Employee employee) {
        System.out.println("\nEmployee Dashboard");
        System.out.println("Welcome, " + employee.getName());
        System.out.println("Dashboard Type: " + this.getClass().getName());
        Collections.sort(payslips, (p1, p2) ->
                (int)(p2.getNetPay() - p1.getNetPay()));
        System.out.println("\nRecent Payslips (Top 3):");
        int count = 0;
        for(Payslip p : payslips) {
            if(count == 3) break;
            System.out.println(p.getMonth() + " : " + p.getNetPay());
            count++;
        }
        double total = 0;
        for(Payslip p : payslips) {
            total += p.getNetPay();
        }
        System.out.println("\nYear To Date Earnings: " + total);
    }
}

