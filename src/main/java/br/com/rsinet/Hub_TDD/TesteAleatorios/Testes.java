package br.com.rsinet.Hub_TDD.TesteAleatorios;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class Testes {
	
	
	@Test
	public void testes () throws InterruptedException, AWTException {
	
	 WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.advantageonlineshopping.com/#/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//WebDriverWait wait = new WebDriverWait(driver, 15);
	//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("speakersImg"))));
	
	
	driver.findElement(By.id("miceLink")).click();
	
	

}
}
