package tswanagrama;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IAnagramaTest {

	IAnagrama anagrama;
	@BeforeEach
	void setUp() throws Exception {
		anagrama = new Anagrama();
	}

	@Test
	void testIsAnagramasPositivo() throws TextoVazioException {
		//Arrange
		String palavra1 = "Ts ete";
		String palavra2 = "Test e";
		boolean resultado;
		//Act
		resultado = anagrama.isAnagramas(palavra1, palavra2);
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	void testIsAnagramasPositivoAmor() throws TextoVazioException {
		//Arrange
		String palavra1 = "Amor";
		String palavra2 = "Roma";
		boolean resultado;
		//Act
		resultado = anagrama.isAnagramas(palavra1, palavra2);
		
		//Assert
		assertTrue(resultado);
	}
	
	@Disabled
	@Test
	void testIsAnagramasNegativo() throws TextoVazioException {
		//Arrange
		String palavra1 = "Testa";
		String palavra2 = "Teste";
		boolean resultado;
		//Act
		resultado = anagrama.isAnagramas(palavra1, palavra2);
		
		//Assert
		assertFalse(resultado);
		
	}
	
	@Disabled
	@Test
	void testIsAnagramasNegativoQtdLetraDiferente() throws TextoVazioException {
		//Arrange
		String palavra1 = "Testta";
		String palavra2 = "Testea";
		boolean resultado;
		//Act
		resultado = anagrama.isAnagramas(palavra1, palavra2);
		
		//Assert
		assertFalse(resultado);
		
	}
	
	@Disabled
	@Test
	void testIsAnagramasNegativoQtdLetras() throws TextoVazioException {
		//Arrange
		String palavra1 = "Teste";
		String palavra2 = "Teeste";
		boolean resultado;
		//Act
		resultado = anagrama.isAnagramas(palavra1, palavra2);
		
		//Assert
		assertFalse(resultado);
		
	}
	
	@Disabled
	@Test
	void testIsAnagramasExceptionPalavra1() {
		assertThrows(TextoVazioException.class, () -> {
			//Arrange
			String palavra1 = "Marcela";
			String palavra2 = " ";
			
			//Act
			anagrama.isAnagramas(palavra1, palavra2);
			
		});
	}
	
	@Disabled
	@Test
	void testIsAnagramasExceptionPalavra2() {
		assertThrows(TextoVazioException.class, () -> {
			//Arrange
			String palavra1 = " ";
			String palavra2 = "Marcela";
			
			//Act
			anagrama.isAnagramas(palavra1, palavra2);
			
		});
	}

}
