package tswtriangulo;

public class Triangulo implements ITriangulo {
	
	Double lado1;
	Double lado2;
	Double lado3;
	
	public Triangulo (Double pLado1, Double pLado2, Double pLado3) {
		lado1 = pLado1;
		lado2 = pLado2;
		lado3 = pLado3;
		//validarTodosOsLados();
	}

	@Override
	public void validarTamanhoLado(Double lado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarTodosOsLados() throws LadosInvalidosException {
		if ((!isTamanhoLadoValido(lado1, lado2, lado3)) || 
			(!isTamanhoLadoValido(lado2, lado1, lado3)) ||
			(!isTamanhoLadoValido(lado3, lado2, lado1)))
			throw new LadosInvalidosException();
		
	}

	@Override
	public Boolean isTamanhoLadoValido(Double lado) {
		return lado > 0;
	}
	
	@Override
	public Boolean isTamanhoLadoValido(Double ladoASerChecado, Double lado2, Double lado3) {
		return (isTamanhoLadoValido(ladoASerChecado)) && (ladoASerChecado < (lado2 + lado3)) && (ladoASerChecado > (Math.abs(lado2 - lado3)));
	}

	@Override
	public boolean isEquilatero() throws LadosInvalidosException {
		validarTodosOsLados();
		return isLadosIguais(lado1, lado2) && isLadosIguais(lado2, lado3);
	}

	@Override
	public boolean isIsosceles() throws LadosInvalidosException {
		validarTodosOsLados();
		return (isLadosIguais(lado1, lado2) && (!isLadosIguais(lado1, lado3))) ||
				(isLadosIguais(lado1, lado3) && (!isLadosIguais(lado1, lado2))) ||
				(isLadosIguais(lado2,lado3) && (!isLadosIguais(lado2, lado1)));
	}

	@Override
	public boolean isEscaleno() throws LadosInvalidosException {
		validarTodosOsLados();
		return ((!isLadosIguais(lado1, lado2)) &&
				(!isLadosIguais(lado1, lado3)) &&
				(!isLadosIguais(lado2, lado3)));
	}

	@Override
	public boolean isTrianguloValido() throws LadosInvalidosException {
		validarTodosOsLados();
		return true;
	}

	@Override
	public boolean isTrianguloRetangulo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean isLadosIguais(Double lado1, Double lado2) {
		return lado1 - lado2 == 0;
	}

}
