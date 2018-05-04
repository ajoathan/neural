package br.com.ajbg.util;

import java.util.List;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.IOException;

public class SimpleSolution {
	public static List<Elemento> load(InputStream is, int qtdIn)
			throws IOException {
		List<Elemento> ret = new ArrayList<>();
		double[] entradas = new double[qtdIn];

		is.close();
		ret.add(new Elemento(new double[]{0, 0}, 0));
		ret.add(new Elemento(new double[]{0, 1}, 0));
		ret.add(new Elemento(new double[]{1, 0}, 0));
		ret.add(new Elemento(new double[]{1, 1}, 1));

		return ret;
	}

	public static List<Elemento> loadResource(String resource, int qtdIn)
			throws IOException {
		InputStream is = SimpleSolution.class.getResourceAsStream(resource);
		return load(is, qtdIn);
	}
}

