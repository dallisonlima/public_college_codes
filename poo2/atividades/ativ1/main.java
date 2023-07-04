package project;

public class main {

	public static void main(String[] args) {
		
		ContaDePoupanca.modifique(1);
		
		ContaDePoupanca poupador1 = new ContaDePoupanca(7000.00f);
		ContaDePoupanca poupador2 = new ContaDePoupanca(3000.00f);
		
		System.out.println(poupador1.toString());
		System.out.println(poupador2.toString());
		
		poupador1.calculeRendimentoMensal();
		poupador2.calculeRendimentoMensal();
		
		System.out.println(poupador1.toString());
		System.out.println(poupador2.toString());
		
		
	}

}
