package br.com.rsinet.hud.tdd.testes;


import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.PageFactory.TelaPrincipalPage;
import br.com.rsinet.hub.tdd.Utility.Excel;
import br.com.rsinet.hub.tdd.Utility.Report;


public class TesteTelaPrincipal {
	
		public TelaPrincipalPage pesquisa;
		public WebDriver driver;
		public ExtentReports extent;
		public ExtentTest logger;
		public DriverFactory Finalizar;
		public Excel excel;
	
	
	@BeforeMethod
	public  void InicializaBrowser() {
		driver = DriverFactory.InicializaDriver();
		pesquisa = PageFactory.initElements(driver, TelaPrincipalPage.class);
		excel = new Excel();
	}
	
	@BeforeTest
	public void report() {
		extent = Report.setExtent();
	}
	
	@Test
	public void telaprincipal1() throws Exception {
	logger = Report.setUp("telapricinpal_Invalido");
	pesquisa.telaprincipal();
	pesquisa.produto_Laptop();
	pesquisa.escolhendoCor();
	String produto = pesquisa.encontrouproduto();
	Assert.assertTrue(produto.contains(excel.sproduto()));
	
	}
	
	@Test
	public void telapincipal2() throws Exception {
	logger = Report.setUp("telaprincinpal_Invalido");
	pesquisa.telaprincipal();
	pesquisa.produto_Laptop();
	pesquisa.escolhendoCor();
	Thread.sleep(5000);
	pesquisa.qtdproduto();
	pesquisa.Confirmando();
	pesquisa.produtonocarinho();
	
	String produto = pesquisa.acertqtd();
	Assert.assertFalse(produto.contains("20"));
	
	
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
