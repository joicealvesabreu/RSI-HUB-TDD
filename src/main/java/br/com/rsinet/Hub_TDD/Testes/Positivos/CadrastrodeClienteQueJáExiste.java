package br.com.rsinet.Hub_TDD.Testes.Positivos;

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

import br.com.rsinet.Hub_TDD.PageObjects.Home_CadastrodeUsuario;
import br.com.rsinet.Hub_TDD.PageObjects.Home_ChromeDriver;
import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class CadrastrodeClienteQueJáExiste {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger;
	static ExtentHtmlReporter reporter;

	@BeforeMethod
	public void testes() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/Cadastro56.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("LoginTest");
		driver=Home_ChromeDriver.InicializaDriver();
	}
	
	@org.testng.annotations.Test
	public void cadastro_realizado_com_sucesso() throws InterruptedException {

		Home_CadastrodeUsuario.clicarmenu(driver).click();
		Home_CadastrodeUsuario.clicarCadastrar(driver).click();

		Home_CadastrodeUsuario.nomeUsuario(driver).sendKeys("JoiceCarva");
		Home_CadastrodeUsuario.emailUsuario(driver).sendKeys("joice_natalice16@hotmail.com");
		Home_CadastrodeUsuario.senhaUsuario(driver).sendKeys("Natalice22");
		Home_CadastrodeUsuario.confirmasenhaUsuario(driver).sendKeys("Natalice22");

		Home_CadastrodeUsuario.primeiroNome(driver).sendKeys("joice");
		Home_CadastrodeUsuario.ultimoNome(driver).sendKeys("abreu");
		Home_CadastrodeUsuario.telefoneUsuario(driver).sendKeys("11941707376");
		Home_CadastrodeUsuario.paisUsuario(driver);

		Home_CadastrodeUsuario.cidadeUsuario(driver).sendKeys("Taboao da Serra");
		Home_CadastrodeUsuario.enderecoUsuario(driver).sendKeys("Rua Albano Leite");
		Home_CadastrodeUsuario.estadoUsuario(driver).sendKeys("Sao Paulo");
		Home_CadastrodeUsuario.cepUsuario(driver).sendKeys("06773-050");

		Home_CadastrodeUsuario.aceitaTermos(driver).isSelected();
		Home_CadastrodeUsuario.aceitatermos2(driver).click();
		Home_CadastrodeUsuario.registraUsuario(driver).click();

		Thread.sleep(10000); // Tive que Colocar esse Thread pois só ele funcionou

		String cadastrorealizadocomsucesso = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")).getText();
		Assert.assertTrue(cadastrorealizadocomsucesso.contains("JoiceCarva"), "JoiceCarva");
		Utility.getScreenshot(driver);

	}

	@org.testng.annotations.Test
	public void cadastrojaExistente() {

		Home_CadastrodeUsuario.clicarmenu(driver).click();
		Home_CadastrodeUsuario.clicarCadastrar(driver).click();

		Home_CadastrodeUsuario.nomeUsuario(driver).sendKeys("JoiceNatalice");
		Home_CadastrodeUsuario.emailUsuario(driver).sendKeys("joice_natalice16@hotmail.com");
		Home_CadastrodeUsuario.senhaUsuario(driver).sendKeys("Natalice24");
		Home_CadastrodeUsuario.confirmasenhaUsuario(driver).sendKeys("Natalice24");

		Home_CadastrodeUsuario.primeiroNome(driver).sendKeys("joice");
		Home_CadastrodeUsuario.ultimoNome(driver).sendKeys("abreu");
		Home_CadastrodeUsuario.telefoneUsuario(driver).sendKeys("11941707376");
		Home_CadastrodeUsuario.paisUsuario(driver);

		Home_CadastrodeUsuario.cidadeUsuario(driver).sendKeys("Taboao da Serra");
		Home_CadastrodeUsuario.enderecoUsuario(driver).sendKeys("Rua Albano Leite");
		Home_CadastrodeUsuario.estadoUsuario(driver).sendKeys("Sao Paulo");
		Home_CadastrodeUsuario.cepUsuario(driver).sendKeys("06773-050");

		Home_CadastrodeUsuario.aceitaTermos(driver).isSelected();
		Home_CadastrodeUsuario.aceitatermos2(driver).click();
		Home_CadastrodeUsuario.registraUsuario(driver).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");

		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");

		String cadastrorealizadocomsucesso = driver
				.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
		Assert.assertTrue(cadastrorealizadocomsucesso.contains("User name already exists"), "User name already exists");
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
		Home_ChromeDriver.FechandoDriver(driver);

	}
}
