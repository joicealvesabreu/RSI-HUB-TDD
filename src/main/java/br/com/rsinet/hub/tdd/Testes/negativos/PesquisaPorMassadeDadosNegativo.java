package br.com.rsinet.hub.tdd.Testes.negativos;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.PageFactory.PesquisadeProdutoPage;

import br.com.rsinet.hub.tdd.Utility.Utility;

public class PesquisaPorMassadeDadosNegativo {
	 WebDriver driver;
	 ExtentReports extent;
	 ExtentTest logger;
	 ExtentHtmlReporter reporter;
	 PesquisadeProdutoPage produto;
	 DriverFactory Finalizar;
	 
	 
	 @BeforeClass
	 public void report() {
		 ExtentHtmlReporter reporter = new ExtentHtmlReporter("./relatorios/PesquisaMassadedadosNegativo.html");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger = extent.createTest("Teste Pesquisa Negativo");
	 }
	 
	@BeforeMethod
	public  void InicializaBrowser() {
	
		driver = DriverFactory.InicializaDriver();
		produto = PageFactory.initElements(driver, PesquisadeProdutoPage.class);
		
	}
	@Test
	public void testesbusca_Negativo() throws Exception {

		
		produto.Pesquisa();
		produto.ProdutoPesquisado();
		
		String produtoerrado = driver.getCurrentUrl();
		Assert.assertFalse(produtoerrado.contains("https://www.advantageonlineshopping.com/#/search/?viewAll=ehsjfsvgdak"));

		
	
	}
	
	@AfterMethod
	public void finalizar(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {

			String temp =  Utility.getScreenshot(driver);

			logger.pass("Efetuado com Sucesso: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		} else if (result.getStatus() == ITestResult.FAILURE) {
			
			String temp = Utility.getScreenshot(driver);

			logger.fail("Ocorreu um erro: ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		logger.log(Status.PASS, "Não Existe");
		extent.flush();
		
		DriverFactory.FechandoDriver(driver);
		
		
	}

}
