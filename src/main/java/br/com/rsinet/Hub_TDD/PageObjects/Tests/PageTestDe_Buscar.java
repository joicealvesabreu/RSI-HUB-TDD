package br.com.rsinet.Hub_TDD.PageObjects.Tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.Hub_TDD.PageObjects.HomePage_Buscar;
import br.com.rsinet.Hub_TDD.PageObjects.Home_Page_PesquisaDeProduto;
import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class PageTestDe_Buscar {

	private static WebDriver driver;

	@BeforeMethod
	public static void inicia() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@Test
	public void TestBuscar_Positivo() throws Exception {

		HomePage_Buscar.mouse(driver);

		HomePage_Buscar.produto(driver).click();

		boolean clicoucerto = driver.getPageSource().contains("3");
		
		Home_Page_PesquisaDeProduto.Adicionarlaptop(driver).isSelected();

		Home_Page_PesquisaDeProduto.Confirmandolaptop(driver);

		Home_Page_PesquisaDeProduto.Cordolaptop(driver).click();

		Home_Page_PesquisaDeProduto.Selecionandoaocarinho(driver).click();

		Home_Page_PesquisaDeProduto.Carinhopop(driver);

		
		Utility.getScreenshot(driver);

		assertTrue(clicoucerto);
		System.out.println(clicoucerto);

	}
	
	@Test 
	public void Test_Negativo() {
		
		
		HomePage_Buscar.mouse(driver);

		HomePage_Buscar.produto(driver).click();

		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");
		
		assertFalse(false);
		System.out.println(false);
		
		
		
	}


	@AfterMethod
	public static void finalizar() {
		driver.quit();

	}
}
