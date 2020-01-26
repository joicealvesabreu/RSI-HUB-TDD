package br.com.rsinet.hub.tdd.PageFactory;


import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class TelaPrincipalPage {

	 WebDriver driver;
	 WebElement element = null;

	public TelaPrincipalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(how = How.XPATH, using = "//div[@id='laptopsImg']")
	private WebElement mouse;


	@FindBy(how = How.LINK_TEXT, using = "HP Pavilion 15z Touch Laptop")
	private WebElement produto;

	@FindBy(how = How.XPATH, using = "//div[@class='cell categoryRight']//li[@class='ng-scope']")
	private WebElement Adicionarlaptop;

	@FindBy(how = How.XPATH, using = "//div[@id='Description']//div[2]//span[1]")
	private WebElement Cordoproduto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement Confirmar;

	@FindBy(how = How.ID, using = "checkOutPopUp")
	private WebElement Carinhopop;

	public void telaprincipal() {
		
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement element = mouse;
		ex.executeScript("arguments[0].click();", element);
	}

	public void produto_Laptop() {
	produto.click();
	String clicoucerto = driver.getCurrentUrl();
	Assert.assertTrue(clicoucerto.contains("https://www.advantageonlineshopping.com/#/product/3"));
	}

	public void Adicionar_Laptop() {
		Adicionarlaptop.click();
	}

	public void escolhendoCor() {
		Cordoproduto.click();
	}

	public void Confirmando() {
		Confirmar.click();
	}

	public void ProdutonoCarinho() {
		
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement element = Carinhopop;
		ex.executeScript("arguments[0].click();", element);
		
	}

}
