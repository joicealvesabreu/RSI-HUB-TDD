package br.com.rsinet.hub.tdd.PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub.tdd.Utility.Constant;
import br.com.rsinet.hub.tdd.Utility.ExcelUtils;

public class CadastroPage {

	WebDriver driver;
	WebElement element = null;
	

	public CadastroPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement clicarmenu;

	@FindBy(how = How.XPATH, using = "//a[@class='create-new-account ng-scope']")
	private WebElement clicarCadastrar;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement nomeUsuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement emailUsuario;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement senhaUsuario;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement confirmasenhaUsuario;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement primeiroNome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement ultimoNome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement telefoneUsuario;

	@FindBy(how = How.XPATH, using = "//*[@id=\"formCover\"]/div[3]/div[1]/sec-view[1]/div/select")
	private WebElement paisUsuario;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement cidadeUsuario;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement enderecoUsuario;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement estadoUsuario;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement cepUsuario;

	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	private WebElement aceitaprimeiroTermos;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement aceitasegundoTermos;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement registraUsuario;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private WebElement menuUserLink;
	
	@FindBy (how = How.XPATH, using = "//*[@id=\\\"registerPage\\\"]/article/sec-form/div[2]/label[1]")
	private WebElement Usermanejaexiste;
	

	public void menu() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement element = clicarmenu;
		ex.executeScript("arguments[0].click();", element);

	}

	public void cadastrar() {
		clicarCadastrar.sendKeys(Keys.ENTER);
	}

	public void usuario() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		nomeUsuario.sendKeys(ExcelUtils.getCellData(13, 0));
	}

	public void email() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		emailUsuario.sendKeys(ExcelUtils.getCellData(1, 1));
	}

	public void senha() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		senhaUsuario.sendKeys(ExcelUtils.getCellData(1, 2));
	}

	public void confirmarsenha() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		confirmasenhaUsuario.sendKeys(ExcelUtils.getCellData(1, 2));
	}

	public void primeironome() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		primeiroNome.sendKeys(ExcelUtils.getCellData(1, 3));
	}

	public void ultimonome() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		ultimoNome.sendKeys(ExcelUtils.getCellData(1, 4));
	}

	public void telefone() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		telefoneUsuario.sendKeys(ExcelUtils.getCellData(1, 5));
	}

	public void pais() throws Exception {
		
		new Select(paisUsuario).selectByVisibleText("Brazil");
	}

	public void cidade() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		cidadeUsuario.sendKeys(ExcelUtils.getCellData(1, 7));
	}

	public void endereco() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		enderecoUsuario.sendKeys(ExcelUtils.getCellData(1, 8));
	}

	public void estado() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		estadoUsuario.sendKeys(ExcelUtils.getCellData(1, 9));
	}

	public void cep() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		cepUsuario.sendKeys(ExcelUtils.getCellData(1, 10));
	}

	public void aceitaTermos_1() {
		aceitaprimeiroTermos.isSelected();
	}

	public void aceitatermos_2() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement element = aceitasegundoTermos;
		ex.executeScript("arguments[0].click();", element);
	}

	public void regristra_usuario() {
		registraUsuario.click();
	}
	public void usuariologado() {
		menuUserLink.getText();
	}
	public void usuariojaexiste() {
		Usermanejaexiste.getText();
	}
}
