package solid_exercicios1;

public class TesteFinanceiro {

    public static void main(String[] args) {
        RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro();

        relatorioFinanceiro.gerarRelatorio();

        EnviandorEmail enviandorEmail = new EnviandorEmail();

        enviandorEmail.enviarPorEmail("Relatorio Financeiro de Janeiro");
    }
}
