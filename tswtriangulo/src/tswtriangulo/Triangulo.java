package tswtriangulo;

public class Triangulo implements ITriangulo {
	
	Double lado1;
	Double lado2;
	Double lado3;
	
	public Triangulo (Double pLado1, Double pLado2, Double pLado3) {
		lado1 = pLado1;
		lado2 = pLado2;
		lado3 = pLado3;
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
		return isValoressIguais(lado1, lado2) && isValoressIguais(lado2, lado3);
	}

	@Override
	public boolean isIsosceles() throws LadosInvalidosException {
		validarTodosOsLados();
		return (isValoressIguais(lado1, lado2) && (!isValoressIguais(lado1, lado3))) ||
				(isValoressIguais(lado1, lado3) && (!isValoressIguais(lado1, lado2))) ||
				(isValoressIguais(lado2,lado3) && (!isValoressIguais(lado2, lado1)));
	}

	@Override
	public boolean isEscaleno() throws LadosInvalidosException {
		validarTodosOsLados();
		return ((!isValoressIguais(lado1, lado2)) &&
				(!isValoressIguais(lado1, lado3)) &&
				(!isValoressIguais(lado2, lado3)));
	}

	@Override
	public boolean isTrianguloValido() throws LadosInvalidosException {
		validarTodosOsLados();
		return true;
	}

	@Override
	public boolean isTrianguloRetangulo() throws LadosInvalidosException {
		// a² = b² + c²
		validarTodosOsLados();
		return (
				(isValoressIguais((lado1*lado1), ((lado2*lado2) + (lado3*lado3)))) ||
				(isValoressIguais((lado2*lado2), ((lado1*lado1) + (lado3*lado3)))) ||
				(isValoressIguais((lado3*lado3), ((lado1*lado1) + (lado2*lado2))))
				);
	}

	@Override
	public Boolean isValoressIguais(Double valor1, Double valor2) {
		return valor1 - valor2 == 0;
	}

}
