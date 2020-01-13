package br.com.rsinet.Hub_TDD.CadastrarCliente.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.CadastrarCliente.PageObjects.HomePage;

import java.util.concurrent.TimeUnit;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class PageCadastro {

	static WebDriver driver;

	@BeforeClass
	public static void testes() {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.advantageonlineshopping.com/#/");

	}

	@Test
	public void Test() throws InterruptedException {


		HomePage.clicarmenu(driver).click();
		HomePage.clicarCadastrar(driver).click();
		
		HomePage.nomeUsuario(driver).sendKeys("JoiceNatalice");
		HomePage.emailUsuario(driver).sendKeys("joice_natalice16@hotmail.com");
		HomePage.senhaUsuario(driver).sendKeys("Natalice24");
		HomePage.confirmasenhaUsuario(driver).sendKeys("Natalice24");
		
		HomePage.primeiroNome(driver).sendKeys("joice");
		HomePage.ultimoNome(driver).sendKeys("abreu");
		HomePage.telefoneUsuario(driver).sendKeys("11941707376");
		HomePage.paisUsuario(driver);
		
		HomePage.cidadeUsuario(driver).sendKeys("Taboao da Serra");
		HomePage.enderecoUsuario(driver).sendKeys("Rua Albano Leite");
		HomePage.estadoUsuario(driver).sendKeys("Sao Paulo");
		HomePage.cepUsuario(driver).sendKeys("06773-050");
		
		HomePage.aceitaTermos(driver).isSelected();
		HomePage.aceitatermos2(driver).click();
		HomePage.registraUsuario(driver).click();
	}

	@AfterClass
	public static void finalizar() {
		//driver.quit();

	}

}
