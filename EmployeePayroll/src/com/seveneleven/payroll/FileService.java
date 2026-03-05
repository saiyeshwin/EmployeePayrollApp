package com.seveneleven.payroll;

import java.io.FileWriter;
import java.io.IOException;

/*
 * UC4: Handles saving payslip to files
 * Generates unique filenames using timestamps
 */

public class FileService {

    // Save payslip as text file
    public String savePayslipAsText(Payslip payslip) throws IOException {

        String fileName =
                "Payslip_" + payslip.getEmpId() + "_"
                        + System.currentTimeMillis() + ".txt";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }

    // Save payslip as pdf (demo version)
    public String savePayslipAsPdf(Payslip payslip) throws IOException {

        String fileName =
                "Payslip_" + payslip.getEmpId() + "_"
                        + System.currentTimeMillis() + ".pdf";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }
}
