package Modelo.Personaje;
import Modelo.Item;

public class Ogro extends Enemigo {

    public void setDrop(Item drop) {
        this.drop = drop;
    }

    public Ogro(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura){
        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);

        setDrop(new Item("cabeza de Ogro", "Trofeo obtenido al derrotar un Ogro", 100));
    }

        //  MÉTODOS ABSTRACTOS OBLIGATORIOS O NO FUNCIONA

    @Override
    public Item generarDrop() {
        // Aquí irá la lógica cuando el enemigo deja caer un drop (item)
        System.out.println(getDrop() + " deja caer un item(drop)");
        return (Item) getDrop();
    }
    

    @Override
    public void realizarAccionAtacar() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getDanio() + " realiza su acción atacar.");
    }

    @Override
    public void realizarAccionDefender() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getArmadura() + " realiza su acción armadura.");
    }

    @Override   //utilisa un item o corre
    public void ejecutarAccionAdicional() {
        // Aquí irá la lógica para usar una poción o correr
        System.out.println(getNombre() + " realiza una acción adicional.");
    }
}

    /*  Esta clase es una subclase concreta (Ogro.java) que representa a uno de los oponentes 
    del juego dentro de la capa de Modelo. Hereda de Enemigo (que a su vez hereda de Personaje), 
    completando la jerarquía de herencia.
    
¿Qué hace exactamente?¿Qué hace exactamente?
    _Define la entidad del Ogro: Inicializa sus atributos básicos pasándoselos a la clase 
    padre mediante super(...) y le asigna un objeto único como recompensa al ser derrotado 
    ("cabeza de Ogro" valorada en 100 de oro).
Cumple con los contratos abstractos (@Override): Implementa obligatoriamente la lógica específica 
para el Ogro de los métodos heredados de Personaje y Enemigo:
        - generarDrop(): Define qué item deja caer al ser derrotado.
        - realizarAccionAtacar(): Define cómo actúa cuando ataca.
        - realizarAccionDefender(): Define cómo actúa cuando se defiende.
        - ejecutarAccionAdicional(): Define una acción extra, como usar un item o huir.
    */