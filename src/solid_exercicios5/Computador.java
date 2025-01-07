package solid_exercicios5;

public class Computador {
    private final DispositivoEntrada dispositivoEntrada;

    public Computador(DispositivoEntrada dispositivoEntrada) {
        this.dispositivoEntrada = dispositivoEntrada;
    }


    public void usar() {
        dispositivoEntrada.digitar();
    }
}
