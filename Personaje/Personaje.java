public class Personaje {

    protected Integer vidaMaxima;
    protected Integer vidaActual;
    protected Integer tamanio;
    protected Integer x;
    protected Integer y;
    protected Integer danio;
    protected Integer armadura;

    public Personaje(Integer vidaMaxima, Integer vidaActual, Integer tamanio, Integer x, Integer y, Integer danio, Integer armadura) {
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaActual;
        this.tamanio = tamanio;
        this.x = x;
        this.y = y;
        this.danio = danio;
        this.armadura = armadura;
    }

    public void recibirDano(int cantidad) {
        this.vidaActual -= cantidad;
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public boolean estaVivo() {
        return this.vidaActual > 0;
    }

    // Getters y setters
    public Integer getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(Integer vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public Integer getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(Integer vidaActual) {
        this.vidaActual = vidaActual;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDanio() {
        return danio;
    }

    public void setDanio(Integer danio) {
        this.danio = danio;
    }

    public Integer getArmadura() {
        return armadura;
    }

    public void setArmadura(Integer armadura) {
        this.armadura = armadura;
    }
}


