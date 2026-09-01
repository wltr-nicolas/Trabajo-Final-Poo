public class Bandido extends Enemigo {

    public Bandido(String nombre, int vidaMaxima, int tamanio, int x, int y, int danio, int armadura){
        super(nombre, vidaMaxima, tamanio, x, y, danio, armadura);

        this.drop = new Item ("Oro");
        

    }

        //  MÉTODOS ABSTRACTOS OBLIGATORIOS O NO FUNCIONA

    @Override
    public Item generarDrop() {
        // Aquí irá la lógica cuando el enemigo deja caer un drop (item)
        System.out.println(getDrop() + " deja caer un item(drop)");
        return getDrop();
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