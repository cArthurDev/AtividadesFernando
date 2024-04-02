package ed1.AtividadeModlle;

public class TecnicoAdministrativo {
    private int siape;
    private String nome;

    public TecnicoAdministrativo(int siape, String nome) {
        this.siape = siape;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Técnico Administrativo: " + nome;
    }
    
}
