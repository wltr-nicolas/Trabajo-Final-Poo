package Modelo.Escenario;

/*  ¿Qué es TipoEscenario?
TipoEscenario es un enum (Enumeración). En Java, un enum es un tipo de dato especial que sirve para definir un 
conjunto de constantes fijas e inalterables, se usa para representar de forma limpia los biomas disponibles sin tener que usar 
cadenas de texto libres (Strings como "bosque" o "Bosque"), lo cual evita errores de tipeo.  */
public class EscenarioFactory {
    public static Escenario crearEscenario(TipoEscenario tipo) {
        switch (tipo) {
            case CARRETA:
                return new EscenarioCarreta();
            case BOSQUE:
                return new EscenarioBosque();
            case CALABOZO:
                return new EscenarioCalabozo();
            case PANTANO:
                return new EscenarioPantano();
            default:
                throw new IllegalArgumentException("Tipo de escenario no válido: " + tipo);
        }
    }
}

/* ¿Qué es y qué hace?
En términos sencillos, EscenarioFactory funciona como una fábrica centralizada de escenarios. 
En lugar de instanciar cada bioma directamente en tu código escribiendo new EscenarioBosque() o new EscenarioCalabozo(), 
le delegás esa responsabilidad a esta clase pasándole simplemente una opción de tipo (CARRETA, BOSQUE, CALABOZO o PANTANO). */