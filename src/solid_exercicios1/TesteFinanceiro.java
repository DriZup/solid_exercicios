package solid_exercicios1;

public class TesteFinanceiro {

    public static void main(String[] args) {
        RelatorioFinanceiro relatorioFinanceiro = new RelatorioFinanceiro();

        relatorioFinanceiro.gerarRelatorio();

        RelatorioFinanceiro.EnviandorEmail enviandorEmail = relatorioFinanceiro.new EnviandorEmail();

        enviandorEmail.enviarPorEmail("Relatorio Financeiro de Janeiro");
    }
}
