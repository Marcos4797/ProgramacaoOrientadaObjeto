public class Musica extends Midia implements Reproduzivel {
    private String artista;

    public Musica(String titulo, int duracaoEmMinutos, String artista) {
        super(titulo, duracaoEmMinutos);
        this.artista = artista;
    }

    @Override
    public double calcularCusto() {

        return 2.00;
    }

    @Override
    public void darPlay() {
        System.out.println("Reproduzindo a música: " + titulo + " - Artista: " + artista);
    }
}

