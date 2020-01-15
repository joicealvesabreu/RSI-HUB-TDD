package br.com.rsinet.Hub_TDD.PageObjects.Tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.Hub_TDD.PageObjects.HomePage_Buscar;
import br.com.rsinet.Hub_TDD.Utility.Constant;
import br.com.rsinet.Hub_TDD.Utility.Utility;

public class PageTestDe_Buscar {

	private static WebDriver driver;

	@BeforeMethod
	public static void inicia() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constant.URL);
	}

	@Test
	public void TestBuscar_Positivo() throws Exception {

		HomePage_Buscar.mouse(driver);

		HomePage_Buscar.produto(driver).click();

		boolean clicoucerto = driver.getPageSource().contains("3");

		HomePage_Buscar.cordoproduto(driver).click();

		HomePage_Buscar.adicionaraocarinho(driver).click();

		HomePage_Buscar.carinhopop(driver).click();
		Utility.getScreenshot(driver);

		assertTrue(clicoucerto);
		System.out.println(clicoucerto);
	}

	@AfterMethod
	public static void finalizar() {
		driver.quit();

	}

}
