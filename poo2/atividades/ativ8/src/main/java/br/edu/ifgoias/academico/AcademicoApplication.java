package br.edu.ifgoias.academico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.services.AlunoService;

@SpringBootApplication
public class AcademicoApplication {
	
	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(AcademicoApplication.class, args);
		AlunoService alunoService = context.getBean(AlunoService.class);
		
		// Criação de Alunos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dataNascimento1 = dateFormat.parse("2000-01-01");
		Aluno aluno1 = new Aluno("João", "M", dataNascimento1);
		
		Date dataNascimento2 = dateFormat.parse("2001-02-02");
		Aluno aluno2 = new Aluno("Maria", "F", dataNascimento2);
		
		// Inserção de Alunos
		alunoService.insert(aluno1);
		alunoService.insert(aluno2);
		
		// Listagem de Alunos
		List<Aluno> alunos = alunoService.findAll();
		System.out.println("Lista de Alunos:");
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
		
		// Busca por ID
		int alunoId = aluno1.getIdaluno();
		Aluno alunoEncontrado = alunoService.findById(alunoId);
		System.out.println("Aluno encontrado por ID:");
		System.out.println(alunoEncontrado);
		
		// Atualização de Aluno
		alunoEncontrado.setNome("João da Silva");
		alunoService.update(alunoId, alunoEncontrado);
		
		// Listagem de Alunos após atualização
		alunos = alunoService.findAll();
		System.out.println("Lista de Alunos após atualização:");
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
		
		// Remoção de Aluno
		alunoService.delete(alunoId);
		
		// Listagem de Alunos após remoção
		alunos = alunoService.findAll();
		System.out.println("Lista de Alunos após remoção:");
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
		
		context.close();
	}
	
}
