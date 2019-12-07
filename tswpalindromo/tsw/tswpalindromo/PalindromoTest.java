package tswpalindromo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromoTest {
	Palindromo palindromo;
	
	@BeforeEach
	void setUp() throws Exception {
		palindromo = new Palindromo();
	}

	@Test
	void testIsPalindromoFalse() throws TextoVazioException {
		//Arrange
		String texto = "Marcela";
		Boolean resultado;
		
		//Act
		resultado = palindromo.isPalindromo(texto);
		
		//Assert
		assertFalse(resultado);
	}
	
	@Test
	void testIsPalindromoTrue() throws TextoVazioException {
		//Arrange 
		String texto = "A sacada da Casa";
		Boolean resultado;
		
		//Act
		resultado = palindromo.isPalindromo(texto);
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	void testIsPalindromoVazio() throws TextoVazioException {
		assertThrows(TextoVazioException.class, () -> {
			
			//Arrange
			String texto = "";
			Boolean resultado;
			
			//Act
			resultado = palindromo.isPalindromo(texto);
		});
	}

}
