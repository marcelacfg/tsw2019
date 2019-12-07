package tswpalindromo;

public class Palindromo implements IPalindromo{

	@Override
	public boolean isPalindromo(String texto) throws TextoVazioException {
		int qtd = 0;
		int i = 0;
		boolean r = true;
		if (texto.equals(""))
			throw new TextoVazioException();
		
		texto = texto.replace(" ", "");
		texto = texto.toLowerCase();
		
		if (texto.length() % 2 == 0)
			qtd = texto.length() / 2;
		else	
			qtd = (texto.length() - 1) / 2;
		
		 while (i < qtd) {
			 System.out.println(texto);
			 System.out.println(qtd);
			 System.out.println("1" + texto.substring(i, i + 1));
			 System.out.println("2" + texto.substring(texto.length() - i - 1, texto.length() - i));
			
			 if (!texto.substring(i, i + 1).equals(texto.substring(texto.length() - i - 1, texto.length() - i))) {
				r = false;
				break;
			 }
			 i++;
		}
		
		return r;
	}

}
