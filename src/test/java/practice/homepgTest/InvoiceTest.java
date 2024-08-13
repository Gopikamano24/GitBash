package practice.homepgTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;


public class InvoiceTest  {

	/*@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoice");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}
	*/
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSimTest() {
		System.out.println("execute createInvoicewithContactTest");
		//Assert.assertEquals(" ", "Login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}
	

}
