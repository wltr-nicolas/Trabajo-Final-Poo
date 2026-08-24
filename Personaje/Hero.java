
//import java.util.ArrayList;




public class Hero extends Personaje {

    
    //private ArrayList<Item> items;

    public Hero(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura) {

        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);
    }

    //  MÉTODOS ABSTRACTOS OBLIGATORIOS O NO FUNCIONA

    @Override
    public void realizarAccionPrincipal() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getNombre() + " realiza su acción principal.");
    }

    @Override
    public void ejecutarAccionAdicional() {
        // Aquí irá la lógica para usar una poción o correr
        System.out.println(getNombre() + " realiza una acción adicional.");
    }

}











    


