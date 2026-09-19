public class accionatacar implements Accion {
    public void ejecutar() {

        CalcularDano calcularDano = new CalcularDano();
        calcularDano.calcular();
    }
}
