package solid_exercicios4;

public class FuncionarioApp {

    public static void main(String[] args) {

        Programador desenvolvedor = new Desenvolvedor();

        desenvolvedor.programar();


        AtendenteDeCliente atendente = new Atendente();
        atendente.atenderCliente();
    }
}
