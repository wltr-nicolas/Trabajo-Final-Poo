import java.util.Random;

public class Dado {
    private int caras;
    private int valor;

    Random random = new Random();

    public Dado(int caras) {
        this.caras = caras;
    }
    public int lanzar() {
        this.valor = random.nextInt(caras) + 1; // Entre 1 y caras
        return this.valor;
    }
    public int getValor() {
        return valor;
    }
}
