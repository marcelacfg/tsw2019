package tswmockito;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConversorValoresTest {

	IConversorValores cv;
	
	@Before
	public void setUp() throws Exception {
		cv = new ConversorValores();
	}	

	@Test
	public void ConversorValoresReal() throws MoedaNaoEncontradaException, ValorInvalidoException {
		//Arrange
		String valor = "R$ 5.432,1";
		double valorDouble = 5432.1; 
		double valorReal;
		//Act
		valorReal = cv.converterParaDouble(valor);
		//Assert
		assertEquals(valorDouble, valorReal, 0);
	}
	
	@Test
	public void ConversorValoresDolar() throws MoedaNaoEncontradaException, ValorInvalidoException {
		//Arrange
		String valor = "US$ 12,345.67";
		double valorDouble = 12345.67; 
		double valorReal;
		//Act
		valorReal = cv.converterParaDouble(valor);
		//Assert		
		assertEquals(valorDouble, cv.converterParaDouble(valor), 0);
	}

	@Test(expected=MoedaNaoEncontradaException.class)
	public void ConversorValoresMoedaNaoEncontrada() throws MoedaNaoEncontradaException, ValorInvalidoException  {
		//Arrange
		String valor = "CAD 12,345.67";
		double valorDouble = 12345.67; 
		double valorReal;
		//Act
		valorReal = cv.converterParaDouble(valor);
		//Assert	
		assertEquals(valorDouble, cv.converterParaDouble(valor), 0);
	}
	
	@Test(expected=ValorInvalidoException.class)
	public void ConversorValoresValorInvalido() throws MoedaNaoEncontradaException, ValorInvalidoException  {
		//Arrange
		String valor = "US$ 1,2.345.67";
		double valorDouble = 12345.67; 
		double valorReal;
		//Act
		valorReal = cv.converterParaDouble(valor);
		//Assert	
		assertEquals(valorDouble, cv.converterParaDouble(valor), 0);
	}
	
	@Test
	public void ConversorValoresStringReal() throws MoedaNaoEncontradaException, ValorInvalidoException {
		//Arrange
		String valorString = "R$ 12.345,67";
		double valor = 12345.67; 
		String valorReal;
		String moeda = "R$";
		//Act
		valorReal = cv.converterParaString(valor, moeda);
		//Assert	
		assertEquals(valorString, valorReal);
	}
	
	@Test
	public void ConversorValoresStringDolar() throws MoedaNaoEncontradaException, ValorInvalidoException {
		//Arrange
		String valorString = "US$ 12,345.67";
		double valor = 12345.67; 
		String valorReal;
		String moeda = "US$";
		//Act
		valorReal = cv.converterParaString(valor, moeda);
		//Assert	
		assertEquals(valorString, valorReal);
	}

	@Test(expected=MoedaNaoEncontradaException.class)
	public void ConversorValoresMoedaNaoEncontradaString() throws MoedaNaoEncontradaException, ValorInvalidoException  {
		//Arrange
		String valorString = "CAD 1.0";
		double valor = 1; 
		String valorReal;
		String moeda = "CAD";
		//Act
		valorReal = cv.converterParaString(valor, moeda);
		//Assert	
		assertEquals(valorString, valorReal);
	}
	
}
