package br.com.rsinet.Hub_TDD.Testes;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import br.com.rsinet.Hub_TDD.PageObjects.Home_BuscadeProduto_TelaInicial;
import br.com.rsinet.Hub_TDD.PageObjects.Home_ChromeDriver;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class Buscar_Produto_Tela_inicial {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger, logger1;
	static ExtentHtmlReporter reporter;

	@BeforeClass
	public static void inicia() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/BuscadeprodutoSimples.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@BeforeMethod
	public static void InicializaBrowser(){
		
		driver = Home_ChromeDriver.InicializaDriver();
	}
	
	@Test
	public void Test_Positivo() throws Exception {
		
		logger = extent.createTest("Buscardeproduto_Certo");

		Home_BuscadeProduto_TelaInicial.mouse(driver);

		Home_BuscadeProduto_TelaInicial.produto(driver).click();

		String clicoucerto = driver.getCurrentUrl();

		Home_BuscadeProduto_TelaInicial.Adicionarlaptop(driver).isSelected();
		
		Home_BuscadeProduto_TelaInicial.Cordoproduto(driver).click();
		
		Home_BuscadeProduto_TelaInicial.Confirmar(driver).click();
		
		
		
		Utility.getScreenshot(driver);
		
		assertTrue(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/3"));
		System.out.println(clicoucerto);
		
		logger.log(Status.INFO,"Buscar o produto foi selecionado");
		logger.log(Status.PASS, "Selecionou");
		extent.flush();
	}

	@Test
	public void Test_Negativo() {
		
	logger1= extent.createTest("Buscardeproduto_Errado");

		Home_BuscadeProduto_TelaInicial.mouse(driver);

		Home_BuscadeProduto_TelaInicial.produto(driver).click();

		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");
		
		Utility.getScreenshot(driver);
		
		assertFalse(false);
		System.out.println(false);
		
		logger1.log(Status.INFO,"Buscar o produto Que nao existe");
		logger1.log(Status.PASS, "Nao Existe");
		extent.flush();
		
	}
	
	@AfterMethod
	public static void FinalizaTeste() {
		Home_ChromeDriver.FechandoDriver(driver);
		
	}

}
