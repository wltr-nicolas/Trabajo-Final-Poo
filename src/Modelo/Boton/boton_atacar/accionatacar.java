public class accionatacar implements Accion {
    public void ejecutar() {
        System.out.println("Atacar");
        CalcularDano calcularDano = new CalcularDano();
        calcularDano.calcular();
    }
}
