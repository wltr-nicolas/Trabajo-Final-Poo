package Modelo.Personaje;

import Modelo.Item;
import Modelo.ResultadoDrop;

public abstract class Enemigo extends Personaje {

    protected Item drop; // el ítem que este enemigo suelta al morir

    public Enemigo(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura) {
        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);

    }

    public abstract ResultadoDrop generarDrop();
    // GETTERS Y SETTERS (necesarios por el encapsulamiento)
    public Item getDrop() {
        return drop;
    }
}

/* Este archivo es la clase abstracta intermedia (Enemigo.java) de tu capa de Modelo. 
Se ubica en el medio de la jerarquía de herencia: hereda de Personaje y sirve como la clase 
madre para todos los oponentes del juego (Ogro, Bandido, Lobo, etc.). 

¿Qué hace exactamente?
   _Agrega la mecánica de botín / recompensas (drop): Introduce el atributo privado drop de tipo 
   Item, el cual representa el objeto que el enemigo dejará caer al ser derrotado.
   _Define un contrato exclusivo para los enemigos (public abstract Item generarDrop()): Obliga a 
   cada clase de enemigo concreta (como Ogro o Bandido) a programar su propia versión de qué 
   ítem suelta y con qué lógica al morir.
   _Propaga el constructor hacia la clase base (super(...)): Toma los datos necesarios (
   nombre, vida, tamaño, coordenadas, daño, armadura) y se los envía a la clase madre Personaje 
   para que inicialice los atributos comunes.
   _Aplica Encapsulamiento: Oculta la variable drop declarándola como private y expone el método 
   público getDrop() para acceder a ella de forma segura.
*/