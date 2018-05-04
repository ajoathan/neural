package br.com.ajbg.util;

public class Elemento {
	private double[] entradas;
	private double saida;

	public Elemento(double[] e, double s) {
		entradas = e;
		saida = s;
	}

	public double[] getEntradas() {
		return entradas;
	}

	public double getSaida() {
		return saida;
	}
}

