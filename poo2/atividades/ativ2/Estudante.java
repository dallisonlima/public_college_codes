package atividade2;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
	private int matricula;
	private List<Orientador> orientadores = new ArrayList<>();

	public Estudante(int matricula, Orientador orientadores) {
		super();
		this.matricula = matricula;
		addOrientador(orientadores);
	}

	public void addOrientador(Orientador orientador) {
		try {
			if (!this.orientadores.contains(orientador) && this.orientadores.size() < 2) {
				this.orientadores.add(orientador);
				orientador.addEstudante(this);
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public List<Orientador> getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(List<Orientador> orientadores) {
		this.orientadores = orientadores;
	}

	@Override
    public String toString() {
        return "Estudante [matricula=" + matricula + ", orientadores=" + orientadoresToString() + "]";
    }
    
    private String orientadoresToString() {
        StringBuilder sb = new StringBuilder();
        for (Orientador orientador : orientadores) {
            sb.append(orientador.getName()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
        }
        return sb.toString();
    }

}
