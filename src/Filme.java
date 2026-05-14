public class Filme extends Midia implements Reproduzivel, Baixavel {

    private String qualidade;

    public Filme (String titulo, int duracaoEmMinutos,String qualidade) {
        super (titulo, duracaoEmMinutos ); // Passa os dados para a classe Midia
        this.qualidade = qualidade;
}
@Override
public double calcularCusto() {

    if ("4K".equalsIgnoreCase(this.qualidade)) {
        return 15.00;
    }
    return 10.00;
}
@Override
public void darPlay() {
    System.out.println("Reproduzindo o filme: " + titulo);
}

@Override
public void realizarDownload() {
    System.out.println("Fazendo download do filme...");
    }
}