package br.com.rsinet.hub.tdd.PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import br.com.rsinet.hub.tdd.Utility.Constant;
import br.com.rsinet.hub.tdd.Utility.Excel;
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;

public class PesquisadeProdutoPage {
	public WebDriver driver;
	public WebElement element = null;
	public Excel excel;

	public PesquisadeProdutoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "searchSection")
			//"//body[@class='ng-scope']/header/nav/ul[@class='roboto-light desktop-handler']/li[4]/a[1]") //passo 1
	private WebElement barradePesquisa;

	@FindBy(how = How.ID, using = "autoComplete") //passo 2
	private WebElement buscandoproduto;
	
	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement buscandoprodutoerrado;

	@FindBy(how = How.XPATH, using = "//div[@class='cell categoryRight']//li[@class='ng-scope']") //passo3
	private WebElement clicarlaptop;
	
	@FindBy(how = How.XPATH, using = "//div[@class='autoCompleteCover']//div//img")
	private WebElement fechandoBotao;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/div/div[2]/ul/li/div[2]/label") //passo4
	private WebElement confirmar;

	@FindBy(how = How.XPATH, using = "//span[@class='productColor ng-scope colorSelected BLACK']")
	private WebElement cor;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement selecionar;

	@FindBy(how = How.ID, using = "checkOutPopUp") // Name = check_out_btn
	private WebElement carinho;
	
	@FindBy(how = How.ID, using = "Description")
	private WebElement encontrouproduto;

	public void Pesquisa() {
		barradePesquisa.click();
	//	WebDriverWait wait2 = new WebDriverWait(driver, 5);
	//	wait2.until(ExpectedConditions.elementToBeClickable(barradePesquisa));
		
	}

	public void ProdutoPesquisado() {
		
		buscandoproduto.sendKeys("HP PAVILION 15Z TOUCH LAPTOP" +Keys.ENTER);
	}

	public void Produtoerrado () throws Exception {
		
		buscandoprodutoerrado.sendKeys("HP ZEM WHQOQ");
	}
	
	public void Botaofechar() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = fechandoBotao;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Adicionarlaptop() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = clicarlaptop;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Confirmandolaptop() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = confirmar;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Cordolaptop() {
		cor.click();
	}

	public void Selecionandoaocarinho() {
		selecionar.click();
	}

	public void Carinhopop() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = carinho;
		ex.executeScript("arguments[0].click();", elemento);
	}
 
	

}
