import java.util.Random;
public class Dado {
    protected int caras;
    protected int valor;

    Random random = new Random();
   // int numero = random.nextInt(caras); 

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
