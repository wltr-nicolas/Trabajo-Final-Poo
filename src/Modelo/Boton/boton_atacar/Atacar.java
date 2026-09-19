public class accionatacar implements Accion {
    public void ejecutar() {

        CalcularDanio calcularDano = new CalcularDanio();
        calcularDanio.calcular();
    }
}
