public class ProcessadorPagamento {
    private CartaoCredito cartao;

    public ProcessadorPagamento(CartaoCredito cartao) {
        this.cartao = cartao;
    }

    public void executarVenda(double valor) {
        if (valor <= cartao.getLimiteDisponivel()) {
            double novoLimite = cartao.getLimiteDisponivel() - valor;
            cartao.alterarLimite(novoLimite);
            System.out.println("Venda de R$ " + valor + " aprovada!");
        } else {
            System.out.println("Venda de R$ " + valor + " Negada: Limite insuficiente.");
        }
    }

        public void estornarVenda(double valor){
            double novoLimite = cartao.getLimiteDisponivel() + valor;
            cartao.alterarLimite(novoLimite);
            System.out.println("Estorno de R$ " + valor + " realizado com sucesso.");
        }
    }
