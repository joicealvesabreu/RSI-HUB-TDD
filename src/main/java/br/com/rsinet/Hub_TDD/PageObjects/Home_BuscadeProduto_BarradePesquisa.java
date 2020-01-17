package br.com.rsinet.Hub_TDD.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_BuscadeProduto_BarradePesquisa {

	private static WebElement element = null;

	public static WebElement Pesquisa(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement ProdutoPesquisado(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement Botaofechar(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
		return element;
	}

	public static WebElement Adicionarlaptop(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='cell categoryRight']//li[@class='ng-scope']"));
		return element;
	}

	public static WebElement Confirmandolaptop(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/div/div[2]/ul/li/div[2]/label"));

		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
		return element;
	}

	public static WebElement Cordolaptop(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='productColor ng-scope colorSelected BLACK']"));

		return element;
	}

	public static WebElement Selecionandoaocarinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}

	public static WebElement Carinhopop(WebDriver driver) {
		element = driver.findElement(By.id("checkOutPopUp"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
		return element;
	}

	public static WebElement Username(WebDriver driver) {
		element = driver.findElement(By.name("usernameInOrderPayment"));
		return element;
	}

	public static WebElement Senha(WebDriver driver) {
		element = driver.findElement(By.name("passwordInOrderPayment"));
		return element;
	}

	public static WebElement Botaoenntrar(WebDriver driver) {
		element = driver.findElement(By.id("login_btnundefined"));
		return element;
	}

	public static WebElement Botaonext(WebDriver driver) {
		element = driver.findElement(By.id("next_btn"));
		return element;
	}

}
