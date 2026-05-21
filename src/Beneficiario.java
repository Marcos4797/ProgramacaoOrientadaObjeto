
import java.time.LocalDate;
import java.time.Period;

public abstract class Beneficiario implements CalcularMensalidade {

    private final String cpf; // final garante que não muda após o cadastro (Regra 1)
    private String nome;
    private LocalDate dataNascimento;

    public Beneficiario(String cpf, String nome, LocalDate dataNascimento) {
        if (cpf == null || nome == null || dataNascimento == null) {
            throw new IllegalArgumentException("Dados do beneficiário não podem ser nulos.");
        }
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }


    public int getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }


    public double calcularMensalidadeBase() {
        int idade = getIdade();
        if (idade <= 18) {
            return 180.00;
        } else if (idade <= 59) {
            return 340.00;
        } else {
            return 620.00;
        }
    }


    public abstract boolean podeInternar();


    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}