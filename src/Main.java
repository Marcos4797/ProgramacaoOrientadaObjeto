import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA VITACARE: VALIDANDO REGRAS --- \n");

        try {
            // 1. Criando um Titular (Idade presumida: 40 anos -> Faixa: R$ 340,00)
            Titular titular = new Titular("111.222.333-44", "Marcos Silva", LocalDate.of(1986, 5, 10));

            // 2. Criando Dependentes (Filho de 10 anos -> Base R$ 180,00 * 70% = R$ 126,00)
            Dependente filho = new Dependente("555.666.777-88", "Marcos Junior", LocalDate.of(2016, 3, 20));
            titular.adicionarDependente(filho);

            // 3. Criando um Aposentado (Idade presumida: 65 anos -> Base R$ 620,00 * 20% desc = R$ 496,00)
            Aposentado aposentado = new Aposentado("999.888.777-66", "Carlos Souza", LocalDate.of(1961, 1, 15), true);

            // 4. Testando Regra 6: Emitir Resumo de Contrato
            System.out.println("=== RESUMO DE CONTRATO ===");
            System.out.println("Titular: " + titular.getNome() + " | CPF: " + titular.getCpf() + " | Valor: R$ " + titular.calcularMensalidade());
            for (Dependente dep : titular.getDependentes()) {
                System.out.println(" -> Dependente: " + dep.getNome() + " | Idade: " + dep.getIdade() + " anos | Valor: R$ " + dep.calcularMensalidade());
            }
            System.out.println("TOTAL DO GRUPO FAMILIAR: R$ " + titular.calcularTotalGrupoFamiliar());
            System.out.println("==========================\n");

            System.out.println("=== VALOR APOSENTADO ===");
            System.out.println("Aposentado: " + aposentado.getNome() + " | Valor com Desconto: R$ " + aposentado.calcularMensalidade());
            System.out.println("========================\n");

            // 5. Testando Regra 7 e 8: Acionamentos de Cobertura
            System.out.println("=== TESTANDO COBERTURAS ===");
            // Consulta para dependente (Permitido)
            new EventoCobertura(LocalDate.now(), "CONSULTA", filho);
            // Internação para titular (Permitido)
            new EventoCobertura(LocalDate.now(), "INTERNACAO", titular);

            // Internação para dependente (DEVE FALHAR E IR PARA O CATCH)
            System.out.println("\nTentando internar dependente (Esperado bloquear)...");
            new EventoCobertura(LocalDate.now(), "INTERNACAO", filho);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\n-----------------------------------------");

        // 6. Testando barreira de segurança: Limite de idade do dependente
        try {
            System.out.println("\nTentando cadastrar dependente inválido (25 anos)...");
            Dependente dependenteVelho = new Dependente("222.333.444-55", "Lucas Adulto", LocalDate.of(2001, 1, 1));
        } catch (Exception e) {
            System.err.println("Bloqueio correto: " + e.getMessage());
        }
    }
}