package br.com.rsinet.Hub_TDD.BuscarProduto.PageObjects;



import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import br.com.rsinet.Hub_TDD.Utility.Constant;


public class PageBuscarProduto {
	private static WebDriver driver;

	@BeforeClass
	public static void testes() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@Test
	public void Test() throws Exception {

		

		HomePage_Busca.mouse(driver);

		HomePage_Busca.produto(driver).click();

		HomePage_Busca.cordoproduto(driver).click();

		HomePage_Busca.adicionaraocarinho(driver).click();

		HomePage_Busca.carinhopop(driver).click();

	}

	@AfterClass
	public static void finalizar() {
		driver.quit();
	}

}
