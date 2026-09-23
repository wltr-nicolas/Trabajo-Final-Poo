package Modelo.Personaje;

import Modelo.Item;
import Modelo.Dado;
import Modelo.ResultadoDrop;

public class Bandido extends Enemigo {

    private static final double PROBABILIDAD_POCION = 0.30; //probabilidad de dropear pociones

    public Bandido(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura) {
        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);
    }

    @Override
    public ResultadoDrop generarDrop() {
        ResultadoDrop resultado = new ResultadoDrop();

        Dado dadoOro = new Dado(20);
        resultado.agregarOro(dadoOro.lanzar());

        Dado dadoProbabilidad = new Dado(100);
        if (dadoProbabilidad.lanzar() <= PROBABILIDAD_POCION * 100) {
            resultado.agregarItem(new Item("Pocion de vida", "Cura al beberla", 15));
        }

        return resultado;
    }

    @Override
    public void realizarAccionAtacar() {
        System.out.println(getNombre() + " realiza su acción atacar, te pega : " + getDanio() + " de daño.");
    }
}
    /*@Override
    public void realizarAccionDefender() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getArmadura() + " realiza su acción armadura.");
    }
        se saca porque todos los golpes conectan siempre */

    /*@Override   //utilisa un item o corre
    public void ejecutarAccionAdicional() {
        // Aquí irá la lógica para usar una poción o correr
        System.out.println(getNombre() + " realiza una acción adicional.");
    }
        se saca porque los enemigos no tienen acciones adicionales*/


    /*  Esta clase es una subclase concreta (Bandido.java) que representa a uno de los oponentes 
    del juego dentro de la capa de Modelo. Hereda de Enemigo (que a su vez hereda de Personaje), 
    completando la jerarquía de herencia.
    
¿Qué hace exactamente?¿Qué hace exactamente?
    _Define la entidad del Bandido: Inicializa sus atributos básicos pasándoselos a la clase 
    padre mediante super(...) y le asigna un objeto único como recompensa al ser derrotado 
    ("cabeza de Bandido" valorada en 20 de oro).
Cumple con los contratos abstractos (@Override): Implementa obligatoriamente la lógica específica 
para el Ogro de los métodos heredados de Personaje y Enemigo:
        - generarDrop(): Define qué item deja caer al ser derrotado.
        - realizarAccionAtacar(): Define cómo actúa cuando ataca.
        - realizarAccionDefender(): Define cómo actúa cuando se defiende.
        - ejecutarAccionAdicional(): Define una acción extra, como usar un item o huir. */