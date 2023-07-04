package atividade2;

import java.util.ArrayList;
import java.util.List;

public class Orientador {
	private String name;
	private List<Estudante> estudantes = new ArrayList<>();

	public Orientador(String name) {
		super();
		this.name = name;
	}

	public void addEstudante(Estudante estudante) {
		try {
			if (!estudantes.contains(estudante) && estudantes.size() < 3) {
				estudantes.add(estudante);
				estudante.addOrientador(this);
			} else {
				System.out.println("Ou já tem um aluno com esse nome ou já tem 3.");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Estudante> getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}

	@Override
    public String toString() {
        return "Orientador [name=" + name + ", estudantes=" + estudantesToString() + "]";
    }
    
    private String estudantesToString() {
        StringBuilder sb = new StringBuilder();
        for (Estudante estudante : estudantes) {
            sb.append(estudante.getMatricula()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
        }
        return sb.toString();
    }

}
