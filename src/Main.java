import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SISTEMA VITACARE: VALIDANDO REGRAS --- \n");

        try {
            Titular titular = new Titular("111.222.333-44", "Marcos Silva", LocalDate.of(1986, 5, 10));

            Dependente filho = new Dependente("555.666.777-88", "Marcos Junior", LocalDate.of(2016, 3, 20));
            titular.adicionarDependente(filho);

            Aposentado aposentado = new Aposentado("999.888.777-66", "Carlos Souza", LocalDate.of(1961, 1, 15), true);

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

            System.out.println("=== TESTANDO COBERTURAS ===");
            new EventoCobertura(LocalDate.now(), "CONSULTA", filho);
            new EventoCobertura(LocalDate.now(), "INTERNACAO", titular);

            System.out.println("\nTentando internar dependente (Esperado bloquear)...");
            new EventoCobertura(LocalDate.now(), "INTERNACAO", filho);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\n-----------------------------------------");


        try {
            System.out.println("\nTentando cadastrar dependente inválido (25 anos)...");
            Dependente dependenteVelho = new Dependente("222.333.444-55", "Lucas Adulto", LocalDate.of(2001, 1, 1));
        } catch (Exception e) {
            System.err.println("Bloqueio correto: " + e.getMessage());
        }
    }
}