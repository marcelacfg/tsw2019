package tswordenador;

import java.util.ArrayList;

public class Ordenador implements iOrdenador{

	ArrayList<Double> colecaoArmazenada;
	Double maiorValor;
	Double menorValor;
	
	public Ordenador() {
		colecaoArmazenada = new ArrayList<Double>();
		maiorValor = 0.0;
		menorValor = 0.0;
	}
	
	@Override
	public void inserirColecao(ArrayList<String> pColecao) throws NumeroInvalidoException {
		for (int i = 0; i < pColecao.size(); i++) {
			inserirNumero(converterValor(pColecao.get(i)));
		}
	}

	@Override
	public void informarValor(String pValor) throws NumeroInvalidoException {
		inserirNumero(converterValor(pValor));
	}

	@Override
	public Double getMaiorValor() {
		return maiorValor;
	}

	@Override
	public Double getMenorValor() {
		return menorValor;
	}

	@Override
	public Double getValorMedio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getValorMediana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirNumero(Double pNumero) {
		if ((pNumero > maiorValor) || (colecaoArmazenada.size() == 0))
			maiorValor = pNumero;
		if ((pNumero < menorValor) || (colecaoArmazenada.size() == 0))
			maiorValor = pNumero;
	
		colecaoArmazenada.add(pNumero);
	}

	@Override
	public Double converterValor(String pValor) throws NumeroInvalidoException {
		try {
			return Double.parseDouble(pValor);
		} catch (Exception e) {
			throw new NumeroInvalidoException();
		}
	}

}
