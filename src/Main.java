//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Interestelar", 169, "4K");
        Musica minhaMusica = new Musica("Starman", 256, "David Bowie");


        System.out.println("Duração do Filme: " + ConversorTempo.formatarMinutos(meuFilme.getDuracaoEmMinutos()));
        System.out.println("Duração da Música: " + ConversorTempo.formatarMinutos(minhaMusica.getDuracaoEmMinutos()));


        processarPlayer(meuFilme);
        processarPlayer(minhaMusica);
        }

    public static void processarPlayer(Reproduzivel item) {
        System.out.println("Iniciando reprodução via polimorfismo...");
        item.darPlay();
        }
 }

