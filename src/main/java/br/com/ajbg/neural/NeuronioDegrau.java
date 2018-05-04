package br.com.ajbg.neural;

public class NeuronioDegrau extends Neuronio {
	public NeuronioDegrau(int qtdEntradas) {
		super(qtdEntradas);
	}

	protected double ativacao(double sum) {
		if (sum <= 0) {
			return 0;
		} else {
			return 1;
		}
	}
}

