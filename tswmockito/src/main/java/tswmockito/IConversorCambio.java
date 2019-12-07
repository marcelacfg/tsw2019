package tswmockito;

public interface IConversorCambio { 
	String getValorConvertido(double taxaConversao, String valor, String moedaConversao) throws MoedaNaoEncontradaException, ValorInvalidoException;
}
