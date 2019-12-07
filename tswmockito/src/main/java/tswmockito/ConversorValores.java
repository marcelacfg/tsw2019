package tswmockito;

import java.text.DecimalFormat;

public class ConversorValores implements IConversorValores{

	public double converterParaDouble(String valor) throws MoedaNaoEncontradaException, ValorInvalidoException {
		double valorConvertido = 0;
		String valorString = "";
		if (valor.substring(0,2).equals("R$")) {
			valorString = valor.substring(3).trim();
			valorString = valorString.replace(".", "");
			valorString = valorString.replace(",", ".");
		}
		else if (valor.substring(0,3).equals("US$")) { 
			valorString = valor.substring(4).trim();
			valorString = valorString.replace(",", "");
		}
		else
			throw new MoedaNaoEncontradaException();
		
		try {
			valorConvertido = Double.parseDouble(valorString);
		} catch (Exception e) {
			throw new ValorInvalidoException();
		}
		return valorConvertido;
	}

	public String converterParaString(double valor, String moeda) throws MoedaNaoEncontradaException {
		DecimalFormat df;
		String valorString;
		df = new DecimalFormat("#,##0.00");
		valorString = df.format(valor);
		if (moeda.equals("R$")) {
			valorString = "R$ " + valorString; 
		}else if (moeda.equals("US$")) {
			valorString = valorString.replace(".", "/");
			valorString = valorString.replace(",", ".");
			valorString = valorString.replace("/", ",");
			valorString = "US$ " + valorString;
		
		}else
			throw new MoedaNaoEncontradaException();
		return valorString;
	}
	


}
