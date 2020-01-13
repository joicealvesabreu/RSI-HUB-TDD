package br.com.rsinet.Hub_TDD.CadastrarCliente.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private static WebElement element;

	public static WebElement clicarmenu(WebDriver driver) {
		element = driver.findElement(By.id("menuUserSVGPath"));
		return element;
	}

	public static WebElement clicarCadastrar(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor ex = (JavascriptExecutor) driver;

		ex.executeScript("arguments[0].click();", element);
		return element;
	}

	public static WebElement nomeUsuario(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		
		return element;
		
	}

	public static WebElement emailUsuario(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}

	public static WebElement senhaUsuario(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}

	public static WebElement confirmasenhaUsuario(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}

	public static WebElement primeiroNome(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		return element;
	}

	public static WebElement ultimoNome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}

	public static WebElement telefoneUsuario(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}

	public static WebElement paisUsuario(WebDriver driver) {
		WebElement element = driver.findElement(By.name("countryListboxRegisterPage"));
		new Select(element).selectByVisibleText("Brazil");
		return element;
	}

	public static WebElement cidadeUsuario(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;
	}

	public static WebElement enderecoUsuario(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}

	public static WebElement estadoUsuario(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}

	public static WebElement cepUsuario(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}

	public static WebElement aceitaTermos(WebDriver driver) {
		element = driver.findElement(By.name("allowOffersPromotion"));
		return element;
	}

	public static WebElement aceitatermos2(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;
	}

	public static WebElement registraUsuario(WebDriver driver) {
		element = driver.findElement(By.id("register_btnundefined"));
		return element;
	}

}
