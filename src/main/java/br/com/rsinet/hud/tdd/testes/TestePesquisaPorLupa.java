package br.com.rsinet.hud.tdd.testes;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.PageFactory.PesquisadeProdutoPage;
import br.com.rsinet.hub.tdd.Utility.Constant;
import br.com.rsinet.hub.tdd.Utility.Excel;
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;
import br.com.rsinet.hub.tdd.Utility.Report;
import br.com.rsinet.hub.tdd.Utility.Utility;

public class TestePesquisaPorLupa {

	public 	 WebDriver driver;
	public  PesquisadeProdutoPage lupa;
	public  ExtentReports extent;
	public  ExtentTest logger;
	public  ExtentHtmlReporter reporter;
	public  Excel excel;

	
	

	@BeforeMethod
	public  void InicializaBrowser() {

		driver = DriverFactory.InicializaDriver();
		lupa = PageFactory.initElements(driver, PesquisadeProdutoPage.class);
		excel = new Excel();
	}
	
	@BeforeTest
	public void report() {
		extent = Report.setExtent();
	}

	@Test
	public void buscaporlupa1_Positivo() throws Exception  {
		logger = Report.setUp("buscaporlupa1_valido");
		
			lupa.Pesquisa();
		    lupa.ProdutoPesquisado();
		    lupa.Adicionarlaptop();
		    boolean achouNome = driver.getPageSource().contains("HP PAVILION 15Z TOUCH LAPTOP");
			
	}
	
	@Test
	public void buscaporlupa2_Negativo() throws Exception {

		logger = Report.setUp("buscaporlupa2_Invalido");
		lupa.Pesquisa();
		lupa.Produtoerrado();
		
		String produtoerrado = driver.getCurrentUrl();
		Assert.assertFalse(produtoerrado.contains("https://www.advantageonlineshopping.com/#/search/?viewAll=HP ZEM WHQOQ"));

		
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		Report.tearDown(result, logger, driver);
		Report.closeReport(extent);
		driver = DriverFactory.FechandoDriver();
	}

	@AfterTest
	public void finalizareport() {
		extent.flush();
	}



}
