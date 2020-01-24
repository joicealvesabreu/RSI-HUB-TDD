package br.com.rsinet.Hub_TDD.Testes;

import java.io.IOException;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.Home_BuscadeProduto_BarradePesquisa;
import br.com.rsinet.Hub_TDD.PageObjects.Home_ChromeDriver;
import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.ExcelUtils;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class Buscar_Produto_Por_Barra_de_Pesquisa {

	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;
	private static ExtentHtmlReporter reporter;

	@BeforeClass
	public static void iniciaReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/PesquisaPorMassaDeDados.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	public static void InicializaBrowser() {

		driver = Home_ChromeDriver.InicializaDriver();
	}

	@Test
	public void BuscardeProduto() throws Exception  {

		logger = extent.createTest("BuscardeprodutoCerto");

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");// Chamando o Excel

		Home_BuscadeProduto_BarradePesquisa.Pesquisa(driver).click();

		Home_BuscadeProduto_BarradePesquisa.ProdutoPesquisado(driver)
				.sendKeys(ExcelUtils.getCellData(1, 11) + Keys.ENTER);

		boolean achouNome = driver.getPageSource().contains("HP ZBOOK 17 G2 MOBILE WORKSTATION");

		Home_BuscadeProduto_BarradePesquisa.Adicionarlaptop(driver).isSelected();

		Home_BuscadeProduto_BarradePesquisa.Confirmandolaptop(driver);

		Home_BuscadeProduto_BarradePesquisa.Cordolaptop(driver).click();

		Home_BuscadeProduto_BarradePesquisa.Selecionandoaocarinho(driver).click();

		Home_BuscadeProduto_BarradePesquisa.Carinhopop(driver);

		Home_BuscadeProduto_BarradePesquisa.Username(driver).sendKeys(ExcelUtils.getCellData(1, 1));

		Home_BuscadeProduto_BarradePesquisa.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));

		Home_BuscadeProduto_BarradePesquisa.Botaoenntrar(driver).click();

		Home_BuscadeProduto_BarradePesquisa.Botaonext(driver).click();

		logger.log(Status.INFO, "Buscar o produto do excel");
		logger.log(Status.PASS, "Sucesso");

		Assert.assertTrue(achouNome);
		System.out.println(achouNome);
		extent.flush();
	}

	@Test
	public void testesbusca_Negativo() throws Exception {

		ExtentTest logger1 = extent.createTest("BuscardeprodutoErrado");

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");// Chamando o Excel

		Home_BuscadeProduto_BarradePesquisa.Pesquisa(driver).click();

		Home_BuscadeProduto_BarradePesquisa.ProdutoPesquisado(driver)
				.sendKeys(ExcelUtils.getCellData(1, 11) + Keys.ENTER);

		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");

		Utility.getScreenshot(driver);

		logger1.log(Status.INFO, "Buscar o produto Errado");
		logger1.log(Status.PASS, "nao Encontrou");

		Assert.assertFalse(achouprodutoerrado);
		System.out.println(achouprodutoerrado);
		extent.flush();

	}

	@AfterMethod
	public static void finalizar(ITestResult result) throws IOException {

		Home_ChromeDriver.FechandoDriver(driver);
	}
}
