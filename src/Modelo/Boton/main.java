public class main {
    public static void main(String[] args) {
        
        // AQUÍ VA TU CÓDIGO
        Boton fin_dialogo = new Boton.Builder("Finalizar diálogo")
            .setcolor("blue")
            .setaccion(new AccionAceptar())
            .build();
        
        fin_dialogo.click();
    }
}