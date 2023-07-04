import java.util.Date;
import entities.enums.Status;
import entities.enums.Cargo;

public class Contratacao {
    private Date data;
    private Cargo cargo;
    private Status status;
    private Projeto projeto;
    private Funcionario funcionario;
    
// Constructor
    public Contratacao(Date data, Cargo cargo, Funcionario funcionario, Projeto projeto) {
        this.data = data;
        this.cargo = cargo;
        this.status = Status.PENDENTE;
        this.funcionario = funcionario;
        this.projeto = projeto;
        this.projeto.adicionarContratacao(this);
    }

// Methods
    public void contratar() {
        if(this.status == Status.PENDENTE){
            this.status = Status.CONTRATADO;
        }
    }

    public void demitir() {
        if(this.status == Status.CONTRATADO){
            this.status = Status.DEMITIDO;
        }
    }

// Getters and Setters
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }


// ToString
    @Override
    public String toString() {
        return "Contratacao [data=" + data + ", cargo=" + cargo + ", status=" + status + ", projeto=" + projeto + "]";
    }

}
