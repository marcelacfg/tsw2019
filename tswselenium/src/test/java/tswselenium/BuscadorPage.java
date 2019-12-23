package tswselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscadorPage {
private WebDriver aDriver;
	
	/**
	 * URL's
	 */
	private static final String URL_BUSCADOR = "https://www.kayak.com.br/";
	
	/**
	 * WebElement Locators for Buscador
	 */
	private static final String XPATH_INPUT_DESTINO = "//*[@id=\"querytext\"]";
	private static final String XPATH_TIME_ENTRADA = "//*[@id=\"js-fullscreen-hero\"]/div[1]/div[2]/div[2]/button/span/span[2]/time";
	private static final String XPATH_TIME_SAIDA = "//*[@id=\"m6zQ-depart-input\"]";
	
	//private static final String XPATH_BOTAO_DESTINO= "//*[@id=\"e25d-destination-airport\"]";
	
	public void accessURL() {
		this.aDriver.get(URL_BUSCADOR);
	}
	
	/**
	 * Valores para preencherWebElements 
	 */
	
	/**
	 * HTML Tags and Attributes
	 */
	
	public BuscadorPage(WebDriver pDriver) {
		this.aDriver = pDriver;
		//this.aDriver.manage().window().maximize();
		accessURL();
	}
//	
//	public BuscadorPage preencherOrigem(String pOrigem) {
//		preencherCampoInputPorXPath(XPATH_INPUT_ORIGEM, pOrigem);
//		return this;
//	}
	
	public BuscadorPage preencherDestino(String pDestino) {
		preencherCampoInputPorXPath(XPATH_INPUT_DESTINO, pDestino);
		return this;
	}
	
	public BuscadorPage preencherEntrada(String pEntrada) {
		preencherCampoInputPorXPath(XPATH_TIME_ENTRADA, pEntrada);
		return this;
	}
	
	public BuscadorPage preencherSaida(String pSaida) {
		pressionarBotao("//*[@id=\"c192p-dateRangeInput-display-start\"]/div");
		preencherCampoInputPorXPath(XPATH_TIME_SAIDA, pSaida);
		return this;
	}
	
	private void pressionarBotao(String pPathBotao) {
		findElementByXPath(pPathBotao).click();
	}
	
//	public void pressionarBotaoPesquisar() {
//		pressionarBotao(XPATH_BOTAO_PESQUISA);
//	}
	
	public void selecionarLink(String pLink) {
		findElementByPartialLink(pLink).click();
	}
	
//	public void facebookLoginTest() {
//		this.aDriver.get(URL_GOOGLE);
//		this.aDriver.manage().window().maximize();
//		
//		/*WebElement inputEmail		=*/ preencherEmailLogin(EMAIL);
//		
//		/*WebElement password		=*/ preencherSenhaLogin(SENHA);
//		
//		//inputEmail.submit();
//		pressionarBotaoEntrar();
//	}
	

		
//	private WebElement preencherCampoDataPorXPath(String pXPath, String pValor) {
//		
//		WebElement campo = findElementByXPath(pXPath);
//		
//		// Limpa valores previamente digitados
//		campo.clear();
//	
//	// Preenche o campo
//		campo.sendKeys(pValor);
//		campo.sendKeys(Keys.TAB);
//		
//		return campo;
//	}

	private WebElement preencherCampoInputPorXPath(String pXPath, String pValor) {
		WebElement campo = findElementByXPath(pXPath);
		
		// Limpa valores previamente digitados
		campo.clear();
		
		// Preenche o campo
		campo.sendKeys(pValor);
		campo.sendKeys(Keys.TAB);
		
		return campo;
	}
	
	private WebElement findElementByXPath(String pXPath) {
		return aDriver.findElement(By.xpath(pXPath));
	}
	
	private WebElement findElementByPartialLink(String pLink) {
		return aDriver.findElement(By.partialLinkText(pLink));
	}
	
}
