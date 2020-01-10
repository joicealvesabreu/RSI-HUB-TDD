package br.com.rsinet.Hub_TDD.CadastrarCliente.TestCadastro;

import java.util.concurrent.TimeUnit;

import org.apache.xerces.dom.DOMConfigurationImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import br.com.rsinet.Hub_TDD.CadastrarCliente.NovaClasse;
import br.com.rsinet.Hub_TDD.CadastrarCliente.PageCadastro;
import br.com.rsinet.Hub_TDD.CadastrarCliente.constantes;

public class teste_cadastraPage {
	
	private static final String ExcelUtils = null;
	
	static WebDriver driver = new ChromeDriver();
	@Before

	public void beforeMethod() throws Exception {

		//DOMConfigurationImpl. ("log4j.xml");

		ExcelUtils.setExcelFile(constantes.Path_TestData + constantes.File_TestData, "Planilha1");}
	
	public static void main(String[] args) throws Exception {
	
	

		Object constantes;
	//	Test_HomePage.homePage();
	driver.get(constantes.URL);
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(30000);
	PageFactory.initElements(driver, NovaClasse.class);
	PageFactory.initElements(driver, PageCadastro .class);
	NovaClasse.minhaConta.click();
	Thread.sleep(3000);
	WebElement PopUp = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form"));
	PopUp.click();
	NovaClasse.novaConta.click();
	Thread.sleep(3000);
	PageCadastro.nomeUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_userName, 1));
	PageCadastro .emailUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_Email, 1));
	PageCadastro .senhaUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_Senha, 1));
	PageCadastro .confirmacaoSenhaUsuario.sendKeys(ExcelUtils.getCellData(constantes.Col_confirmacaoDeSenha, 1));
	PageCadastro .primeiroNome.sendKeys(ExcelUtils.getCellData(constantes.Col_primeiroNome, 1));
	PageCadastro .ultimoNome.sendKeys();
	PageCadastro .telefoneUsuario.sendKeys();
	PageCadastro .paisUsuario.click();
	
	Select paisBox = new Select(PageCadastro.paisUsuario);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	paisBox.selectByVisibleText("Brazil");
	
	PageCadastro .cidadeUsuario.sendKeys();
	PageCadastro .enderecoUsuario.sendKeys();
	PageCadastro .cepUsuario.sendKeys();
	PageCadastro .aceitaTermos.click();
	PageCadastro .registraUsuario.click();

	}
	
	

	
}
