package Modelo.Escenario;

/*  ¿Qué es TipoEscenario?
TipoEscenario es un enum (Enumeración). En Java, un enum es un tipo de dato especial que sirve para definir un 
conjunto de constantes fijas e inalterables, se usa para representar de forma limpia los biomas disponibles sin tener que usar 
cadenas de texto libres (Strings como "bosque" o "Bosque"), lo cual evita errores de tipeo.  */
public class EscenarioFactory {
    public static Escenario crearEscenario(TipoEscenario tipo) {
        switch (tipo) {
            case CARRETA:
                return new EscenarioCarreta("Camino Real - Asalto a la Carreta", "Un camino empedrado, se rompe tu carreta tratas de repararla y en ese momento fuiste emboscado por una banda de ladrones.", 50, 50);
            case BOSQUE:
                return new EscenarioBosque("Bosque de las Sombras", "Un frondoso bosque habitado por animales salvajes y criaturas místicas.", 50, 0);
            case CALABOZO:
                return new EscenarioCalabozo("Calabozo Subterráneo", "Una húmeda y oscura mazmorra plagada de trampa y antiguos guardianes.", 50, 0);
            case PANTANO:
                return new EscenarioPantano("Pantano de los Lamentos", "Un pantano denso y tóxico, habitado por criaturas peligrosas y serpenteante.", 50, 0 );
            default:
                throw new IllegalArgumentException("Tipo de escenario no válido: " + tipo);
        }
    }
}

/* ¿Qué es y qué hace?
En términos sencillos, EscenarioFactory funciona como una fábrica centralizada de escenarios. 
En lugar de instanciar cada bioma directamente en tu código escribiendo new EscenarioBosque() o new EscenarioCalabozo(), 
le delegás esa responsabilidad a esta clase pasándole simplemente una opción de tipo (CARRETA, BOSQUE, CALABOZO o PANTANO). */