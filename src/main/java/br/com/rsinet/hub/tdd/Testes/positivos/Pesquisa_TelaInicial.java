package br.com.rsinet.hub.tdd.Testes.positivos;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.PageFactory.teste;

public class Pesquisa_TelaInicial {
	
	 WebDriver driver;

	
	

	@BeforeMethod
	public  void InicializaBrowser() {

		driver =DriverFactory.InicializaDriver();
		
	}

	@Test
	public void BuscardeProduto() throws Exception  {

	
	
	}
	
	@AfterMethod
	public  void finalizar() {
		DriverFactory.FechandoDriver(driver);
		
	}

}
