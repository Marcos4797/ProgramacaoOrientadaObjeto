import java.time.LocalDate;

public class EventoCobertura {
    private LocalDate data;
    private String tipoEvento;
    private Beneficiario solicitante;

    public EventoCobertura(LocalDate data, String tipoEvento, Beneficiario solicitante) {
        if (tipoEvento.equalsIgnoreCase("INTERNACAO") && !solicitante.podeInternar()) {

            throw new SecurityException("Aviso: Cobertura de INTERNAÇÃO negada para o dependente: " + solicitante.getNome());
        }
        this.data = data;
        this.tipoEvento = tipoEvento.toUpperCase();
        this.solicitante = solicitante;
        System.out.println("Sucesso: Evento de " + this.tipoEvento + " registrado para " + solicitante.getNome());
    }
}