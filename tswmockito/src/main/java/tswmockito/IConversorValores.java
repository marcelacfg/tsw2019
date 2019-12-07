package tswmockito;

public interface IConversorValores {
	double converterParaDouble(String valor) throws MoedaNaoEncontradaException, ValorInvalidoException;
	String converterParaString(double valor, String moeda) throws MoedaNaoEncontradaException;
}
