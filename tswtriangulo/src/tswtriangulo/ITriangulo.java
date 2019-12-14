package tswtriangulo;

public interface ITriangulo {

	//public ITriangulo(Double lado1, Double lado2, Double lado3);
	void validarTamanhoLado(Double lado);
	void validarTodosOsLados() throws LadosInvalidosException;
	Boolean isTamanhoLadoValido(Double lado);
	
	Boolean isTamanhoLadoValido(Double ladoASerChecado, Double lado2, Double lado3);
	Boolean isValoressIguais(Double valor1, Double valor2);
	
	boolean isEquilatero() throws LadosInvalidosException;
	boolean isIsosceles() throws LadosInvalidosException;
	boolean isEscaleno() throws LadosInvalidosException;
	boolean isTrianguloValido() throws LadosInvalidosException;
	boolean isTrianguloRetangulo() throws LadosInvalidosException;
	
	
}
