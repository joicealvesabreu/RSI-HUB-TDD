package br.com.rsinet.hub.tdd.Testes;

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

import br.com.rsinet.hub.tdd.PageObjects.Home_CadastrodeUsuario;
import br.com.rsinet.hub.tdd.PageObjects.Home_ChromeDriver;
import br.com.rsinet.hub.tdd.Utility.Constant;
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;
import br.com.rsinet.hub.tdd.Utility.Utility;

public class Cadrastro_De_Usuario {

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
	public void cadastro_realizado_com_sucesso() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");	
		
		String sNome =ExcelUtils.getCellData(1, 0);
		String sEmail = ExcelUtils.getCellData(1, 1);
		String sSenha = ExcelUtils.getCellData(1, 2);
		String sPrimeironome = ExcelUtils.getCellData(1, 3);
		String sUltimonome = ExcelUtils.getCellData(1, 4);
		String sTelefone = ExcelUtils.getCellData(1, 5);
		String sCidade = ExcelUtils.getCellData(1, 6);
		String sPais = ExcelUtils.getCellData(1, 7);
		String sEndereco = ExcelUtils.getCellData(1, 8);
		String sEstado = ExcelUtils.getCellData(1, 9);
		String sCep = ExcelUtils.getCellData(1, 10);

		logger = extent.createTest("Cadastrocomsucesso");
		
		Home_CadastrodeUsuario.clicarmenu(driver).click();
		Home_CadastrodeUsuario.clicarCadastrar(driver).click();

		Home_CadastrodeUsuario.nomeUsuario(driver).sendKeys(sNome);
		Home_CadastrodeUsuario.emailUsuario(driver).sendKeys(sEmail);
		Home_CadastrodeUsuario.senhaUsuario(driver).sendKeys(sSenha);
		Home_CadastrodeUsuario.confirmasenhaUsuario(driver).sendKeys(sSenha);
		

		Home_CadastrodeUsuario.primeiroNome(driver).sendKeys(sPrimeironome);
		Home_CadastrodeUsuario.ultimoNome(driver).sendKeys(sUltimonome);
		Home_CadastrodeUsuario.telefoneUsuario(driver).sendKeys(sTelefone);
		Home_CadastrodeUsuario.paisUsuario(driver);

		Home_CadastrodeUsuario.cidadeUsuario(driver).sendKeys(sCidade);
		Home_CadastrodeUsuario.enderecoUsuario(driver).sendKeys(sEndereco);
		Home_CadastrodeUsuario.estadoUsuario(driver).sendKeys(sEstado);
		Home_CadastrodeUsuario.cepUsuario(driver).sendKeys(sCep);

		Home_CadastrodeUsuario.aceitaTermos(driver).isSelected();
		Home_CadastrodeUsuario.aceitatermos2(driver).click();
		Home_CadastrodeUsuario.registraUsuario(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menuUserLink\"]/span"))).getText();

		Assert.assertTrue(driver.getPageSource().contains(sNome));
		Utility.getScreenshot(driver);
		System.out.println(wait);

		logger.log(Status.INFO, "Cadrastrou Certo");
		logger.log(Status.PASS, "Usuario Logado");
		extent.flush();

	}

	@Test
	public void cadastrojaExistente() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		logger1 = extent.createTest("JaExisteCadastro");
		String sNome =ExcelUtils.getCellData(1, 0);
		String sEmail = ExcelUtils.getCellData(1, 1);
		String sSenha = ExcelUtils.getCellData(1, 2);
		String sPrimeironome = ExcelUtils.getCellData(1, 3);
		String sUltimonome = ExcelUtils.getCellData(1, 4);
		String sTelefone = ExcelUtils.getCellData(1, 5);
		String sCidade = ExcelUtils.getCellData(1, 6);
		String sPais = ExcelUtils.getCellData(1, 7);
		String sEndereco = ExcelUtils.getCellData(1, 8);
		String sEstado = ExcelUtils.getCellData(1, 9);
		String sCep = ExcelUtils.getCellData(1, 10);


		Home_CadastrodeUsuario.clicarmenu(driver).click();
		Home_CadastrodeUsuario.clicarCadastrar(driver).click();

		Home_CadastrodeUsuario.nomeUsuario(driver).sendKeys(sNome);
		Home_CadastrodeUsuario.emailUsuario(driver).sendKeys(sEmail);
		Home_CadastrodeUsuario.senhaUsuario(driver).sendKeys(sSenha);
		Home_CadastrodeUsuario.confirmasenhaUsuario(driver).sendKeys(sSenha);

		Home_CadastrodeUsuario.primeiroNome(driver).sendKeys(sPrimeironome);
		Home_CadastrodeUsuario.ultimoNome(driver).sendKeys(sUltimonome);
		Home_CadastrodeUsuario.telefoneUsuario(driver).sendKeys(sTelefone);
		Home_CadastrodeUsuario.paisUsuario(driver);

		Home_CadastrodeUsuario.cidadeUsuario(driver).sendKeys(sCidade);
		Home_CadastrodeUsuario.enderecoUsuario(driver).sendKeys(sEndereco);
		Home_CadastrodeUsuario.estadoUsuario(driver).sendKeys(sEstado);
		Home_CadastrodeUsuario.cepUsuario(driver).sendKeys(sCep);

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

		logger1.log(Status.INFO, "O cadastro já existe");
		logger1.log(Status.PASS, "Já Existe");
		extent.flush();
	}

	@AfterMethod
	public void Finaliza(ITestResult result) {
		Home_ChromeDriver.FechandoDriver(driver);
	}
}
