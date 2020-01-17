package br.com.rsinet.Hub_TDD.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_BuscadeProduto_TelaInicial {

	private static WebElement element = null;

	public static WebElement mouse(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='laptopsImg']"));
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
		return element;
	}

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
}