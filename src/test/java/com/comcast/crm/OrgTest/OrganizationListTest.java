package com.comcast.crm.OrgTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OrgListPage;
import com.comcast.crm.generic.fileutility.FileUtility;

public class OrganizationListTest {

	public static void main(String[] args) throws IOException {
		//read data from property file
				FileUtility flib=new FileUtility();
				String URL=flib.getDataFromPropertiesFile("url");
				String BROWSER=flib.getDataFromPropertiesFile("browser");
				String USERNAME=flib.getDataFromPropertiesFile("username");
				String PASSWORD=flib.getDataFromPropertiesFile("password");

				WebDriver driver=null;
				if(BROWSER.equalsIgnoreCase("firefox"))
					driver=new FirefoxDriver();
				else if(BROWSER.equalsIgnoreCase("edge"))
					driver=new EdgeDriver();
				else
					driver=new ChromeDriver();
				
				 
				LoginPage lpg=new LoginPage(driver);
				lpg.login(URL,USERNAME, PASSWORD);
				HomePage hpg=new HomePage(driver);
				hpg.orgClick(driver);
				OrgListPage olpg=new OrgListPage(driver);
				List<WebElement> orglist=olpg.getOrglist();
				for(WebElement list:orglist) {
					System.out.println(list.getText());
				}
				
				hpg.signOut(driver);
				driver.quit();
	}

}
