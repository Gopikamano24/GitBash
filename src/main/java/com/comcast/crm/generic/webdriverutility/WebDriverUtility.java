package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialURL))
				break;
	}
	}
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);

			String actTitle=driver.getTitle();
			if(actTitle.contains(partialTitle))
				break;
	}
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void handlingDropdown(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	public void handlingDropdown(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act=new Actions(driver);
		act.clickAndHold(source).moveToElement(target).click().perform();
	}
    public void mousemoveOnElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	public void scrollDown(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element);
	}
	public void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot"+fileName+".png");
		FileHandler.copy(src, dest);
	}
	public void takeScreenshotToElement(WebDriver driver, String fileName, WebElement element) throws IOException {
		File src=element.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot"+fileName+".png");
		FileHandler.copy(src, dest);
	}
	public void scrollToElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	public void scrollUntilElementBeVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")");
	}
		
}
