package com.seveneleven.dashboard;
import java.util.ArrayList;
import com.seveneleven.registration.Employee;
import com.seveneleven.payroll.Payslip;
public interface Dashboard {
    void display(ArrayList<Payslip> payslips, Employee employee);
}
