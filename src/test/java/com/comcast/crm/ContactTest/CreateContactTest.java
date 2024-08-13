package com.comcast.crm.ContactTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepository.CreateNewContactPage;
import com.comcast.crm.ObjectRepository.CreateNewOrgPage;
import com.comcast.crm.ObjectRepository.ContactInfoPage;
import com.comcast.crm.ObjectRepository.ContactPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrgPage;
import com.comcast.crm.basetest.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test(groups= "ST")
	public void createContactTest() throws EncryptedDocumentException, IOException, InterruptedException {
		int randomnum=jlib.getRandomNumber();
		String lastname = excel.getDataFromExcel("org", 4, 3)+randomnum;
		HomePage hpg=new HomePage(driver);
		hpg.contactClick(driver);
		ContactPage cpg=new ContactPage(driver);
		cpg.createContact();
		CreateNewContactPage cncpg=new CreateNewContactPage(driver);
		cncpg.createNewContact(lastname);
	
		//verifying that orgname is displayed or not
		ContactInfoPage cipg=new ContactInfoPage(driver);
		String actlastname=cipg.getLastname().getText();
		Thread.sleep(2000);
		String actheader=cipg.getHeader().getText();
		//hardassert verifying header of contact page
        boolean header=actheader.contains(lastname);
        System.out.println(header);
        Assert.assertTrue(header);
        System.out.println("---verify header----");
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actlastname, lastname);
        System.out.println("----verified lastname");
        soft.assertAll();
	}

	@Test(groups = "RT")
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {

		int randomnum=jlib.getRandomNumber();
		String lastname = excel.getDataFromExcel("org", 4, 3)+randomnum;

		String currentdate=jlib.getSystemDateYYYYDDMM();
		String reqdate=jlib.getRequiredDateYYYYDDMM(30);
		HomePage hpg=new HomePage(driver);
		hpg.contactClick(driver);
		ContactPage cpg=new ContactPage(driver);
		cpg.createContact();
		CreateNewContactPage cncpg=new CreateNewContactPage(driver);
		cncpg.createNewContactWithSupportDate(lastname, currentdate, reqdate);
		//verifying that support date is displayed or not
		ContactInfoPage cipg=new ContactInfoPage(driver);
		String startdate=cipg.getStartdate().getText();
		String actenddate=cipg.getActenddate().getText();
		if(startdate.equals(currentdate))
			System.out.println(currentdate+ " is verified");
		else
			System.out.println(currentdate+ " is not verified");
		if(actenddate.equals(reqdate))
			System.out.println(reqdate+ " is verified");
		else
			System.out.println(reqdate+ " is not verified");

	}

	@Test(groups = "RT")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {

		int randomnum=jlib.getRandomNumber();
		String orgname = excel.getDataFromExcel("org", 4, 2)+randomnum;
		String contactlastname = excel.getDataFromExcel("org", 4, 3)+randomnum;
		HomePage hpg=new HomePage(driver);
		hpg.getOrg().click();
		OrgPage opg=new OrgPage(driver);
		opg.getCreateOrg().click();
		CreateNewOrgPage copg=new CreateNewOrgPage(driver);
		copg.createNewOrg(orgname);
		Thread.sleep(3000);
		hpg.getContact().click();
		ContactPage cpg=new ContactPage(driver);
		cpg.createContact();
		String parentwd=driver.getWindowHandle();
		CreateNewContactPage cncpg=new CreateNewContactPage(driver);
		cncpg.createNewContactWithOrg(contactlastname, driver, orgname,parentwd);
		ContactInfoPage cipg=new ContactInfoPage(driver);
		String headername1=cipg.getLastname().getText();
		String actorgname=cipg.getOrgname().getText();
		//verifying that contact page is displayed or not
		if(headername1.contains(contactlastname))
			System.out.println(contactlastname+" is created");
		else
			System.out.println(contactlastname+" is not created");
		//verify that organization is visible or not
		if(actorgname.trim().equals(orgname))
			System.out.println(orgname+" is created");
		else
			System.out.println(orgname+" is not created");

	}

}
