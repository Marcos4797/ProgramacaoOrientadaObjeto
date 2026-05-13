public abstract class Midia {

    // Atributos
    protected String titulo;
    private int duracaoEmMinutos;

    // Construtor
    public Midia (String titulo, int duracaoEmMinutos) {
        this.titulo = titulo;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    // Metodo Concreto
    public void exibirDetalhes() {
        System.out.println("Titulo" + titulo + " | Duração: " + duracaoEmMinutos + "min");
    }
    // Metodo Abstrato (sem corpo, termina com ponto e vírgula)
    public abstract double calcularCusto();

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }
}


