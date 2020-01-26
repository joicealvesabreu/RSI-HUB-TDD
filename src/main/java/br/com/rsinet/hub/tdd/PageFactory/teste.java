package br.com.rsinet.hub.tdd.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class teste {
	
	private WebElement element = null;
private	 WebDriver driver;
	
	
	@FindBy(how = How.XPATH, using = "//div[@id='laptopsImg']") 
	private WebElement Clicarimagemlaptop;

	
	
	public void  mouse() {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(Clicarimagemlaptop));
	//	JavascriptExecutor ex = (JavascriptExecutor) driver;
		
	}
	/*

	public static WebElement produto(WebDriver driver) {

		try {
			element = driver.findElement(By.id("3"));

		} catch (Exception e) {
		}
		Assert.assertNotNull(element);
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());

		return element;
	}

	public static WebElement Adicionarlaptop(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='cell categoryRight']//li[@class='ng-scope']"));
		return element;
	}

	public static WebElement Cordoproduto(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='Description']//div[2]//span[1]"));
		return element;
	}

	public static WebElement Confirmar(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}

	public static WebElement Carinhopop(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
		return element;
	} 
	*/
}
