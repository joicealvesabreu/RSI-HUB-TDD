package br.com.rsinet.Hub_TDD.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.Hub_TDD.Utility.Constant;

public class Page_WebDriver {

	private static WebDriver driver;

	public static WebDriver InicializaDriver(WebDriver driver) {
		if (driver == null)
			driver = new ChromeDriver();
		driver.get(Constant.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;
	}

	public static void FechandoDriver(WebDriver driver) {

		if (driver != null)
			driver.quit();
	}

}
