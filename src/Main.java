
    public class Main {
        public static void main(String[] args) {

            CartaoCredito meuCartao = new CartaoCredito("4444-5555-6666-7777", "Seu Nome", 5000.00);

            ProcessadorPagamento processador = new ProcessadorPagamento(meuCartao);

            System.out.println("--- Iniciando Venda 1 ---");
            processador.executarVenda(2000.00);
            System.out.println("Limite Disponível: R$ " + meuCartao.getLimiteDisponivel());

            System.out.println("\n--- Iniciando Venda 2 (Teste de Erro) ---");

            processador.executarVenda(4000.00);
            System.out.println("Limite Final: R$ " + meuCartao.getLimiteDisponivel());
        }
    }

