package tswanagrama;

public class Anagrama implements IAnagrama{

	@Override
	public boolean isAnagramas(String palavra1, String palavra2) throws TextoVazioException {
		if (palavra1.trim().equals("") || palavra2.trim().equals(""))
			throw new TextoVazioException();
		palavra1 = palavra1.trim().toLowerCase();
		palavra2 = palavra2.trim().toLowerCase();
		
		if (palavra1.length() != palavra2.length())
			return false;
		else {
			String letra;
			Integer qtdLetraPalavra1 = 0;
			Integer qtdLetraPalavra2 = 0;
			for (int i = 0; i < palavra1.length(); i++) {
				qtdLetraPalavra1 = 0;
				qtdLetraPalavra2 = 0;
				letra = palavra1.substring(i, i + 1);
				if (!letra.equals("")) {
					for (int j = 0; j < palavra1.length(); j++) {
						if (letra.equals(palavra1.substring(j, j+1)))
							qtdLetraPalavra1++;
					}
					for (int j2 = 0; j2 < palavra2.length(); j2++) {
						if (letra.equals(palavra2.substring(j2, j2+1)))
							qtdLetraPalavra2++;
					}
				}
				if (qtdLetraPalavra1 != qtdLetraPalavra2) {
					return false;
					//break;
				}
			}
			return true;
		}
	}

}
