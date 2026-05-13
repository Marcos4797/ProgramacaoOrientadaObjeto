public class ConversorTempo {

        public static String formatarMinutos(int totalMinutos) {
        int horas = totalMinutos / 60;
        int minutosRestantes = totalMinutos % 60;
        return String.format("%dh %02dmin", horas, minutosRestantes);
    }
}