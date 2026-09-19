package Modelo.Escenario;

public class TransicionMapa {
    
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;
    private int spawnX;
    private int spawnY;
    private TipoEscenario escenarioDestino;

    public TransicionMapa(int xMin, int xMax, int yMin, int yMax, int spawnX, int spawnY, TipoEscenario escenarioDestino) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.escenarioDestino = escenarioDestino;
    }

    public boolean estaEnZonaTransicion(int x, int y) {
        return (x >= xMin && x <= xMax) && (y >= yMin && y <= yMax);
    }

    public TipoEscenario getEscenarioDestino() {
        return escenarioDestino;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}
 