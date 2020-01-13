package br.com.rsinet.Hub_TDD.BuscarPorPesquisar.PageObjects;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.ExcelUtils;

public class Page_Testes_Pesquisa {

	private static WebDriver driver;

	@BeforeClass
	public static void inicio() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@Test
	public void testesbusca() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		
	
		Home_Page_PesquisaDeProduto.Pesquisa(driver).click();

		Home_Page_PesquisaDeProduto.ProdutoPesquisado(driver).sendKeys(Constant.ProdutoPesquisado); //primiro é linha e depois a coluna

		Home_Page_PesquisaDeProduto.Adicionarlapto(driver);

		Home_Page_PesquisaDeProduto.Cordolaptop(driver).click();

		Home_Page_PesquisaDeProduto.Selecionandoaocarinho(driver).click();

		Home_Page_PesquisaDeProduto.Carinhopop(driver);
		
		Home_Page_PesquisaDeProduto.Username(driver).sendKeys(Constant.Username);
		
		Home_Page_PesquisaDeProduto.Senha(driver).sendKeys(Constant.Senha);
		
		Home_Page_PesquisaDeProduto.Botaoenntrar(driver).click();
		
		assertEquals(Constant.ProdutoPesquisado,"HP ZBOOK 17 G2 MOBILE WORKSTATION" );
		
		driver.getCurrentUrl();

	
	}

	// @AfterClass
	// public static void finaliza() {
	// driver.quit();

//	}

}
