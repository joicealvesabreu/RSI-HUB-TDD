package br.com.rsinet.Hub_TDD.BuscarProduto.framework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.BuscarProduto.HomePage_Busca;

public class PageBuscarProduto {
	private static WebDriver driver;

	@BeforeClass
	public static void testes() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void Test() throws InterruptedException, AWTException {
		
		HomePage_Busca.mouse(driver);
		
		HomePage_Busca.produto(driver).click();
		
		HomePage_Busca.cordoproduto(driver).click();
		
		HomePage_Busca.adicionaraocarinho(driver).click();
		
	}

	@AfterClass
	public static void finalizar() {
	 driver.quit();

	}

}
