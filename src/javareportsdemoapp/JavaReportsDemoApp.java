/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareportsdemoapp;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author parthiban
 */
public class JavaReportsDemoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        System.out.println("Jasper progress");
        String reportSource = "./report/templates/HelloReportWorld.jrxml";
        String reportDest = "./report/results/HelloReportWorld.html";

        Map<String, Object> params = new HashMap<String, Object>();

        try
        {
            JasperReport jasperReport =
                JasperCompileManager.compileReport(reportSource);

            JasperPrint jasperPrint =
                JasperFillManager.fillReport(
                    jasperReport, params, new JREmptyDataSource());

            JasperExportManager.exportReportToHtmlFile(
                jasperPrint, reportDest);

            JasperViewer.viewReport(jasperPrint);
        }

        catch (JRException ex)
        {
            ex.printStackTrace();
        }
        
        System.out.println("Jasper completed");
    }
    
}
