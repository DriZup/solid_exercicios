package solid_exercicio3;

public class FormaApp {

    public static void main(String[] args) {

        Forma retangulo = new Retangulo(5, 10);
        System.out.println("Área do Retângulo: " + retangulo.getArea());


        Forma quadrado = new Quadrado(10);
        System.out.println("Área do Quadrado: " + quadrado.getArea());
    }
}
