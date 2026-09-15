package Modelo.Escenario;

/**
 * En términos simples, EvaluadorEncuentro es un contrato que define las reglas 
para saber si el jugador se cruza con un enemigo o evento según 
sus coordenadas $(x, y)$ en el mapa.
No contiene código ejecutable ni lógica directa: Solo declara un
método llamado hayEncuentro(int x, int y).
Devuelve un valor booleano: Retorna true (si debe iniciar un combate/evento)
o false (si la casilla está despejada).
Delega la responsabilidad: Le dice a cualquier clase que la 
implemente: "No me importa cómo calcules la probabilidad (sea tirando un dado, usando
 un temporizador o verificando un mapa de calor), solo decime si en estas
  coordenadas $(x, y)$ hay un encuentro". *
 */
public interface EvaluadorEncuentro {
    boolean hayEncuentro(int x, int y);
}

/* ¿Qué es EvaluadorEncuentro y qué hace?
En términos simples, EvaluadorEncuentro es un contrato que define las reglas 
para saber si el jugador se cruza con un enemigo o evento según 
sus coordenadas $(x, y)$ en el mapa.
No contiene código ejecutable ni lógica directa: Solo declara un
método llamado hayEncuentro(int x, int y).
Devuelve un valor booleano: Retorna true (si debe iniciar un combate/evento)
o false (si la casilla está despejada).
Delega la responsabilidad: Le dice a cualquier clase que la 
implemente: "No me importa cómo calcules la probabilidad (sea tirando un dado, usando
 un temporizador o verificando un mapa de calor), solo decime si en estas
  coordenadas $(x, y)$ hay un encuentro". */