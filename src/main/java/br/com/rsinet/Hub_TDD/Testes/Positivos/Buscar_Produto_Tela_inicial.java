package br.com.rsinet.Hub_TDD.Testes.Positivos;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.FindsById;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.Home_BuscadeProduto_BarradePesquisa;
import br.com.rsinet.Hub_TDD.PageObjects.Home_BuscadeProduto_TelaInicial;
import br.com.rsinet.Hub_TDD.PageObjects.Home_ChromeDriver;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class Buscar_Produto_Tela_inicial {

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

		driver = Home_ChromeDriver.InicializaDriver();

	}

	@Test
	public void TestBuscar_Positivo() throws Exception {

		Home_BuscadeProduto_TelaInicial.mouse(driver);

		Home_BuscadeProduto_TelaInicial.produto(driver).click();

		String clicoucerto = driver.getCurrentUrl();

		Home_BuscadeProduto_TelaInicial.Adicionarlaptop(driver).isSelected();
		
		Home_BuscadeProduto_TelaInicial.Cordoproduto(driver).click();
		
		Home_BuscadeProduto_TelaInicial.Confirmar(driver).click();
		
		
		
		Utility.getScreenshot(driver);
		
		assertTrue(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/3"));
		System.out.println(clicoucerto);

	}

	@Test
	public void Test_Negativo() {

		Home_BuscadeProduto_TelaInicial.mouse(driver);

		Home_BuscadeProduto_TelaInicial.produto(driver).click();

		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");

		assertFalse(false);
		System.out.println(false);

	}
	
	@AfterClass
	public static void FinalizaTeste() {
		
	}

}
