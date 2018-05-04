package br.com.ajbg;

import java.util.List;

import br.com.ajbg.neural.Neuronio;
import br.com.ajbg.neural.NeuronioDegrau;
import br.com.ajbg.util.Elemento;
import br.com.ajbg.util.SimpleSolution;

public class App {
	public static void main(String[] args) throws Exception {
		List<Elemento> treino = SimpleSolution.loadResource("/and.txt", 2);

		Neuronio n = new NeuronioDegrau(2);
		System.out.println("Antes:");
		for (Elemento e : treino) {
			System.out.println(n.ativar(e.getEntradas()));
		}

		List<Double> erro = n.treinar(treino, 1, 0, 100);
		System.out.println("Depois:");
		for (Elemento e : treino) {
			System.out.println(n.ativar(e.getEntradas()));
		}

		System.out.println("Curva de erro:");
		for (Double d : erro) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
}

