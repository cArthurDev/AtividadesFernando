package ed1.AtividadeModlle;

public class Aluno {
    private int matricula;
    private String nome;
    private String curso;

    public Aluno(int matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome ;
    }

    
}
