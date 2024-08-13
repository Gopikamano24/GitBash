package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class BaseClass {
	
	
	public DataBaseUtility dlib=new DataBaseUtility();
	public FileUtility flib= new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtility excel=new ExcelUtility();
	public WebDriver driver=null;
	
	
	
	@BeforeSuite(groups = {"ST", "RT"})
	public void configBS() throws SQLException {
		
		System.out.println("-----connect to db, report config-------");
		dlib.getConnection();
	}
	@AfterSuite(groups = {"ST", "RT"})
	public void configAS() throws SQLException {
		
		System.out.println("------close db, report backup-------");
		dlib.closeConnection();
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"ST", "RT"})
	public void configBC()throws IOException { //String browser) 
		System.out.println("------launch browser-------");
		//String BROWSER=browser;
		String BROWSER =flib.getDataFromPropertiesFile("browser");

		if(BROWSER.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else
			driver=new ChromeDriver();
		UtilityClassObject.setDriver(driver);
		
	}
	@AfterClass(groups = {"ST", "RT"})
	public void configAC() {
		System.out.println("------close browser-------");
		driver.quit();
	}
	@BeforeMethod(groups = {"ST", "RT"})
	public void configBM() throws IOException {
		System.out.println("------login-------");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");

		LoginPage lp=new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups = {"ST", "RT"})
	public void configAM() {
		System.out.println("------logout-------");
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
	}
}
