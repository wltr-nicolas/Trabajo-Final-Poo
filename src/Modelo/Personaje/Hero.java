package Modelo.Personaje;
import Modelo.Arma;
import Modelo.Dado;


public class Hero extends Personaje {

    private Arma armaEquipada; // por ahora no es un item es por defecto por lo que usare una clase -Arma-
    //el Hero usa por defecto una Arma tipo espada (por ahora fija)
    private static final int BONUS_ARMADURA_POCION = 5; //es constante porque solo hay una pocion de armadura
    private static final int DURACION_ARMADURA = 3; //la duracion de la pocion de armadura
    //private int experiencia; // se define su uso más adelante


    public Hero(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura) { //constructor del hero

        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);
        
        // se crea el objeto Arma en memoria
        this.armaEquipada = new Arma("espada basica", "espada de hierro comun", 0, 6); // esta es la forma de crear algo y instanciarlo para algo

    }

        public Arma getArmaEquipada() { return armaEquipada; }

        public void equiparArma(Arma nuevaArma) {
        this.armaEquipada = nuevaArma;
    }


    //  MÉTODOS ABSTRACTOS OBLIGATORIOS O NO FUNCIONA

    @Override
    public void realizarAccionAtacar() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getNombre() + " realiza su acción principal.");
    }

    public void usarPocionArmadura (){
        aplicarBonusArmadura(BONUS_ARMADURA_POCION, DURACION_ARMADURA);
        System.out.println(getNombre()+ " usa pocion de armadura (+" + BONUS_ARMADURA_POCION + "por" + DURACION_ARMADURA + " turnos).");
    } //llamado por gestorBatalla cuando se usa pocion de armadura

    public void usarPocionVida (Dado dadoVida){
        int curacion = dadoVida.lanzar();
        curar (curacion);
        System.out.println(getNombre() + " usa pocion de vida y recupera " + curacion + " puntos.");
    } //llamado por gestorBatalla cuando se usa pocion de vida

    /*@Override
    public void realizarAccionDefender() {
        // Aquí irá la lógica cuando el jugador elige atacar, hablar o huir desde la IGU
        System.out.println(getArmadura() + " realiza su acción principal.");
    }
        Se saca porque no hay dado para verificar si conecta el golpe*/

    public void ejecutarAccionAdicional() {
        System.out.println(getNombre() + " realiza una acción adicional.");
    }
}

/* Esta clase es la implementación concreta del héroe o jugador principal (Hero.java) dentro de la 
capa de Modelo. Hereda directamente de la clase abstracta Personaje.
¿Qué hace exactamente?
    _Representa al personaje controlado por el jugador: Define las capacidades específicas del 
    héroe, como equipar armas y reaccionar a los comandos de combate o navegación.
Maneja el equipamiento (Arma):
    _Define un atributo privado armaEquipada para saber qué arma tiene en uso.
    _En el constructor, cuando creás al héroe, le asigna automáticamente una "espada basica" 
    por defecto.
    _Proporciona los métodos getArmaEquipada() para consultar el arma actual y 
    equiparArma(Arma nuevaArma) para cambiarla más adelante en el juego 
    (por ejemplo, al comprar una nueva en la tienda).
Cumple con los contratos abstractos de Personaje (@Override): 
Escribe la lógica concreta para los tres métodos obligatorios que heredó de la clase base:
        - realizarAccionAtacar(): Define cómo actúa el héroe cuando ataca.
        - realizarAccionDefender(): Define cómo actúa el héroe cuando se defiende.
        - ejecutarAccionAdicional(): Define una acción extra, como usar un item o huir. */