package atividade2;

public class Program {

	public static void main(String[] args) {
		Orientador orientador1 = new Orientador("Dory");
		Orientador orientador2 = new Orientador("Raphael");
		Orientador orientador3 = new Orientador("Sirlon");
		
		Estudante estudante1 = new Estudante(123, orientador1);

		estudante1.addOrientador(orientador3);
		
		System.out.println(orientador1 + "\n" + estudante1);
	}
}
