package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage {

	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="support_start_date")
	private WebElement startdate;
	
	@FindBy(name="support_end_date")
	private WebElement enddate;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement org;
	
	@FindBy(name="search_text")
	private WebElement searchfield;
	
	@FindBy(name="search")
	private WebElement searchbtn;

	
	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getOrg() {
		return org;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public CreateNewContactPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact(String Lastname) {
		lastname.sendKeys(Lastname);
		savebtn.click();
	}
	public void createNewContactWithSupportDate(String Lastname, String currentdate, String reqdate) {
		lastname.sendKeys(Lastname);
		startdate.clear();
		startdate.sendKeys(currentdate);
		enddate.clear();
		enddate.sendKeys(reqdate);
		savebtn.click();
	}
	
	public void createNewContactWithOrg(String Lastname, WebDriver driver, String orgname, String parentwd) {
		lastname.sendKeys(Lastname);
		org.click();
		WebDriverUtility weblib=new WebDriverUtility();
		weblib.switchToTabOnTitle(driver,"Accounts&action");
		searchfield.sendKeys(orgname);
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(parentwd);
		savebtn.click();
		
	}
	
	
	
	
	
	
}
