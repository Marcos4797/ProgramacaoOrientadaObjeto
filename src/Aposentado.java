
import java.time.LocalDate;

public class Aposentado extends Titular {
    private boolean comprovouAposentadoria;

    public Aposentado(String cpf, String nome, LocalDate dataNascimento, boolean comprovouAposentadoria) {
        super(cpf, nome, dataNascimento);
        if (!comprovouAposentadoria) {
            throw new IllegalArgumentException("É necessário comprovar a aposentadoria para esta categoria.");
        }
        this.comprovouAposentadoria = comprovouAposentadoria;
    }

    @Override
    public double calcularMensalidade() {
        return super.calcularMensalidade() * 0.80;
    }

    @Override
    public boolean podeInternar() {
        return true;
    }
}