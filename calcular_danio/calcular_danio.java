public class calcular_danio extends Personaje{
    @Override
    public int calculaDanio(){
        int reduccionArmadura = armadura / 2;
        int danioFinal = Math.max(dani - reduccionArmadura, 1);
        return danioFinal;
    }

}