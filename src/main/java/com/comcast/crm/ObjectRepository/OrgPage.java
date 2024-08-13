package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrg;
	
	@FindBy(name="search_text")
	private WebElement searchtxt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	public OrgPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
}
