package project;

public class ContaDePoupanca {

	private static double taxaDeJurosAnual = 0;
	
	private double saldoDaPoupanca;

	public ContaDePoupanca(double saldoDaPoupanca) {
		super();
		this.saldoDaPoupanca = saldoDaPoupanca;
	}

	public void calculeRendimentoMensal() {
		double rendimentoMensal = (saldoDaPoupanca * (taxaDeJurosAnual/100))/12;
		saldoDaPoupanca += rendimentoMensal;
	}	
	
	public static void modifique(double novaTaxa) {
		taxaDeJurosAnual = novaTaxa;
	}

	@Override
	public String toString() {
		return "ContaDePoupanca [saldoDaPoupanca=" + saldoDaPoupanca + "]";
	}
	
}
