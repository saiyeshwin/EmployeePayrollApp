package com.seveneleven.payroll;
public final class Payslip implements Cloneable {
    private final String empId;
    private final String empName;
    private final String month;
    private final double netPay;

    public Payslip(String empId, String empName, String month, double netPay) {
        this.empId = empId;
        this.empName = empName;
        this.month = month;
        this.netPay = netPay;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getMonth() {
        return month;
    }

    public double getNetPay() {
        return netPay;
    }
    public Payslip clone() {
        return new Payslip(empId, empName, month, netPay);
    }
    public boolean equals(Payslip p) {
        return empId.equals(p.empId) && month.equals(p.month);
    }
    public int hashCode() {
        return empId.hashCode() + month.hashCode();
    }
    public String toString() {
        return "PAYSLIP\n"
                + "Employee ID : " + empId + "\n"
                + "Employee Name : " + empName + "\n"
                + "Month : " + month + "\n"
                + "Net Pay : " + netPay + "\n";
    }
}


