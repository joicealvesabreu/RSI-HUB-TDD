package br.com.rsinet.Hub_TDD.Testes.Positivos;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
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

	@BeforeMethod
	public static void inicia() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/Pesquisamassadedados.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("LoginTest");
		driver = Home_ChromeDriver.InicializaDriver();
	}

	@Test
	public void testesbusca_Positivo() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");// Chamando o Excel

		Home_BuscadeProduto_BarradePesquisa.Pesquisa(driver).click();

		Home_BuscadeProduto_BarradePesquisa.ProdutoPesquisado(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

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

		Assert.assertTrue(achouNome);
		System.out.println(achouNome);

	}

	@Test
	public void testesbusca_Negativo() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");// Chamando o Excel

		Home_BuscadeProduto_BarradePesquisa.Pesquisa(driver).click();

		Home_BuscadeProduto_BarradePesquisa.ProdutoPesquisado(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

		boolean achouprodutoerrado = driver.getPageSource().contains("HP ZEN BOOK");

		Utility.getScreenshot(driver);

		Assert.assertFalse(achouprodutoerrado);
		System.out.println(achouprodutoerrado);

	}

	@AfterMethod
	public static void finalizar(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);

		logger.fail(result.getThrowable().getMessage(),
				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String temp = Utility.getScreenshot(driver);

			logger.pass("Sucesso", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
	Home_ChromeDriver.FechandoDriver(driver);
	}
}
