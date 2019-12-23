package tswselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	
	private WebDriver aDriver;
	
	/**
	 * URL's
	 */
	private static final String URL_GOOGLE = "https://google.com/";
	
	/**
	 * WebElement Locators for Google
	 */
	private static final String XPATH_INPUT_PESQUISA = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";
	private static final String XPATH_BOTAO_PESQUISA= "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]";
	
	public void accessURL() {
		this.aDriver.get(URL_GOOGLE);
	}
	
	/**
	 * Valores para preencherWebElements 
	 */
	
	/**
	 * HTML Tags and Attributes
	 */
	
	public GooglePage(WebDriver pDriver) {
		this.aDriver = pDriver;
		//this.aDriver.manage().window().maximize();
		accessURL();
	}
	
	public GooglePage preencherPesquisa(String pPesquisa) {
		preencherCampoInputPorXPath(XPATH_INPUT_PESQUISA, pPesquisa);
		return this;
	}
	
	private void pressionarBotao(String pPathBotao) {
		findElementByXPath(pPathBotao).click();
	}
	
	public void pressionarBotaoPesquisar() {
		pressionarBotao(XPATH_BOTAO_PESQUISA);
	}
	
	public void selecionarLink(String pLink) {
		findElementByPartialLink(pLink).click();
	}
	

		
	private WebElement preencherCampoInputPorXPath(String pXPath, String pValor) {
		WebElement campo = findElementByXPath(pXPath);
		
		// Limpa valores previamente digitados
		campo.clear();
		
		// Preenche o campo
		campo.sendKeys(pValor);
		
		return campo;
	}
	
	private WebElement findElementByXPath(String pXPath) {
		return aDriver.findElement(By.xpath(pXPath));
	}
	
	private WebElement findElementByPartialLink(String pLink) {
		return aDriver.findElement(By.partialLinkText(pLink));
	}
	
}