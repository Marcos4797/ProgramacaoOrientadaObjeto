public class Filme extends Midia implements Reproduzivel, Baixavel {
    // Atributo extra solicitado
    private String qualidade;
    // Construtor: recebe os dados e repassa para a classe Midia (super)
    public Filme (String titulo, int duracaoEmMinutos,String qualidade) {
        super (titulo, duracaoEmMinutos ); // Passa os dados para a classe Midia
        this.qualidade = qualidade;
}
// Implementando o método abstrato da classe Midia
@Override
public double calcularCusto() {
    // Exemplo: Filmes custam 10 reais fixos
    // Se a qualidade for 4K (sem importar maiúsculas/minúsculas), soma 5 ao custo base
    if ("4K".equalsIgnoreCase(this.qualidade)) {
        return 15.00;
    }
    return 10.00;
}
// Implementando o método da interface Reproduzivel
@Override
public void darPlay() {
    System.out.println("Reproduzindo o filme: " + titulo);
}
// Implementando o método da interface Baixavel (supondo que o método se chame baixar)
@Override
public void realizarDownload() {
    System.out.println("Fazendo download do filme...");
    }
}