public class main {
    public static void main(String[] args) {
        
        // AQUÍ VA TU CÓDIGO
        boton fin_dialogo = new boton.builler("Finalizar diálogo")
            .setcolor("blue")
            .setaccion(new Accionaceptar())
            .build();
        
        fin_dialogo.click();
    }
}