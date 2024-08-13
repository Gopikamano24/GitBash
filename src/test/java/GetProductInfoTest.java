import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	
	@Test(dataProvider="getData")
	public void getProductInfoTest (String brandname, String prodname) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture the product price
		String x="//span[text()='"+prodname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getRowCount("product");
		 Object[][] obj=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
			obj[0][0]=elib.getDataFromExcel("product", i+1,0);
			obj[0][1]=elib.getDataFromExcel("product", i+1,1);
		}
		
		return obj;
		
	}
	
}

