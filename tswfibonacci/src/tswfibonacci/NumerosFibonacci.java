package tswfibonacci;

public class NumerosFibonacci implements INumerosFibonacci {

	@Override
	public long getNumeroFibonacci(int posicao) throws PosicaoInvalidaException {
		int t1 = 0;
		int t2 = 1;
		int valor = 0;
		
		if (posicao <= 0)
			throw new PosicaoInvalidaException();
		
		if (posicao == 1)
			valor = t1;
		else if (posicao == 2)
			valor = t2;
		else {
			for (int i = 0; i < posicao - 2; i++) {
				valor = t1 + t2;
				t1 = t2;
				t2 = valor;
			}
		}
		return valor;
	}

}
