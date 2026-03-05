package com.seveneleven.dashboard;
public class DashboardFactory {
    public static Dashboard getDashboard(String role) {
        if(role.equals("EMPLOYEE")) {
            return new EmployeeDashboard();
        }
        if(role.equals("MANAGER")) {
            return new ManagerDashboard();
        }
        return null;
    }
}