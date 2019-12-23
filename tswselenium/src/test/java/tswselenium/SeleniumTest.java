package tswselenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	private static final String PATH_CHROME_DRIVER = "C:\\temp\\unibratec\\tswselenium\\src\\main\\resources\\chromedriver.exe";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	private static ChromeDriver driver;
	
	static GooglePage gp;
	static BuscadorPage bp;
	
	@BeforeAll
	public static void setSystemPropertyChromeWebDriver() {
		System.setProperty(
		WEBDRIVER_CHROME_DRIVER,
		PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		
	}

	@AfterAll
	public static void testCloseG1() {
		//driver.close();
	}
	
	@Test
	public void testDoNothing() {
//		gp = new GooglePage(driver);
//		gp.preencherPesquisa("trivago");
//		gp.pressionarBotaoPesquisar();
		//gp.selecionarLink("kayak.com.br/");
		
		bp = new BuscadorPage(driver);
//		bp.preencherOrigem("Recife");
//		bp.preencherDestino("São Paulo");
//		bp.preencherEntrada("2020-02-21");
		bp.preencherSaida("21/02/2020");
	}

}
