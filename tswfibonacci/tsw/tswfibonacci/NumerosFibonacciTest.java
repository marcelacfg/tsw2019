package tswfibonacci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumerosFibonacciTest {
	INumerosFibonacci nf;
	@BeforeEach
	void setUp() throws Exception {
		nf = new NumerosFibonacci();
	}

	@Test
	void getNumeroFibonacciTest() throws PosicaoInvalidaException {
		//Arrange
		int posicao = 16;
		long resultado;
		long resultadoEsperado = 610;
		
		//Act
		resultado = nf.getNumeroFibonacci(posicao);
		
		//Assert
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	void getNumeroFibonacciException() {
		assertThrows(PosicaoInvalidaException.class, () -> {
			//Arrange
			int posicao = 0;
			long resultado;
			//Act
			resultado = nf.getNumeroFibonacci(0);
		});
	}

}
