package Modelo.Personaje;
import java.util.ArrayList;
import Modelo.Item;

public abstract class Personaje {
    
    /*Nivel de visibilidad (protected vs. private)
El problema/riesgo: Poner los atributos en protected permite que cualquier clase hija (y cualquier clase dentro del mismo paquete)
modifique los valores directamente sin pasar por validaciones.
Solución: Aplicar encapsulamiento estricto definiendo los atributos como private y dando acceso a los hijos mediante métodos
 Getters y Setters o métodos de lógica (ejemplo: recibirDano()). */

    private String nombre; 
    private int vidaMaxima;
    private int vidaActual;
    private int tamanio;
    private int x;
    private int y;
    private int danio;
    private int armaduraTemporal = 0;
    private int turnosArmadura = 0;
    private int armadura;
    private ArrayList <Item> items;


    
    public Personaje(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura ) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.tamanio = tamanio;
        this.x = x;
        this.y = y;
        this.danio = danio;
        this.armadura = armadura;
        this.items = new ArrayList<>();

    }
    
    /*public void recibirDanio(int cantidad) {
        this.vidaActual -= cantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    } se reemplaza con el metodo de abajo*/
     public void recibirDanio (int cantidad) {
        int danioReal = cantidad - getArmaduraTotal(); //se agrega la armadura al calculo del danio
        if (danioReal < 0 ){
            danioReal = 0; //se evita que la armadura cure de rebote
        }
        this.vidaActual -= danioReal;
        if (this.vidaActual < 0){
            this.vidaActual = 0;
        }
     }//con este metodo podemos calcular el danio teniendo en cuenta la armadura

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

// MÉTODOS ABSTRACTOS:  para Hero y Enemigo
    public abstract void realizarAccionAtacar();
    //public abstract void realizarAccionDefender(); se saca porque no hay dado de defensa
    //public abstract void ejecutarAccionAdicional(); pasa a ser solo de hero, no de todos
    public void curar (int cantidad) {
        this.vidaActual += cantidad;
        if (this.vidaActual > this.vidaMaxima){
            this.vidaActual = this.vidaMaxima; //no se supera la vida maxima al curarse
        }
    }

    public void aplicarBonusArmadura (int cantidad, int turnos){ 
        this.armaduraTemporal= cantidad;
        this.turnosArmadura= turnos;
    } //se activa al usarse pocion de armdaura

    public int getArmaduraTotal (){
        return this.armadura + this.armaduraTemporal;
    } //armadura base + el buff de la pocion

    public void actualizarEfectosTemporales (){
        if (turnosArmadura > 0){
            turnosArmadura--;
            if (turnosArmadura == 0){
                armaduraTemporal = 0;
            }
        }
    }//el gestorBatalla lo usa una vez por turno, para todos



    // GETTERS Y SETTERS (necesarios por el encapsulamiento)
    public String getNombre() { return nombre; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getVidaActual() { return vidaActual; }
    public int getDanio() { return danio; }
    public int getArmadura() { return armadura; }
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public ArrayList<Item> getItems() { return items; }
    
}


/* Esta es la clase abstracta base (Personaje.java) de tu capa de Modelo. 
Funciona como la plantilla general de la que van a heredar tanto el jugador (Hero) como 
todas sus variantes de oponentes (Enemigo, Bandido, Lobo, Ogro). 
¿Qué hace exactamente?
  _Modela las características comunes: Almacena los atributos compartidos por cualquier entidad 
  del juego, como nombre, vida (máxima y actual), armadura, ataque, ubicación en el mapa (x, y) 
  y su inventario de objetos (ArrayList<Item>).
  _Aplica Encapsulamiento Estricto: Define sus atributos como private y obliga a las subclases 
  o controladores a modificarlos mediante getters, setters o métodos con lógica (recibirDanio()).
Gestiona el estado de salud y los ítems:
  _Controla la vida del personaje: Permite recibir daño y verificar si el personaje sigue vivo.
  _estaVivo(): Comprueba si la entidad sigue con vida (vidaActual > 0).
  _Maneja el inventario: Permite agregar ítems al inventario del personaje.
  _Establece el contrato de acciones obligatorias: Al definir métodos abstractos 
  (public abstract void...), exige que cualquier subclase concreta escriba obligatoriamente 
  su propia forma de atacar, defenderse y ejecutar una acción especial.
*/
