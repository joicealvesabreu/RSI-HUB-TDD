package br.com.rsinet.Hub_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_Buscar {

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
		element = driver.findElement(By.id("3"));
		return element;
	}

	public static WebElement adicionaraocarinho(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@id='Description']//div[2]//span[2]"));
		return element;
	}

	public static WebElement cordoproduto(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}

	public static WebElement carinhopop(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
		return element;
	}

}
