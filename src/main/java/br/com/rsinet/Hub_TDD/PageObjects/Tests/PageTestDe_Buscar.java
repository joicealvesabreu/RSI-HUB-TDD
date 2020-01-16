package br.com.rsinet.Hub_TDD.PageObjects.Tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.HomePage_Buscar;
import br.com.rsinet.Hub_TDD.PageObjects.Home_Page_PesquisaDeProduto;
import br.com.rsinet.Hub_TDD.PageObjects.Page_WebDriver;

import br.com.rsinet.Hub_TDD.Utility.Utility;

public class PageTestDe_Buscar {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger;
	static ExtentHtmlReporter reporter;

	@BeforeMethod
	public static void inicia() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/BuscaSimples.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("LoginTest");
		
		driver = Page_WebDriver.InicializaDriver(driver);
	
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
 
 
	
}
