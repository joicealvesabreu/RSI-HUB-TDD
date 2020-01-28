package br.com.rsinet.hub.tdd.Testes.positivos;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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


import br.com.rsinet.hub.tdd.PageFactory.CadastroPage;
import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.Utility.Constant;
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;
import br.com.rsinet.hub.tdd.Utility.Utility;


public class CadrastroPositivo {

	 WebDriver driver;
	 ExtentReports extent;
	 ExtentTest logger, logger1;
	 ExtentHtmlReporter reporter;
	 CadastroPage cadastro;
	 DriverFactory Finalizar;
	 
	 @BeforeClass
	 public void report() {
		 ExtentHtmlReporter reporter = new ExtentHtmlReporter("./relatorios/cadastropositivo.html");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger = extent.createTest("Teste Cadastro positivo");
	 }
	 
	@BeforeMethod
	public  void InicializaBrowser() {
	
		driver = DriverFactory.InicializaDriver();
		cadastro = PageFactory.initElements(driver, CadastroPage.class);
		
	}

	@Test
	public void cadastro1() throws Exception {
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
	
	cadastro.menu();
	cadastro.cadastrar();
	cadastro.usuario();
	cadastro.email();
	cadastro.senha();
	cadastro.confirmarsenha();
	cadastro.primeironome();
	cadastro.ultimonome();
	cadastro.telefone();
	cadastro.pais();
	cadastro.cidade();
	cadastro.endereco();
	cadastro.estado();
	cadastro.cep();
	cadastro.aceitaTermos_1();
	cadastro.aceitatermos_2();
	cadastro.regristra_usuario();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span"))).getText();

	Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(3, 0)));
	Utility.getScreenshot(driver);
	
	
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
		
		logger.log(Status.PASS, "Cadastrou Com Sucesso");
		extent.flush();
		
		DriverFactory.FechandoDriver(driver);
		
		
	}

	

}
