
//import java.util.ArrayList;




public class Hero extends Personaje {

    private Arma armaEquipada; // por ahora no es un item es por defecto por lo que usare una clase -Arma-
    //el Hero usa por defecto una Arma tipo espada (por ahora fija)
      
    //private int experiencia; // se define su uso más adelante


    public Hero(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura) { //constructor del hero

        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);
        
        // se crea el objeto Arma en memoria
        this.armaEquipada = new Arma("espada", 6); // esta es la forma de crear algo y instanciarlo para algo

    }

        public Arma getArmaEquipada() { return armaEquipada; }


    //  MÉTODOS ABSTRACTOS OBLIGATORIOS O NO FUNCIONA

    @Override
    public void realizarAccionAtacar() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getNombre() + " realiza su acción principal.");
    }

    @Override
    public void realizarAccionDefender() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getArmadura() + " realiza su acción principal.");
    }

    @Override
    public void ejecutarAccionAdicional() {
        // Aquí irá la lógica para usar una poción o correr
        System.out.println(getNombre() + " realiza una acción adicional.");
    }



}











    


