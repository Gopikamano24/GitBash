package practice.homepgTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	public ExtentSparkReporter spark;
	public ExtentReports report;
@Test
public void createContact() {
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	
	TakesScreenshot eDriver=(TakesScreenshot)driver;
	String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test=report.createTest("createContactTest");
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO, "navigate to contact page");
	test.log(Status.INFO, "create Contact");
	if("hdfc".equals("hdfc"))
		test.log(Status.PASS, "contact is created");
	else
		test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
	driver.close();
}
@BeforeSuite
public void configBs() {
	//spark report config
			spark= new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add Env information & create test
			report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "Chrome-50");
			
}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
}
