    public class CartaoCredito {

        private String numeroCartao;
        private String titular;
        private double limiteDisponivel;
        private String cvv;

    public CartaoCredito(String numeroCartao, String titular, double limiteInicial) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
        this.limiteDisponivel = limiteInicial;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
            }

    public void alterarLimite(double novoValor) {
        if (novoValor >= 0) {
            this.limiteDisponivel = novoValor;
        } else {
            System.out.println("Erro: O limite não pode ser negativo.");
        }
    }
}