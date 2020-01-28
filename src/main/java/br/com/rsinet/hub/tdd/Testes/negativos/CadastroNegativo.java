package br.com.rsinet.hub.tdd.Testes.negativos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import br.com.rsinet.hub.tdd.PageFactory.CadastroPage;
import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.Utility.Utility;

public class CadastroNegativo {
	 WebDriver driver;
	 ExtentReports extent;
	 ExtentTest logger, logger1;
	 ExtentHtmlReporter reporter;
	 CadastroPage cadastro;
	 DriverFactory Finalizar;
	 
	 
	 @BeforeClass
	 public void report() {
		 ExtentHtmlReporter reporter = new ExtentHtmlReporter("./relatorios/cadastroNegativo.html");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger = extent.createTest("Teste Cadastro Negativo");
	 }
	 
	@BeforeMethod
	public  void InicializaBrowser() {
	
		driver = DriverFactory.InicializaDriver();
		cadastro = PageFactory.initElements(driver, CadastroPage.class);
		
	}

	@Test
	public void cadastroNegativo() throws Exception {
		

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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		String cadastrojaexiste = driver
				.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
		Assert.assertTrue(cadastrojaexiste.contains("User name already exists"), "User name already exists");
	
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
	
	logger.log(Status.PASS, "Já Existe");
	extent.flush();
	
	DriverFactory.FechandoDriver(driver);
	
	
}
}
