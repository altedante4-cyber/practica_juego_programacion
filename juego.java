import java.util.Scanner;
import java.util.Random;

public class JuegoAhorcado {
    // Variables globales
    static String palabras[] = {"pirlo", "cafes", "messi", "clavo", "tigre", "piano", "libro", "radio", "playa", "perro", "goles", "atomo", "nieve"};
    static int contador = 0; 
    static Scanner sc = new Scanner(System.in);
    static Random leter = new Random();
    
    // Marcadores de victoria
    static int victoriasJugador = 0;
    static int victoriasOrdenador = 0;

    static String usuario;
    static String palabra_jugar;

    public static void main(String[] args) {
        // DECLARACIÓN ÚNICA DE OPCIÓN (Para evitar el error de scope y duplicación)
        char opcion; 

        do {
            System.out.println("\n--- MARCADOR ---");
            System.out.println("Jugador: " + victoriasJugador + " | Ordenador: " + victoriasOrdenador);
            System.out.println();
            System.out.println("¿Quieres jugar una partida? (n = jugar / s = salir): ");
            
            // Leemos la opción y evitamos errores si el usuario solo pulsa Enter
            String entrada = sc.nextLine().toLowerCase();
            if (entrada.isEmpty()) {
                opcion = ' '; 
            } else {
                opcion = entrada.charAt(0);
            }

            if (opcion == 'n') {
                // palabra aleatoria 
                int elegir_palabra = leter.nextInt(palabras.length);
                palabra_jugar = generaPalabra(palabras, elegir_palabra);
                
                contador = 0; 
                boolean adivinado = false;

                while (contador < 6) {
                    System.out.println("\nIntento " + (contador + 1) + " de 6");
                    System.out.print("Introduce tu palabra de 5 letras: ");
                    usuario = sc.nextLine().toLowerCase();

                    // Validación de longitud
                    if (usuario.length() != 5) {
                        System.out.println("Error: La palabra debe tener exactamente 5 letras.");
                        continue;
                    }

                    // Comprobamos el resultado
                    char[] resultadoVisual = compruebaLetrasAcertadas(usuario);
                    
                    System.out.print("Resultado: ");
                    for (char c : resultadoVisual) {
                        System.out.print(c + " ");
                    }
                    System.out.println();

                    // ¿Ha ganado?
                    if (haGanadoJugador(usuario)) {
                        System.out.println("Has ganado");
                        victoriasJugador++;
                        adivinado = true;
                        break; 
                    }

                    contador++;
                }

                if (!adivinado) {
                    System.out.println("\nHas perdido. La palabra era: " + palabra_jugar.toUpperCase());
                    victoriasOrdenador++;
                }
            }

        } while (opcion != 's');

        System.out.println("Juego finalizado. ¡Hasta pronto!");
    }

    // Mira si el usuario acertó la palabra completa
    public static boolean haGanadoJugador(String user) {
        return user.equals(palabra_jugar);
    }

    // Lógica de pistas: MAYÚSCULA (posición OK), minúscula (existe pero sitio mal), * (no existe)
    public static char[] compruebaLetrasAcertadas(String user) {
        char resultado[] = new char[5];

        for (int i = 0; i < 5; i++) {
            char letraUser = user.charAt(i);
            char letraSecreta = palabra_jugar.charAt(i);

            if (letraUser == letraSecreta) {
                // Acierto total: Convertimos a mayúscula usando ASCII o Character.toUpperCase
                resultado[i] = Character.toUpperCase(letraUser);
            } else {
                // Comprobamos si la letra existe en cualquier otra parte de la palabra
                boolean existe = false;
                for (int j = 0; j < 5; j++) {
                    if (letraUser == palabra_jugar.charAt(j)) {
                        existe = true;
                        break;
                    }
                }
                
                if (existe) {
                    resultado[i] = letraUser; // Se queda en minúscula
                } else {
                    resultado[i] = '*'; // No existe
                }
            }
        }
        return resultado;
    }

    public static String generaPalabra(String a[], int indice) {
        return a[indice];
    }
}
