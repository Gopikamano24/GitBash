package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(id="dtlview_Last Name")
	private WebElement lastname;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startdate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement actenddate;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgname;
	
	@FindBy(className="dvHeaderText")
	private WebElement header;
	
	public WebElement getHeader() {
		return header;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getActenddate() {
		return actenddate;
	}

	public WebElement getLastname() {
		return lastname;
	}
	 
	public ContactInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
}
