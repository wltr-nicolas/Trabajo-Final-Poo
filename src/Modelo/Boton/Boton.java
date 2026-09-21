/*public class Boton {
    private String texto;  // Este es lo que se ve en el botón
    private String color;
    private Accion accion;

    private Boton(Builder builder ){
        this.texto = builder.texto;
        this.color = builder.color;
        this.accion = builder.accion;
    }
    public void mostrar() {
        System.out.println("[" + texto + "]");  // Muestra el botón con su texto
    }
    
    public void click() {
        mostrar();  // Muestra el botón
        if (accion != null) {
            accion.ejecutar();  // Ejecuta la acción
        }
    }
    public static class Builder{
        private String texto;
        private String color ="default";  // Valor por defecto
        private Accion accion;

        public Builder(String texto) {
            this.texto = texto;
        }

        public Builder setcolor(String color) {
            this.color = color;
            return this;
        }

        public Builder setaccion(Accion accion) {
            this.accion = accion;
            return this;
        }

        public Boton build() {
            return new Boton(this);
        }
    }
} */