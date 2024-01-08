/**
 *
 */
package com.report;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Kumar Jitendra
 *
 */
public class ExtentReportManager {

    static ExtentReports extentReports;
    final static String reportPath = System.getProperty("user.dir")+"/reports/testreport.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    public synchronized static ExtentReports getReporter() {
        if(extentReports == null) {
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
            extentSparkReporter.config().setDocumentTitle("Title of the report");
            extentSparkReporter.config().setReportName("Report Name - Cucumber BDD Sample Report ");
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);

            //add the generic report name - Generic Name Info
            extentReports.setSystemInfo("Team" , "SIT_Functional_Team");
            extentReports.setSystemInfo("Env" , "SIT");
            extentReports.setSystemInfo("Author" , "Kumar Jitendra ");

        }
        return extentReports;
    }

    public static synchronized ExtentTest getTest() {
        if(extentReports == null)
            startTest("testName", "desc");
        return extentTestMap.get((int)(long)(Thread.currentThread()).getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName,desc);
        extentTestMap.put((int)(long) (Thread.currentThread().getId()),test);
        return test;
    }

}
