import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Scenario {

	public static void main(String[] args) {


		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hotstar.com/in");
		driver.findElement(By.xpath("//i[@class='icon-search-line soul-icon NAV_ICON_FONT_SIZE']")).click();


	}

}
