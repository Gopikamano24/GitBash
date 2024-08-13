package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	@FindBy(id="dtlview_Organization Name")
	private WebElement OrgName;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgInfoHeader;
	@FindBy(id="dtlview_Phone")
	private WebElement phone;
	@FindBy(id="mouseArea_Type")
	private WebElement type;
	
	public OrgInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getType() {
		return type;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getOrgInfoHeader() {
		return OrgInfoHeader;
	}
	public WebElement getOrgName() {
		return OrgName;
	}
	
  
}
