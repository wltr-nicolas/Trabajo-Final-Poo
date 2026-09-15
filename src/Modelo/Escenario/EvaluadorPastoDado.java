package Modelo.Escenario; //walter
import Modelo.Dado;

/* Esta clase es la realización concreta del contrato que definimos 
   previamente en la interfaz EvaluadorEncuentro.
   Mientras que la interfaz solo prometía que existiría una forma de evaluar
   si hay un encuentro, EvaluadorPastoDado le enseña a Java el cómo exacto
   se calcula esa condición. */
public class EvaluadorPastoDado implements EvaluadorEncuentro {
    private Dado dado;
    private int umbral;

    public EvaluadorPastoDado(Dado dado, int umbral) {
        this.dado = dado;
        this.umbral = umbral;
    }

    @Override   //es override???????
    public boolean hayEncuentro(int x, int y) {
        if (esZonaPasto(x, y)) {
            return dado.lanzar() >= umbral;
        }
        return false;
    }

    private boolean esZonaPasto(int x, int y) {
        return (x >= 20 && x <= 40) && (y >= 20 && y <= 40);
    }
}

/* ¿Qué hace EvaluadorPastoDado paso a paso?Guarda la herramienta
   y la regla de probabilidad:Al crearse (en el constructor), recibe un objeto
   Dado y un valor entero llamado umbral (por ejemplo, 4).Ejecuta el método 
   @Override public boolean hayEncuentro(int x, int y):
   
Paso 1: Evalúa si la posición actual ($x, y$) del personaje está sobre la zona del césped 
   llamando al método esZonaPasto(x, y).
Paso 2: Si NO está en el pasto, corta de inmediato devolviendo false (no hay combate).
Paso 3: Si SÍ está en el pasto, ejecuta dado.lanzar() para tirar el dado. Si la tirada
   es mayor o igual al umbral (por ejemplo, un resultado de 4, 5 o 6 en un dado de 6 caras),
   el método devuelve true (¡se activa la batalla!).
   Delimita las coordenadas del mapa (esZonaPasto):
   Es un método privado auxiliar que comprueba si la posición $X$ está entre 20 y 40 Y 
   la posición $Y$ está entre 20 y 40. 
   Define un cuadrado o bloque de hierba alta dentro del mapa. */

