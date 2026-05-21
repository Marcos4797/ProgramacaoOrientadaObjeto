
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Titular extends Beneficiario {

    private final List<Dependente> dependentes = new ArrayList<>();

    public Titular(String cpf, String nome, LocalDate dataNascimento) {
        super(cpf, nome, dataNascimento);
    }

    public void adicionarDependente(Dependente dependente) {
        if (dependentes.size() >= 3) {
            throw new IllegalStateException("Limite de 3 dependentes atingido para este Titular.");
        }
        if (!dependente.isElegivel()) {
            throw new IllegalArgumentException("Dependente maior de 24 anos não pode ser inserido.");
        }
        this.dependentes.add(dependente);
    }

    @Override
    public double calcularMensalidade() {
        return calcularMensalidadeBase();
    }

    public double calcularTotalGrupoFamiliar() {
        double total = this.calcularMensalidade();
        for (Dependente dep : dependentes) {
            total += dep.calcularMensalidade();
        }
        return total;
    }

    @Override
    public boolean podeInternar() {
        return true;
    }

    public List<Dependente> getDependentes() {
        return Collections.unmodifiableList(dependentes); // Protege a lista contra manipulação externa
    }
}
