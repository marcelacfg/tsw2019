package tswordenador;

import java.util.ArrayList;

public interface iOrdenador {
	 void inserirColecao(ArrayList<String> pColecao) throws NumeroInvalidoException ;
	 void informarValor(String pValor) throws NumeroInvalidoException;
	 Double getMaiorValor();
	 Double getMenorValor();
	 Double getValorMedio();
	 Double getValorMediana();
	 
	 void inserirNumero(Double pNumero);
	 Double converterValor(String pValor) throws NumeroInvalidoException;
}
