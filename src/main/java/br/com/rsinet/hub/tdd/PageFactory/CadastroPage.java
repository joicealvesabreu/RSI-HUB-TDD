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

	public WebDriver driver;
	public WebElement element ;

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

	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement menuUserLink;

	@FindBy(how = How.XPATH, using = "//*[@id=\\\"registerPage\\\"]/article/sec-form/div[2]/label[1]")
	private WebElement Usermanejaexiste;

	public void menu() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement element = clicarmenu;
		ex.executeScript("arguments[0].click();", element);

	}

	public void cadastrar() {
		clicarCadastrar.sendKeys(Keys.ENTER);
	}

	public void nome(String usuario) throws Exception {

		nomeUsuario.sendKeys(usuario); // "JGANA23"
	}

	public void email(String email) throws InterruptedException {

		emailUsuario.sendKeys(email);
	}

	public void senha(String password) throws InterruptedException {
		senhaUsuario.sendKeys(password);
	}

	public void senhaconfirm(String passwordconfirm) {
		confirmasenhaUsuario.sendKeys(passwordconfirm);
	}

	public void pnome(String firstname) {
		primeiroNome.sendKeys(firstname);
	}

	public void unome(String lastname) {
		ultimoNome.sendKeys(lastname);
	}

	public void telefone(String phonenumber) {
		telefoneUsuario.sendKeys(phonenumber);
	}

	public void pais() {

		new Select(paisUsuario).selectByVisibleText("Brazil");

	}

	public void estado(String state) {
		estadoUsuario.sendKeys(state);
	}

	public void endereco(String address) {
		enderecoUsuario.sendKeys(address);
	}

	public void cidade(String city) {
		cidadeUsuario.sendKeys(city);
	}

	public void cep(String zip) {
		cepUsuario.sendKeys(zip);
	}

	public void aceitaTermos_1() {
		aceitaprimeiroTermos.isSelected();
	}

	public void aceitatermos_2() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		WebElement element = aceitasegundoTermos;
		ex.executeScript("arguments[0].click();", element);
	}

	public void regristra_usuario() throws InterruptedException {
		registraUsuario.click();
		Thread.sleep(5000);
	}

	public String usuariologado() {
		return menuUserLink.getText();
	}

	public String usuariojaexiste() {
		return Usermanejaexiste.getText();
	}

	public void esperar() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,200)");
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
	}


}
