package solid_exercicios2;

public class Calculadora {

    public int calcular(int a, int b, Operacao operacao){
        return operacao.calcular(a,b);
    }
}
