package br.com.rsinet.hub.tdd.Testes;


import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.PageFactory.PesquisadeProdutoPage;

import br.com.rsinet.hub.tdd.Utility.Utility;

public class Buscar_Produto_Por_Barra_de_Pesquisa {

	static WebDriver driver;
	static PesquisadeProdutoPage lupa;
	static ExtentReports extent;
	static ExtentTest logger, logger1;
	static ExtentHtmlReporter reporter;

	

	

	@BeforeMethod
	public static void InicializaBrowser() {

		driver = DriverFactory.InicializaDriver();
		lupa = PageFactory.initElements(driver, PesquisadeProdutoPage.class);
	}

	@Test
	public void BuscardeProduto() throws Exception  {

		//logger = extent.createTest("BuscardeprodutoCerto");

		lupa.Pesquisa();

		lupa.ProdutoPesquisado();

		boolean achouNome = driver.getPageSource().contains("HP ZBOOK 17 G2 MOBILE WORKSTATION");

		lupa.Adicionarlaptop();

		lupa.Botaofechar();
		
		lupa.Confirmandolaptop();

		lupa.Cordolaptop();

		lupa.Selecionandoaocarinho();

		lupa.Carinhopop();

		Assert.assertTrue(achouNome);
	//	logger.log(Status.PASS, "Sucesso");
	//	extent.flush();
	}

	@Test
	public void testesbusca_Negativo() throws Exception {

	//	ExtentTest logger1 = extent.createTest("BuscardeprodutoErrado");

		lupa.Pesquisa();

		lupa.ProdutoPesquisado();

		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");

		Utility.getScreenshot(driver);

		Assert.assertFalse(achouprodutoerrado);
	//	logger1.log(Status.PASS, "nao Encontrou");
	//	extent.flush();
	}

	@AfterMethod
	public static void finalizar() {

		DriverFactory.FechandoDriver(driver);
	}


}
