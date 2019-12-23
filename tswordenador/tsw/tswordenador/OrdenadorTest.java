package tswordenador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdenadorTest {

	Ordenador ordenador;
	ArrayList<String> lista;
	
	@BeforeEach
	void setUp() throws Exception {
		ordenador = new Ordenador();
		lista = new ArrayList<String>();
	}

	@Test
	void testInserirColecao() throws NumeroInvalidoException {
		//Arrange
		lista.add("1");
		lista.add("2");
		lista.add("3");
		Integer qtdRegistros;
		//Act
		ordenador.inserirColecao(lista);
		qtdRegistros = ordenador.colecaoArmazenada.size();
		//Assert
		assertEquals(3, qtdRegistros);
	}
	
	@Test
	void testInserirColecaoException() {
		assertThrows(NumeroInvalidoException.class, () -> {
			//Arrange
			lista.add("1");
			lista.add("2");
			lista.add("M");
			Integer qtdRegistros;
			//Act
			ordenador.inserirColecao(lista);	
		});
	}

	@Test
	void testInformarValor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMaiorValor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMenorValor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetValorMedio() {
		fail("Not yet implemented");
	}

	@Test
	void testGetValorMediana() {
		fail("Not yet implemented");
	}

}
