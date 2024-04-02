package ed1.AtividadeModlle;

public class Refeitorio {
    public static void main(String[] args) {
        Object[] filaRefeitorio = new Object[11];

        filaRefeitorio[0] = new Aluno(123456, "João", "Engenharia");
        filaRefeitorio[1] = new Professor(7890, "Maria", "Doutorado");
        filaRefeitorio[2] = new TecnicoAdministrativo(5678, "Pedro");
        filaRefeitorio[3] = new Aluno(123456, "Caio", "Engenharia");
        filaRefeitorio[4] = new Professor(7890, "Luiza", "Doutorado");
        filaRefeitorio[5] = new TecnicoAdministrativo(5678, "Bruno");
        filaRefeitorio[6] = new TecnicoAdministrativo(5678, "Gustavo");
        filaRefeitorio[7] = new Aluno(123456, "Leo", "Engenharia");
        filaRefeitorio[8] = new Professor(7890, "Fernando", "Doutorado");
        filaRefeitorio[9] = new Aluno(123456, "Gabriel", "Engenharia");
        filaRefeitorio[10] = new Professor(7890, "Rafael", "Doutorado");
        filaRefeitorio[11] = new TecnicoAdministrativo(5678, "Thiago");

        System.out.println("Fila de acesso ao refeitório:");

        for (Object frequentador : filaRefeitorio) {
            if (frequentador != null) {
                System.out.println(frequentador);
            }
        }
    }
}
