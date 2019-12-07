package tswmockito;

public class ConversorCambio implements IConversorCambio {

	IConversorValores cv;
	
	ConversorCambio(IConversorValores cv) {
		this.cv = cv;
	}
	
	public String getValorConvertido(double taxaConversao, String valor, String moedaConversao) throws MoedaNaoEncontradaException, ValorInvalidoException {
		double valorDouble = cv.converterParaDouble(valor);
		double valorTotal = valorDouble * taxaConversao;
		return cv.converterParaString(valorTotal, moedaConversao);
	}

}
