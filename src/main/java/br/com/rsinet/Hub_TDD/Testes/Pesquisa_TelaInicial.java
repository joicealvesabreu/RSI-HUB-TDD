package br.com.rsinet.Hub_TDD.Testes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.Hub_TDD.PageObjects.Home_ChromeDriver;

public class Pesquisa_TelaInicial {
	
	private static WebDriver driver;
	private static ExtentReports extent;
	private static ExtentTest logger;
	private static ExtentHtmlReporter reporter;
	
	@BeforeClass
	public static void iniciaReport() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/PesquisaPorMassaDeDados.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeMethod
	public static void InicializaBrowser() {

		driver = Home_ChromeDriver.InicializaDriver();
	}

	@Test
	public void BuscardeProduto() throws Exception  {

		logger = extent.createTest("PesquisandoProdutoCerto");
	}
		

}
