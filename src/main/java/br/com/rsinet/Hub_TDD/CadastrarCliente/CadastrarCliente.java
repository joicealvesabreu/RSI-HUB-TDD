package br.com.rsinet.Hub_TDD.CadastrarCliente;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CadastrarCliente {
	
	//private static WebDriver driver;
//private static WebElement pais;
//	
	@Test
	public void Cadatrar() {
		
		
		
		
		

		
		
		
	
		
		Select box= new Select (CadastrarCliente. pais);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        box.selectByVisibleText("Brazil");
		
	}
	
	
	
}
