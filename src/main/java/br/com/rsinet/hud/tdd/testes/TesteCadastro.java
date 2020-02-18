package br.com.rsinet.hud.tdd.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub.tdd.PageFactory.CadastroPage;
import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.Utility.Excel;
import br.com.rsinet.hub.tdd.Utility.Report;

public class TesteCadastro {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger, logger1;
	public ExtentHtmlReporter reporter;
	public CadastroPage cadastro;
	public Excel excel;

	@BeforeMethod
	public void InicializaBrowser() {

		driver = DriverFactory.InicializaDriver();
		cadastro = PageFactory.initElements(driver, CadastroPage.class);
		excel = new Excel();

	}

	@BeforeTest
	public void report() {
		extent = Report.setExtent();
	}

	@Test
	public void cadastro1Positivo() throws Exception {
		logger = Report.setUp("cadastro_valido");
		cadastro.menu();
		cadastro.cadastrar();
		cadastro.nome(excel.sUsuario());
		cadastro.email(excel.sEmail());
		cadastro.senha(excel.sSenha());
		cadastro.senhaconfirm(excel.sSenha());
		cadastro.pnome(excel.sPrimeiroNome());
		cadastro.unome(excel.sUltimoNome());
		cadastro.telefone(excel.sTelefone());
		cadastro.pais();
		cadastro.cidade(excel.sCidade());
		cadastro.endereco(excel.sEndereco());
		cadastro.estado(excel.sEstado());
		cadastro.cep(excel.sCep());
		cadastro.aceitaTermos_1();
		cadastro.aceitatermos_2();
		cadastro.regristra_usuario();
		String cadastrocomsucesso = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span")).getText();
		Assert.assertTrue(cadastrocomsucesso.contains(excel.sUsuario()));

	}

	@Test
	public void cadastro2Negativo() throws Exception {
		logger = Report.setUp("cadastro_Invalido");
		cadastro.menu();
		cadastro.cadastrar();
		cadastro.nome(excel.sUsuario());
		cadastro.email(excel.sEmail());
		cadastro.senha(excel.sSenha());
		cadastro.senhaconfirm(excel.sSenha());
		cadastro.pnome(excel.sPrimeiroNome());
		cadastro.unome(excel.sUltimoNome());
		cadastro.telefone(excel.sTelefone());
		cadastro.pais();
		cadastro.cidade(excel.sCidade());
		cadastro.endereco(excel.sEndereco());
		cadastro.estado(excel.sEstado());
		cadastro.cep(excel.sCep());
		cadastro.aceitaTermos_1();
		cadastro.aceitatermos_2();
		cadastro.regristra_usuario();
		cadastro.esperar();
		
		String cadastrojaexiste = driver
				.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]")).getText();
		Assert.assertTrue(cadastrojaexiste.contains("User name already exists"), "User name already exists");
	
		

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		Report.tearDown(result, logger, driver);
		Report.closeReport(extent);
		driver =DriverFactory.FechandoDriver();
	}

	@AfterTest
	public void finalizareport() {
		extent.flush();
	}

}
