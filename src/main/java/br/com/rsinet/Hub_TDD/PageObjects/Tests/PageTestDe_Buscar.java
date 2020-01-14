package br.com.rsinet.Hub_TDD.PageObjects.Tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.PageObjects.HomePage_Buscar;
import br.com.rsinet.Hub_TDD.Utility.Constant;


public class PageTestDe_Buscar {
	private static WebDriver driver;


	@BeforeClass
	public static void testes() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@Test
	public void Test_Positivo() throws Exception {

		HomePage_Buscar.mouse(driver);

		HomePage_Buscar.produto(driver).click();
		
		boolean clicoucerto = driver.getPageSource().contains("3");
		
		HomePage_Buscar.cordoproduto(driver).click();

		HomePage_Buscar.adicionaraocarinho(driver).click();

		HomePage_Buscar.carinhopop(driver).click();


		assertTrue(clicoucerto);
		System.out.println(clicoucerto);
	}

	@Test
	public void Test_Negativo() throws Exception {
		
		
		HomePage_Buscar.mouse(driver);
		
		HomePage_Buscar.produto(driver).click();
		
		
		HomePage_Buscar.cordoproduto(driver).click();

		HomePage_Buscar.adicionaraocarinho(driver).click();

		HomePage_Buscar.carinhopop(driver).click();

		
	}

	@AfterClass
	public static void finalizar() {
	driver.quit();
	
	}

}
