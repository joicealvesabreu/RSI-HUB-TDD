package br.com.rsinet.Hub_TDD.PageObjects.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.PageObjects.HomePage_Cadastro;

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


		HomePage_Cadastro.clicarmenu(driver).click();
		HomePage_Cadastro.clicarCadastrar(driver).click();
		
		HomePage_Cadastro.nomeUsuario(driver).sendKeys("JoiceNatalice");
		HomePage_Cadastro.emailUsuario(driver).sendKeys("joice_natalice16@hotmail.com");
		HomePage_Cadastro.senhaUsuario(driver).sendKeys("Natalice24");
		HomePage_Cadastro.confirmasenhaUsuario(driver).sendKeys("Natalice24");
		
		HomePage_Cadastro.primeiroNome(driver).sendKeys("joice");
		HomePage_Cadastro.ultimoNome(driver).sendKeys("abreu");
		HomePage_Cadastro.telefoneUsuario(driver).sendKeys("11941707376");
		HomePage_Cadastro.paisUsuario(driver);
		
		HomePage_Cadastro.cidadeUsuario(driver).sendKeys("Taboao da Serra");
		HomePage_Cadastro.enderecoUsuario(driver).sendKeys("Rua Albano Leite");
		HomePage_Cadastro.estadoUsuario(driver).sendKeys("Sao Paulo");
		HomePage_Cadastro.cepUsuario(driver).sendKeys("06773-050");
		
		HomePage_Cadastro.aceitaTermos(driver).isSelected();
		HomePage_Cadastro.aceitatermos2(driver).click();
		HomePage_Cadastro.registraUsuario(driver).click();
	}

	@AfterClass
	public static void finalizar() {
		//driver.quit();

	}

}
