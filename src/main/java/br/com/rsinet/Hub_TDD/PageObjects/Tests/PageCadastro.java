package br.com.rsinet.Hub_TDD.PageObjects.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.HomePage_Cadastro;
import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.Utility;


public class PageCadastro {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger;
	static ExtentHtmlReporter reporter;

	@BeforeMethod
	public static void testes() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/Cadastro2.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("LoginTest");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get(Constant.URL);

	}
	@org.testng.annotations.Test
	public void cadastro_realizado_com_sucesso() throws InterruptedException {
		
	HomePage_Cadastro.clicarmenu(driver).click();
	HomePage_Cadastro.clicarCadastrar(driver).click();

	HomePage_Cadastro.nomeUsuario(driver).sendKeys("JoiceCarvajjj");
	HomePage_Cadastro.emailUsuario(driver).sendKeys("joice_natalice16@hotmail.com");
	HomePage_Cadastro.senhaUsuario(driver).sendKeys("Natalice22");
	HomePage_Cadastro.confirmasenhaUsuario(driver).sendKeys("Natalice22");

	HomePage_Cadastro.primeiroNome(driver).sendKeys("joice");
	HomePage_Cadastro.ultimoNome(driver).sendKeys("abreu");
	HomePage_Cadastro.telefoneUsuario(driver).sendKeys("11941707376");
	HomePage_Cadastro.paisUsuario(driver);

	HomePage_Cadastro.cidadeUsuario(driver).sendKeys("Taboao da Serra");
	HomePage_Cadastro.enderecoUsuario(driver).sendKeys("Rua Albano Leite");
	HomePage_Cadastro.estadoUsuario(driver).sendKeys("Sao Paulo");
	HomePage_Cadastro.cepUsuario(driver).sendKeys("06773-050");

	HomePage_Cadastro.aceitaTermos(driver).isSelected();
	HomePage_Cadastro.aceitatermos2(driver).click();
	HomePage_Cadastro.registraUsuario(driver).click();
	 
	Thread.sleep(10000);
	
    String cadastrorealizadocomsucesso = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")).getText();
	Assert.assertTrue(cadastrorealizadocomsucesso.contains("JoiceCarvajjj"),"JoiceCarvajjj");
	Utility.getScreenshot(driver);
	
}

	@org.testng.annotations.Test
	public void cadastrojaExistente() {
		
	HomePage_Cadastro.clicarmenu(driver).click();
	HomePage_Cadastro.clicarCadastrar(driver).click();

	HomePage_Cadastro.nomeUsuario(driver).sendKeys("JoiceNatalice");
	HomePage_Cadastro.emailUsuario(driver).sendKeys("joice_natalice16@hotmail.com");
	HomePage_Cadastro.senhaUsuario(driver).sendKeys("Natalice24");
	HomePage_Cadastro.confirmasenhaUsuario(driver).sendKeys("Natalice24");

	HomePage_Cadastro.primeiroNome(driver).sendKeys("joice");
	HomePage_Cadastro.ultimoNome(driver).sendKeys("abreu");
	HomePage_Cadastro.telefoneUsuario(driver).sendKeys("11941707376");
	HomePage_Cadastro.paisUsuario(driver);

	HomePage_Cadastro.cidadeUsuario(driver).sendKeys("Taboao da Serra");
	HomePage_Cadastro.enderecoUsuario(driver).sendKeys("Rua Albano Leite");
	HomePage_Cadastro.estadoUsuario(driver).sendKeys("Sao Paulo");
	HomePage_Cadastro.cepUsuario(driver).sendKeys("06773-050");

	HomePage_Cadastro.aceitaTermos(driver).isSelected();
	HomePage_Cadastro.aceitatermos2(driver).click();
	HomePage_Cadastro.registraUsuario(driver).click();
	
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("javascript:window.scrollBy(0,200)");
     
      js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
      
      String cadastrorealizadocomsucesso = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
	Assert.assertTrue(cadastrorealizadocomsucesso.contains("User name already exists"),"User name already exists");
	System.out.println("User name already exists" + cadastrorealizadocomsucesso);
	
}

	
	

	@AfterMethod
	public void Finaliza(ITestResult result) throws IOException {

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
