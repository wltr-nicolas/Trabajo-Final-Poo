package Modelo;

import java.util.Random;

public class Dado {
    private int caras;
    private int valor;

    private Random random = new Random();

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

/* Este archivo es la clase utility o de apoyo (Dado.java) dentro de tu paquete modelo. 
Simula el comportamiento de un dado de rol tradicional (como un dado de 6 caras, de 10 caras, 
de 20 caras, etc.) utilizando el generador de números aleatorios de Java. 
¿Qué hace exactamente?
Atributos y Configuración (caras y valor):
   _caras: Define de cuántas caras es el dado. Se configura al instanciar la clase a través del 
   constructor public Dado(int caras). Por ejemplo, new Dado(6) crea un dado de 6 caras ($d6$), 
   mientras que new Dado(20) crea un dado de 20 caras ($d20$).
   _valor: Almacena el último resultado obtenido al tirar el dado.
   
*/