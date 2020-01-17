package br.com.rsinet.Hub_TDD.Testes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

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

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.Home_CadastrodeUsuario;
import br.com.rsinet.Hub_TDD.PageObjects.Home_ChromeDriver;

import br.com.rsinet.Hub_TDD.Utility.Utility;

public class CadrastrodeClienteQueJ·Existe {

	static WebDriver driver;
	static ExtentReports extent;
	static ExtentTest logger, logger1;
	static ExtentHtmlReporter reporter;

	@BeforeClass
	public static void InicializaReport() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/Cadastros.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

	}

	@BeforeMethod
	public static void InicializaBrowser() {

		driver = Home_ChromeDriver.InicializaDriver();
	}

	@Test
	public void cadastro_realizado_com_sucesso() throws InterruptedException {

		logger = extent.createTest("Cadastrocomsucesso");

		Home_CadastrodeUsuario.clicarmenu(driver).click();
		Home_CadastrodeUsuario.clicarCadastrar(driver).click();

		Home_CadastrodeUsuario.nomeUsuario(driver).sendKeys("JoiceEguilherme");
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

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span"))).getText();

		Assert.assertTrue(driver.getPageSource().contains("JoiceEguilherme"));
		Utility.getScreenshot(driver);
		System.out.println(wait);

		logger.log(Status.INFO, "Cadrastrou Certo");
		logger.log(Status.PASS, "Usuario Logado");
		extent.flush();

	}

	@Test
	public void cadastrojaExistente() {

		logger1 = extent.createTest("JaExisteCadastro");

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

		Utility.getScreenshot(driver);
		String cadastrojaexiste = driver
				.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
		Assert.assertTrue(cadastrojaexiste.contains("User name already exists"), "User name already exists");
		System.out.println("User name already exists" + cadastrojaexiste);

		logger1.log(Status.INFO, "O cadastro j· existe");
		logger1.log(Status.PASS, "J· Existe");
		extent.flush();
	}

	@AfterMethod
	public void Finaliza(ITestResult result) {
		Home_ChromeDriver.FechandoDriver(driver);
	}
}
