package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass  implements ITestListener, ISuiteListener{

	public  ExtentReports report;
	public  ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		String time=new Date().toString().replace(" ","_").replace(":","_");
		//spark report config
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		//add Env information & create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-50");

		System.out.println("Report Configurtion");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("Report backUp");
	}
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		
		System.out.println("----------------"+result.getMethod().getMethodName()+"-------START------");
		test.log(Status.INFO,result.getMethod().getMethodName()+"----STARTED-----");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("----------------"+result.getMethod().getMethodName()+"-------END--------");
		test.log(Status.PASS,result.getMethod().getMethodName()+"----COMPLETED-----");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot eDriver=(TakesScreenshot)UtilityClassObject.getDriver();
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);

		String time=new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(filePath,testName+" "+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"----FAILED-----");
		test.log(Status.FAIL,result.getThrowable());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		test.log(Status.SKIP,result.getThrowable());
		}
}