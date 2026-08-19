public class Hero extends Personaje {
    
    private ArrayList invetario; /*es una lista de objetos (escopeta, pistola, cuchillo) para tener varios de 
    armas diferentes */
    

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
