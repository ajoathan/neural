package br.com.ajbg.neural;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import br.com.ajbg.util.Elemento;

public abstract class Neuronio {
	private double[] pesos;

	public Neuronio(int qtdEntradas) {
		pesos = new double[qtdEntradas + 1];

		Random r = new Random();
		for (int i=0; i<pesos.length; i++) {
			pesos[i] = r.nextDouble();
		}
	}

	protected abstract double ativacao(double sum);

	public double ativar(double[] entradas) {
		double sum = pesos[0];

		for (int i=1; i<pesos.length; i++) {
			sum += pesos[i] * entradas[i - 1];
		}

		return ativacao(sum);
	}

	public double ajustar(double[] entradas, double erro, double taxa) {
		pesos[0] += taxa * erro;

		for (int i=1; i<pesos.length; i++) {
			pesos[i] += taxa * erro * entradas[i - 1];
		}

		return Math.abs(erro);
	}

	public List<Double> treinar(List<Elemento> treino, double taxa,
			double maxError, int maxLoop) {
		List<Double> ret = new ArrayList<>();

		double erroMedio, sObtida;
		int count = 0;
		do {
			erroMedio = 0;

			for (Elemento e : treino) {
				sObtida = ativar(e.getEntradas());
				erroMedio += ajustar(e.getEntradas(), e.getSaida() - sObtida, taxa);
			}

			erroMedio /= treino.size();
			ret.add(erroMedio);
			count ++;
		} while (erroMedio > maxError && count < maxLoop);

		return ret;
	}
}

