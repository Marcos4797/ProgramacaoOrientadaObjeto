
import java.time.LocalDate;

public class Dependente extends Beneficiario {

    public Dependente(String cpf, String nome, LocalDate dataNascimento) {
        super(cpf, nome, dataNascimento);
        if (!isElegivel()) {
            throw new IllegalArgumentException("Dependente não elegível! Idade máxima permitida é 24 anos.");
        }
    }

    public boolean isElegivel() {
        return getIdade() <= 24;
    }

    @Override
    public double calcularMensalidade() {
        double valorBruto = calcularMensalidadeBase() * 0.70;
        return Math.round(valorBruto * 100.0) / 100.0;
    }

    @Override
    public boolean podeInternar() {
        return false;
    }
}