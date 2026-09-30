package Modelo.Boton;

public class Boton {
    private String texto;
    private String color;
    private Accion accion;

    private Boton(Builder builder){
        this.texto = builder.texto;
        this.color = builder.color;
        this.accion = builder.accion;
    }
    public void mostrar() {
        System.out.println("[" + texto + "]");
    }
    public void click() {
        mostrar();
        if (accion != null) {
            accion.ejecutar();
        }
    }
    public static class Builder{
        private String texto;
        private String color = "default";
        private Accion accion;

        public Builder(String texto) {
            this.texto = texto;
        }
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }
        public Builder setAccion(Accion accion) {
            this.accion = accion;
            return this;
        }
        public Boton build() {
            return new Boton(this);
        }
    }
}