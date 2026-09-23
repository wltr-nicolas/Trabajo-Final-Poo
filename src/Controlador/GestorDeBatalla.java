package Controlador;

import Modelo.Personaje.Hero;
import Modelo.Personaje.Enemigo;
import Modelo.Dado;
import Modelo.ResultadoDrop;

public class GestorDeBatalla {

    private Hero hero;
    private Enemigo enemigo;
    private boolean combateTerminado;
    private boolean accionPrincipalUsada;
    private boolean accionAdicionalUsada;

    public GestorDeBatalla(Hero hero, Enemigo enemigo) {
        this.hero = hero;
        this.enemigo = enemigo;
        this.combateTerminado = false;
    }

    public void turnoJugadorAtacar() {
        if (combateTerminado || accionPrincipalUsada) {
            System.out.println("Ya usaste tu acción principal este turno.");
            return;
        }
        accionPrincipalUsada = true;

        int danioCalculado = hero.getDanio();
        enemigo.recibirDanio(danioCalculado);
        hero.realizarAccionAtacar();

        verificarFinDeCombate();
    }

    public void turnoJugadorUsarPocionVida(Dado dadoVida) {
        if (combateTerminado || accionAdicionalUsada) {
            System.out.println("Ya usaste tu acción adicional este turno.");
            return;
        }
        accionAdicionalUsada = true;
        hero.usarPocionVida(dadoVida);
    }

    public void turnoJugadorUsarPocionArmadura() {
        if (combateTerminado || accionAdicionalUsada) {
            System.out.println("Ya usaste tu acción adicional este turno.");
            return;
        }
        accionAdicionalUsada = true;
        hero.usarPocionArmadura();
    }

    public void finalizarTurno() {
        if (combateTerminado) return;

        int danioCalculado = enemigo.getDanio();
        hero.recibirDanio(danioCalculado);
        enemigo.realizarAccionAtacar();

        verificarFinDeCombate();

        if (!combateTerminado) {
            hero.actualizarEfectosTemporales();
            enemigo.actualizarEfectosTemporales();
            accionPrincipalUsada = false;
            accionAdicionalUsada = false;
        }
    }

    private void verificarFinDeCombate() {
        if (!enemigo.estaVivo()) {
            combateTerminado = true;
            ResultadoDrop loot = enemigo.generarDrop();
            System.out.println("¡" + enemigo.getNombre() + " fue derrotado!");
            System.out.println("Botín obtenido: " + loot);
        } else if (!hero.estaVivo()) {
            combateTerminado = true;
            System.out.println("¡" + hero.getNombre() + " ha muerto!");
        }
    }

    public boolean isCombateTerminado() {
        return combateTerminado;
    }
}