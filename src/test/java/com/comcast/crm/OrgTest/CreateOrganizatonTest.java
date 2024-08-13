package com.comcast.crm.OrgTest;
/**
 *  
 */
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.ObjectRepository.OrgPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrgInfoPage;
import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepository.CreateNewOrgPage;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizatonTest extends BaseClass {

	@Test(groups = "ST")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		//generating random number
		int randomnum=jlib.getRandomNumber();

		//read data from excel file
		String orgname = excel.getDataFromExcel("org", 1, 2)+randomnum;


		HomePage hpg=new HomePage(driver);
		hpg.orgClick(driver);
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		OrgPage cpg=new OrgPage(driver);
		cpg.getCreateOrg().click();
		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		CreateNewOrgPage copg=new CreateNewOrgPage(driver);
		copg.createNewOrg(orgname);
		OrgInfoPage opg=new OrgInfoPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "verify the information");
		String headername=opg.getOrgInfoHeader().getText();
		String actorgname=opg.getOrgName().getText();

		//verifying that orgname is displayed or not
		//Assert.assertEquals(headername,orgname);
		
		
	    if(headername.contains(orgname))
			System.out.println(orgname+" is created");
		else
			System.out.println(orgname+" is not created");  
		if(actorgname.equalsIgnoreCase(orgname))
			System.out.println(orgname+" is present in name field");
		else
			System.out.println(orgname+" is not present in name field");

	}
	
	@Test(groups = "RT")
	public void createOrgWithIndustries() throws EncryptedDocumentException, IOException {

		int randomnum=jlib.getRandomNumber();
		String orgname = excel.getDataFromExcel("org", 1, 2)+randomnum;
		String orgtype = excel.getDataFromExcel("org", 7, 4);
		HomePage hpg=new HomePage(driver);
		hpg.orgClick(driver);
		OrgPage cpg=new OrgPage(driver);
		cpg.getCreateOrg().click();
		CreateNewOrgPage copg=new CreateNewOrgPage(driver);
		copg.createNewOrgWithIndustry(orgname, orgtype);
		OrgInfoPage opg=new OrgInfoPage(driver);
		String acttype=opg.getType().getText();

		//verifying that orgtype is displayed or not
		if(acttype.equals(orgtype))
			System.out.println(orgtype+" is present in name field");
		else
			System.out.println(orgtype+" is not present in name field");

	}

	@Test(groups = "RT")
	public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException {

		int randomnum=jlib.getRandomNumber();
		String orgname = excel.getDataFromExcel("org", 1, 2)+randomnum;
		String phone = excel.getDataFromExcel("org", 4, 4);
		HomePage hpg=new HomePage(driver);
		hpg.orgClick(driver);
		OrgPage cpg=new OrgPage(driver);
		cpg.getCreateOrg().click();
		CreateNewOrgPage copg=new CreateNewOrgPage(driver);
		copg.createNewOrgWithPhone(orgname, phone);

		OrgInfoPage opg=new OrgInfoPage(driver);
		String headername=opg.getOrgInfoHeader().getText();
		String actphone=opg.getPhone().getText();

		//verifying that phno is displayed or not
		if(headername.contains(orgname))
			System.out.println(orgname+" is created");
		else
			System.out.println(orgname+" is not created");
		if(phone.equalsIgnoreCase(actphone))
			System.out.println(phone+" is present ");
		else
			System.out.println(phone+" is not present ");

	}
}
