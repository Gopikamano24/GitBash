package com.comcast.crm.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgListPage {

	//@FindBy(xpath="//table[@class='lvt small']/tbody/tr/td[3]")
	@FindBy(xpath="//a[@title='Organizations']")
	private List<WebElement> orglist;
	
	public OrgListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}



	public List<WebElement> getOrglist() {
		return orglist;
	}
	
	
	
	
	
}
