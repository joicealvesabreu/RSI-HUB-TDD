package br.com.rsinet.Hub_TDD.CadastrarCliente;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCadastro {


	static WebDriver driver;

	//Account Details
	
	 @FindBy(how = How.NAME, using = "usernameRegisterPage")
	 public static WebElement nomeUsuario;

	 @FindBy(how = How.NAME, using = "emailRegisterPage")
	 public static WebElement emailUsuario;

	 @FindBy(how = How.NAME, using = "passwordRegisterPage")
	 public static WebElement senhaUsuario;

	 @FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	 public static WebElement confirmacaoSenhaUsuario;

	

	 @FindBy(how = How.NAME, using = "first_nameRegisterPage")
	 public static WebElement primeiroNome;

	 @FindBy(how = How.NAME, using = "last_nameRegisterPage")
	 public static WebElement ultimoNome;

	 @FindBy(how = How.XPATH, using = "phone_numberRegisterPage")
	public static WebElement telefoneUsuario;

	
	 @FindBy(how = How.XPATH, using = "//*[@id=\'formCover\']/div[3]/div[1]/sec-view[1]/div/select")
	 public static WebElement paisUsuario;

	 @FindBy(how = How.XPATH, using = "//*[@id=\'formCover\']/div[3]/div[1]/sec-view[2]/div/input")
	 public static WebElement cidadeUsuario;

	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[1]/div/input")
	 public static WebElement enderecoUsuario;

	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[2]/div/input")
	 public static WebElement estadoUsuario;

	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[3]/sec-view/div/input")
	 public static WebElement cepUsuario;

	 @FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/sec-view/div/input")
	 public static WebElement aceitaTermos;

	 @FindBy(how = How.ID, using = "register_btnundefined")
	 public static WebElement registraUsuario;

}
