package com.seveneleven.dashboard;
import java.util.ArrayList;

import com.seveneleven.payroll.Payslip;
import com.seveneleven.registration.Employee;
public class ManagerDashboard implements Dashboard {
    public void display(ArrayList<Payslip> payslips, Employee employee) {
        System.out.println("\nManager Dashboard");
        System.out.println("Manager:" + employee.getName());
        System.out.println("Dashboard Type:" + this.getClass().getName());
        double total = 0;
        for(Payslip p : payslips) {
            total += p.getNetPay();
        }
        System.out.println("\nTeam Total Year To Date Earnings: " + total);
    }
}
