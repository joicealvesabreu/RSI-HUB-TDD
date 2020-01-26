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
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;




public class PesquisadeProdutoPage {
	WebDriver driver;
	WebElement element = null;


	@FindBy(how = How.XPATH, using = "//body[@class='ng-scope']/header/nav/ul[@class='roboto-light desktop-handler']/li[4]/a[1]")
	private WebElement BarradePesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement Buscandoproduto;
	
	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement Buscandoprodutoerrado;

	@FindBy(how = How.XPATH, using = "//div[@class='autoCompleteCover']//div//img")
	private WebElement FechandoBotao;

	@FindBy(how = How.XPATH, using = "//div[@class='cell categoryRight']//li[@class='ng-scope']")
	private WebElement clicarlaptop;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/div/div[2]/ul/li/div[2]/label")
	private WebElement Confirmar;

	@FindBy(how = How.XPATH, using = "//span[@class='productColor ng-scope colorSelected BLACK']")
	private WebElement Cor;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement Selecionar;

	@FindBy(how = How.ID, using = "checkOutPopUp") // Name = check_out_btn
	private WebElement Carinho;
	
	@FindBy(how = How.XPATH, using = "//h3[@class='roboto-regular center ng-scope']")
	private WebElement Naoencontrouproduto;

	public void Pesquisa() {
	BarradePesquisa.click();
		
	}

	public void ProdutoPesquisado() throws Exception {
		ExcelUtils.setExcelFile(
				"C:\\Users\\joice.abreu\\eclipse-workspace\\br.com.rsinet.hub.tdd\\target\\ExcelDados.xlsx", "Planilha1");
		Buscandoproduto.sendKeys(ExcelUtils.getCellData(1, 11) +Keys.ENTER);
	}

	public void Produtoerrado () throws Exception {
	  //  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		Buscandoprodutoerrado.sendKeys(ExcelUtils.getCellData(1, 12) +Keys.ENTER);
	}
	
	public void Botaofechar() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = FechandoBotao;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Adicionarlaptop() {
		clicarlaptop.click();
	}

	public void Confirmandolaptop() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = Confirmar;
		ex.executeScript("arguments[0].click();", elemento);
	}

	public void Cordolaptop() {
		Cor.click();
	}

	public void Selecionandoaocarinho() {
		Selecionar.click();
	}

	public void Carinhopop() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement elemento = Carinho;
		ex.executeScript("arguments[0].click();", elemento);
	}


}
