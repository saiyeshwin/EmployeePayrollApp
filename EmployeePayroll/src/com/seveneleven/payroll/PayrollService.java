package com.seveneleven.payroll;
import com.seveneleven.registration.Employee;
public class PayrollService {
    public Payslip generatePayslip(Employee employee,String month,double basic,double hra,double da,double allowances) {
        SalaryComponents salaryComponents = new SalaryComponents(basic, hra, da, allowances);
        double gross = basic + hra + da + allowances;
        salaryComponents.pf = basic * 0.12;   
        salaryComponents.tax = gross * 0.10; 
        salaryComponents.netPay = gross - (salaryComponents.pf + salaryComponents.tax);
        return new Payslip(employee, salaryComponents, month);
    }
}

