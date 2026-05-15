public class Pix implements MeioPagamento {
        @Override
        public void pagar(double valor) {
            System.out.println("Pagando R$ " + valor + " via Pix. Chave: ...");
        }
        @Override
        public String tipo() {
            return "Pix";
        }
    }
