package solid_exercicios2;

public class TesteCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        Operacao soma = new Soma();
        Operacao subtracao = new Subtracao();
        Operacao multiplicacao = new Multiplicacao();
        Operacao divisao = new Divisao();

        int a = 10;
        int b = 5;

        System.out.println("Soma: " + calculadora.calcular(a, b, soma));

        System.out.println("Subtração: " + calculadora.calcular(a, b, subtracao));

        System.out.println("Multiplicação: " + calculadora.calcular(a, b, multiplicacao));

        try {
            System.out.println("Divisão: " + calculadora.calcular(a, b, divisao));
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

