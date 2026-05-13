//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /// 1. Instanciar (Corrigido para 3 parâmetros no Filme)
        Filme meuFilme = new Filme("Interestelar", 169, "4K");
        Musica minhaMusica = new Musica("Starman", 256, "David Bowie");

        // 2. Exibir duração formatada usando o método estático
        System.out.println("Duração do Filme: " + ConversorTempo.formatarMinutos(meuFilme.getDuracaoEmMinutos()));
        System.out.println("Duração da Música: " + ConversorTempo.formatarMinutos(minhaMusica.getDuracaoEmMinutos()));

        // Ação: Chamar o método de polimorfismo para os dois objetos
        processarPlayer(meuFilme);
        processarPlayer(minhaMusica);
        }
    // Ação: Método que aceita qualquer objeto que implemente Reproduzivel
    public static void processarPlayer(Reproduzivel item) {
        System.out.println("Iniciando reprodução via polimorfismo...");
        item.darPlay();
        }
 }

