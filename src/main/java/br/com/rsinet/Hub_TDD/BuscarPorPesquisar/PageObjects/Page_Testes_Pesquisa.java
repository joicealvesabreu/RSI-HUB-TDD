package br.com.rsinet.Hub_TDD.BuscarPorPesquisar.PageObjects;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.ExcelUtils;

public class Page_Testes_Pesquisa {

	private static WebDriver driver;

	@BeforeClass
	public static void inicio() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		
	}

	@Test
	public void testesbusca() throws Exception {
	
	
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");//Chamando o Excel
		
		Home_Page_PesquisaDeProduto.Pesquisa(driver).click();

		Home_Page_PesquisaDeProduto.ProdutoPesquisado(driver).sendKeys(ExcelUtils.getCellData(1, 0)+ Keys.ENTER); //primiro é linha e depois a coluna
		
		Home_Page_PesquisaDeProduto.Adicionarlaptop(driver).isSelected();
		
		Home_Page_PesquisaDeProduto.Confirmandolaptop(driver);
		
		Home_Page_PesquisaDeProduto.Cordolaptop(driver).click();

		Home_Page_PesquisaDeProduto.Selecionandoaocarinho(driver).click();

		Home_Page_PesquisaDeProduto.Carinhopop(driver);
		
		Home_Page_PesquisaDeProduto.Username(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		
		Home_Page_PesquisaDeProduto.Senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		
		Home_Page_PesquisaDeProduto.Botaoenntrar(driver).click();
		
		Home_Page_PesquisaDeProduto.Botaonext(driver).click();
		
		
		
	
		ExcelUtils.setCellData("Pass", 1, 3);
	}

	
}
