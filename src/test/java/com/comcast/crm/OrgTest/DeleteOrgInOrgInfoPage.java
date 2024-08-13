package com.comcast.crm.OrgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectRepository.CreateNewOrgPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OrgPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DeleteOrgInOrgInfoPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		//read data from property file
				FileUtility flib=new FileUtility();
				String URL=flib.getDataFromPropertiesFile("url");
				String BROWSER=flib.getDataFromPropertiesFile("browser");
				String USERNAME=flib.getDataFromPropertiesFile("username");
				String PASSWORD=flib.getDataFromPropertiesFile("password");
				//generating random number
				JavaUtility jlib=new JavaUtility();
				int randomnum=jlib.getRandomNumber();

				//read data from excel file
				ExcelUtility excel=new ExcelUtility();
				String orgname = excel.getDataFromExcel("org", 1, 2)+randomnum;

				WebDriver driver=null;
				if(BROWSER.equalsIgnoreCase("firefox"))
					driver=new FirefoxDriver();
				else if(BROWSER.equalsIgnoreCase("edge"))
					driver=new EdgeDriver();
				else
					driver=new ChromeDriver();
				WebDriverUtility weblib=new WebDriverUtility();
				 
				LoginPage lpg=new LoginPage(driver);
				lpg.login(URL,USERNAME, PASSWORD);
				HomePage hpg=new HomePage(driver);
				hpg.orgClick(driver);
				OrgPage cpg=new OrgPage(driver);
				cpg.getCreateOrg().click();
				CreateNewOrgPage copg=new CreateNewOrgPage(driver);
				copg.createNewOrg(orgname);
				Thread.sleep(2000);
				hpg.getOrg().click();
				OrgPage opg=new OrgPage(driver);
				opg.getSearchtxt().sendKeys(orgname);
				weblib.handlingDropdown(opg.getSearchDD(), "Organization Name");
				opg.getSearchbtn().click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
				weblib.switchToAlertAndAccept(driver);
				hpg.signOut(driver);
				driver.quit();
	
	}

}
