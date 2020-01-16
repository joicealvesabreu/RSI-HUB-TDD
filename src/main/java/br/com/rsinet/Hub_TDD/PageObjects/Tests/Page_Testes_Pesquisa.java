package br.com.rsinet.Hub_TDD.PageObjects.Tests;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.Home_Page_PesquisaDeProduto;
import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.ExcelUtils;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class Page_Testes_Pesquisa extends Utility{

	private static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger;
	static ExtentHtmlReporter reporter;

	@BeforeMethod
	public static void inicia() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/PesquisadaLupa.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("LoginTest");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);

	}

	@Test
	public void testesbusca_Positivo() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");// Chamando o Excel

		Home_Page_PesquisaDeProduto.Pesquisa(driver).click();

		Home_Page_PesquisaDeProduto.ProdutoPesquisado(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

		boolean achouNome = driver.getPageSource().contains("HP ZBOOK 17 G2 MOBILE WORKSTATION");

		Home_Page_PesquisaDeProduto.Adicionarlaptop(driver).isSelected();

		Home_Page_PesquisaDeProduto.Confirmandolaptop(driver);

		Home_Page_PesquisaDeProduto.Cordolaptop(driver).click();

		Home_Page_PesquisaDeProduto.Selecionandoaocarinho(driver).click();

		Home_Page_PesquisaDeProduto.Carinhopop(driver);

		Home_Page_PesquisaDeProduto.Username(driver).sendKeys(ExcelUtils.getCellData(1, 1));

		Home_Page_PesquisaDeProduto.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));

		Home_Page_PesquisaDeProduto.Botaoenntrar(driver).click();

		Home_Page_PesquisaDeProduto.Botaonext(driver).click();

		Assert.assertTrue(achouNome);
		System.out.println(achouNome);

	}

	@Test
	public void testesbusca_Negativo() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");// Chamando o Excel

		Home_Page_PesquisaDeProduto.Pesquisa(driver).click();

		Home_Page_PesquisaDeProduto.ProdutoPesquisado(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

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
		driver.quit();
	}
}
