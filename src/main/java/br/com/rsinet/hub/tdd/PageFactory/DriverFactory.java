package br.com.rsinet.hub.tdd.PageFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import br.com.rsinet.hub.tdd.Utility.Constant;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver InicializaDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.get(Constant.URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void FechandoDriver(WebDriver driver) {

		if (driver != null)
			driver.quit();
	}


}
