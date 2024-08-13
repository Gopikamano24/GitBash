package practice.homepgTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVerification {

	@Test
	public void homepageTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String expectedTitle="Hom";
		String actTitle=driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		System.out.println("--verify--");
		SoftAssert asrt=new SoftAssert();
		//softAssert
		asrt.assertEquals(actTitle, expectedTitle);
		System.out.println("---verified---");
		driver.close();
		asrt.assertAll();
	}
	
	@Test
	public void logoverificationTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean logo=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		System.out.println("---verify---");
		//SoftAssert
		SoftAssert asrt=new SoftAssert();
		asrt.assertTrue(logo);
		System.out.println("---verified---");
		asrt.assertAll();
		driver.close();
		
	}
	
	
	
}
