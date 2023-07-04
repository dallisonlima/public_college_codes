import java.util.ArrayList;
import java.util.Date;

import entities.enums.Status;

public class Projeto {
    private String nome;
    private Date dt_inicio;
    private Date dt_termino;
    private Funcionario funcionario;
    private ArrayList<Contratacao> contratacoes = new ArrayList<>();

    public Projeto(String nome, Date dt_inicio, Date dt_termino) {
        this.nome = nome;
        this.dt_inicio = dt_inicio;
        this.dt_termino = dt_termino;
    }

    public boolean adicionarContratacao(Contratacao contratacao) {
        return this.contratacoes.add(contratacao);
    }

    public boolean removerContratacao(Contratacao contratacao) {
        return this.contratacoes.remove(contratacao);
    }

    public void listarContratacao() {
        System.out.println("***Contratações***");
        System.out.println("Projeto: ");
        System.out.println("\t" + this.nome);
        System.out.println("Funcionário(s): ");
        for (Contratacao contratacao : contratacoes) {
            if(contratacao.getStatus() == Status.CONTRATADO || contratacao.getStatus() == Status.PENDENTE)
                System.out.println("\t" + contratacao.getFuncionario().getNome() + " [Status: " + contratacao.getStatus() + "]");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Date getDt_termino() {
        return dt_termino;
    }

    public void setDt_termino(Date dt_termino) {
        this.dt_termino = dt_termino;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Contratacao> getContratacoes() {
        return contratacoes;
    }

    public void setContratacoes(ArrayList<Contratacao> contratacoes) {
        this.contratacoes = contratacoes;
    }

    @Override
    public String toString() {
        return "Projeto [nome=" + nome + ", dt_inicio=" + dt_inicio + ", dt_termino=" + dt_termino + ", funcionario="
                + funcionario + ", contratacoes=" + contratacoes + "]";
    }
}
