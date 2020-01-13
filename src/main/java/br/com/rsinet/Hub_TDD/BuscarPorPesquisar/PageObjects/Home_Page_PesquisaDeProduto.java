package br.com.rsinet.Hub_TDD.BuscarPorPesquisar.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page_PesquisaDeProduto {

	private static WebElement element = null;

	public static WebElement Pesquisa(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement ProdutoPesquisado(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement Adicionarlapto(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]/p"));
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
}