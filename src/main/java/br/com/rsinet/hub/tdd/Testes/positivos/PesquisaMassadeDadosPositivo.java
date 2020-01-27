package br.com.rsinet.hub.tdd.Testes.positivos;



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

import br.com.rsinet.hub.tdd.PageFactory.DriverFactory;
import br.com.rsinet.hub.tdd.PageFactory.PesquisadeProdutoPage;
import br.com.rsinet.hub.tdd.Utility.Constant;
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;
import br.com.rsinet.hub.tdd.Utility.Utility;

public class PesquisaMassadeDadosPositivo {

	 WebDriver driver;
	 PesquisadeProdutoPage lupa;
	 ExtentReports extent;
	 ExtentTest logger;
	 ExtentHtmlReporter reporter;

	 @BeforeClass
	 public void report() {
		 ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Relatorios/PesquisaMassadedadosPositivo.html");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			logger = extent.createTest("Teste Pesquisa Positivo");
	 }
	

	@BeforeMethod
	public  void InicializaBrowser() {

		driver = DriverFactory.InicializaDriver();
		lupa = PageFactory.initElements(driver, PesquisadeProdutoPage.class);
	}

	@Test
	public void BuscardeProduto() throws Exception  {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		 lupa.Pesquisa();
		    lupa.ProdutoPesquisado();
		    lupa.Adicionarlaptop();
		    boolean achouNome = driver.getPageSource().contains(ExcelUtils.getCellData(1, 11));
			lupa.Botaofechar();
			lupa.Cordolaptop();
			lupa.Selecionandoaocarinho();
			lupa.Carinhopop();
			
		Assert.assertTrue(achouNome);

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
		
		logger.log(Status.PASS, "ok");
		extent.flush();
		
		DriverFactory.FechandoDriver(driver);
		
		
	}


}
