package br.com.rsinet.hub.tdd.Testes.negativos;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
import br.com.rsinet.hub.tdd.PageFactory.TelaPrincipalPage;

import br.com.rsinet.hub.tdd.Utility.Utility;

public class PesquisaTelaInicialNegativo {
	

	 WebDriver driver;
	 ExtentReports extent;
	 ExtentTest logger, logger1;
	 ExtentHtmlReporter reporter;
	 TelaPrincipalPage pesquisa;
	 DriverFactory Finalizar;
	
	 @BeforeClass
	 public void report() {
		 ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/telaprincipalnegativo.html");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger = extent.createTest("Teste Tela pricipal negativo");
	 }
	 
	@BeforeMethod
	public  void InicializaBrowser() {
	
		driver = DriverFactory.InicializaDriver();
		pesquisa = PageFactory.initElements(driver, TelaPrincipalPage.class);
		
	}

	@Test
	public void cadastro1() throws Exception {

	pesquisa.telaprincipal();
	pesquisa.produto_Laptop();
	String clicoucerto = driver.getCurrentUrl();
	Assert.assertFalse(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/24"));
	pesquisa.Adicionar_Laptop();
	pesquisa.escolhendoCor();
	pesquisa.Confirmando();
	pesquisa.ProdutonoCarinho();
	
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
		
		logger.log(Status.PASS, "erroURl");
		extent.flush();
		
		DriverFactory.FechandoDriver(driver);
		
		
	}

}
