public class Personaje {


    protected Integer velocidad;
    protected Integer vida;
    protected Integer danio;
    protected Integer tamanio;
    protected Integer x;
    protected Integer y;

    public void moverDerecha() {
        x += velocidad;
    }

    public void moverIzquierda(){

        x -= velocidad;
 }


    public void moverArriba() {

    y += velocidad;
 
 }

    public void moverAbajo() {

    y -= velocidad;
 
 }

}
