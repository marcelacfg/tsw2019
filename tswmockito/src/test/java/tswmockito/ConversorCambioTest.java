package tswmockito;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ConversorCambioTest {

	IConversorCambio cc;
	IConversorCambio ccm;
	IConversorValores cvm;
	IConversorValores cv;
	
	@Test
	public void ConversorValoresRealDolarMock() throws MoedaNaoEncontradaException, ValorInvalidoException {
		//Arrange
		cvm = mock(ConversorValores.class);
		ccm = new ConversorCambio(cvm);
		String valorParaConversao = "R$ 50,00";
		String valorConvertido = "US$ 25.00";
		String moeda = "US$";
		double valorParaConversaoDouble = 50;
		double valorConvertidoDouble = 25;
		
		when(cvm.converterParaDouble(valorParaConversao)).thenReturn(valorParaConversaoDouble);
		when(cvm.converterParaString(valorConvertidoDouble, moeda)).thenReturn(valorConvertido);
		double taxaConversao = 0.5;
		String valorConvertidoReal;
		
		//Act
		valorConvertidoReal = ccm.getValorConvertido(taxaConversao, valorParaConversao, moeda);
		
		//Assert
		assertEquals(valorConvertido, valorConvertidoReal);
	}
	
	@Test
	public void ConversorValoresDolarRealMock() throws MoedaNaoEncontradaException, ValorInvalidoException {
		// Arrange
		cvm = mock(ConversorValores.class);
		ccm = new ConversorCambio(cvm);
		String valorParaConversao = "US$ 25.00";
		String valorConvertido = "R$ 50,00";
		String moeda = "R$";
		double valorParaConversaoDouble = 25;
		double valorConvertidoDouble = 50;
		
		
		when(cvm.converterParaDouble(valorParaConversao)).thenReturn(valorParaConversaoDouble);
		when(cvm.converterParaString(valorConvertidoDouble, moeda)).thenReturn(valorConvertido);
		double taxaConversao = 2;
		String valorConvertidoReal;
				
		
		// Act
		valorConvertidoReal = ccm.getValorConvertido(taxaConversao, valorParaConversao, moeda);
		// Asserts
		assertEquals(valorConvertido, valorConvertidoReal);
	}
	
	@Test(expected=MoedaNaoEncontradaException.class)
	public void ConversorValoresMoedaInvalidaMock() throws MoedaNaoEncontradaException, ValorInvalidoException {
		
		// Arrange
		cvm = mock(ConversorValores.class);
		ccm = new ConversorCambio(cvm);
		String valorParaConversao = "CAD 25.00";
		String valorConvertido = "R$ 50,00";
		String moeda = "R$";
		double taxaConversao = 2;
		String valorConvertidoReal;
		double valorConvertidoDouble = 50;
		
		when(cvm.converterParaDouble(valorParaConversao)).thenThrow(MoedaNaoEncontradaException.class);
		when(cvm.converterParaString(valorConvertidoDouble, moeda)).thenReturn(valorConvertido);
				
		
		// Act
		valorConvertidoReal = ccm.getValorConvertido(taxaConversao, valorParaConversao, moeda);
		// Asserts
		assertEquals(valorConvertido, valorConvertidoReal);
		
	}
	
	@Test
	public void ConversorValoresRealDolar() throws MoedaNaoEncontradaException, ValorInvalidoException {
		//Arrange
		cv = new ConversorValores();
		cc = new ConversorCambio(cv);
		String valorParaConversao = "R$ 50,00";
		String valorConvertido = "US$ 25.00";
		String moeda = "US$";
		
		double taxaConversao = 0.5;
		String valorConvertidoReal;
		
		//Act
		valorConvertidoReal = cc.getValorConvertido(taxaConversao, valorParaConversao, moeda);
		
		//Assert
		assertEquals(valorConvertido, valorConvertidoReal);
		
	}
	
	@Test
	public void ConversorValoresDolarReal() throws MoedaNaoEncontradaException, ValorInvalidoException {
		// Arrange
		cv = new ConversorValores();
		cc = new ConversorCambio(cv);
		String valorParaConversao = "US$ 25.00";
		String valorConvertido = "R$ 50,00";
		String moeda = "R$";
		double taxaConversao = 2;
		String valorConvertidoReal;
				
		
		// Action
		valorConvertidoReal = cc.getValorConvertido(taxaConversao, valorParaConversao, moeda);
		// Asserts
		assertEquals(valorConvertido, valorConvertidoReal);
	}
	
	@Test(expected=MoedaNaoEncontradaException.class)
	public void ConversorValoresMoedaInvalida() throws MoedaNaoEncontradaException, ValorInvalidoException {
		// Arrange
		cv = new ConversorValores();
		cc = new ConversorCambio(cv);
		String valorParaConversao = "CAD 25.00";
		String valorConvertido = "R$ 50,00";
		String moeda = "R$";
		double taxaConversao = 2;
		String valorConvertidoReal;
				
		
		// Action
		valorConvertidoReal = cc.getValorConvertido(taxaConversao, valorParaConversao, moeda);
		// Asserts
		assertEquals(valorConvertido, cc.getValorConvertido(taxaConversao, valorParaConversao, moeda));
	}

}
