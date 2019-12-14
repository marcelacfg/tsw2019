package tswtriangulo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ITrianguloTest {

	ITriangulo triangulo;

	@Test
	void testIsEquilateroPositivo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.5, 5.5, 5.5);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isEquilatero();
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	void testIsEquilateroNegativo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.5, 5.5, 5.4);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isEquilatero();
		
		//Assert
		assertFalse(resultado);
	}
	
	@Test
	void testIsEquilateroException() {
		//Arrange
		triangulo = new Triangulo(10.1, 5.0, 5.0);
		//Act
		
		//Assert
		assertThrows(LadosInvalidosException.class, () -> {
			triangulo.isEquilatero();
		});
	}

	@Test
	void testIsIsoscelesPositivo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.5, 5.5, 5.4);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isIsosceles();
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	void testIsIsoscelesNegativo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.5, 5.5, 5.5);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isIsosceles();
		
		//Assert
		assertFalse(resultado);
	}

	@Test
	void testIsIsoscelesException() {
		//Arrange
		triangulo = new Triangulo(0.0, 5.5, 5.5);
		//Act
		//Assert
		assertThrows(LadosInvalidosException.class, () -> {
			triangulo.isIsosceles();
		});
	}
	
	@Test
	void testIsEscalenoPositivo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.5, 5.4, 5.3);
		Boolean resultado;
		//Act
				
		resultado = triangulo.isEscaleno();
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	void testIsEscalenoNegativo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.5, 5.5, 5.5);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isIsosceles();
		
		//Assert
		assertFalse(resultado);
	}
	
	@Test
	void testIsEscalenoException() {
		//Arrange
		triangulo = new Triangulo(-5.5, 5.5, 5.5);
		//Act
		//Assert
		assertThrows(LadosInvalidosException.class, () -> {
			triangulo.isEscaleno();
		});
	}
	
	@Test
	void testIsRetanguloPositivo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(3.0, 4.0, 5.0);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isTrianguloRetangulo();
		
		//Assert
		assertTrue(resultado);
	}
	
	@Test
	void testIsRetanguloNegativo() throws LadosInvalidosException {
		//Arrange
		triangulo = new Triangulo(5.1, 4.0, 3.0);
		Boolean resultado;
		//Act
		
		resultado = triangulo.isTrianguloRetangulo();
		
		//Assert
		assertFalse(resultado);
	}
	
	@Test
	void testIsRetanguloException() {
		//Arrange
		triangulo = new Triangulo(10.1, 5.0, 5.0);
		//Act
		
		//Assert
		assertThrows(LadosInvalidosException.class, () -> {
			triangulo.isTrianguloRetangulo();
		});
	}

}
