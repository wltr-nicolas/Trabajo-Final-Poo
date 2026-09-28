package Vista;

public class ElementoBandido extends ElementoEscenario {

    private int velocidad;

    public ElementoBandido(String rutaImagen, int x, int y, int velocidad) {
        super(rutaImagen, x, y);
        if (velocidad <= 0) {
            throw new IllegalArgumentException("La velocidad debe ser mayor a 0.");
        }
        this.velocidad = velocidad;
    }

    @Override
    public void actualizar(int xHero, int yHero) {
        if (this.x < xHero) {
            this.x += velocidad;
        } else if (this.x > xHero) {
            this.x -= velocidad;
        }

        if (this.y < yHero) {

            this.y += velocidad;
        } else if (this.y < yHero) {
            this.y -= velocidad;
        }
    }

    public int getVelocidad() {
        return velocidad;
    }
}
