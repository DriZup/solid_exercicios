package solid_exercicios1;

public class RelatorioFinanceiro {
    public void gerarRelatorio() {
        System.out.println("Gerando relatório financeiro...");
    }

    public class EnviandorEmail {
        public void enviarPorEmail(String relatorio) {
            System.out.println("Enviando relatorio por email: " + relatorio);
        }
    }
}
