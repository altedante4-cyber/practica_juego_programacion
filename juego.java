package UD5;
import java.util.Scanner;
import java.util.Random;

public class PruebasAhorcado {
    static String palabras[] = {"pirlo", "cafes", "messi", "clavo", "tigre", "piano", "libro", "radio", "playa", "perro", "goles", "atomo", "nieve"};
    static int contador = 0; 
    static Scanner sc = new Scanner(System.in);
    static Random leter = new Random();
    
    static int victoriasJugador = 0;
    static int victoriasOrdenador = 0;

    static String usuario;
    static String palabra_jugar;

    public static void main(String[] args) {
        char opcion = ' '; 

        do {
            System.out.println("\n--- MARCADOR ---");
            System.out.println("Jugador: " + victoriasJugador + " | Ordenador: " + victoriasOrdenador);
            System.out.println();
            System.out.println("¿Quieres jugar una partida? (n = jugar / s = salir): ");
            
            String entrada = sc.nextLine().toLowerCase();
            
            if (entrada.length() > 0) {
                opcion = entrada.charAt(0);
            } else {
                opcion = ' '; 
            }

            if (opcion == 'n') {
                int elegir_palabra = leter.nextInt(palabras.length);
                palabra_jugar = generaPalabra(palabras, elegir_palabra);
                
                contador = 0; 
                boolean adivinado = false;

                while (contador < 6) {
                    System.out.println("\nIntento " + (contador + 1) + " de 6");
                    System.out.print("Introduce tu palabra de 5 letras: ");
                    usuario = sc.nextLine().toLowerCase();

                    if (usuario.length() == 5) {
                        char[] resultadoVisual = compruebaLetrasAcertadas(usuario);
                        
                        System.out.print("Resultado: ");
                        for (int i = 0; i < resultadoVisual.length; i++) {
                            System.out.print(resultadoVisual[i] + " ");
                        }
                        System.out.println();

                        if (haGanadoJugador(usuario)) {
                            System.out.println("Has ganado");
                            victoriasJugador++;
                            adivinado = true;
                            contador = 6; 
                        } else {
                            contador++; 
                        }
                    } else {
                        System.out.println("Error: La palabra debe tener exactamente 5 letras.");
                     
                    }
                }

                if (adivinado == false) {
                    System.out.println("\nHas perdido. La palabra era: " + palabra_jugar.toUpperCase());
                    victoriasOrdenador++;
                }
            }

        } while (opcion != 's');

        System.out.println("Juego finalizado. ¡Hasta pronto!");
    }

    public static boolean haGanadoJugador(String user) {
        return user.equals(palabra_jugar);
    }

    public static char[] compruebaLetrasAcertadas(String user) {
        char resultado[] = new char[5];
        for (int i = 0; i < 5; i++) {
            char letraUser = user.charAt(i);
            char letraSecreta = palabra_jugar.charAt(i);

            if (letraUser == letraSecreta) {
                resultado[i] = Character.toUpperCase(letraUser);
            } else {
                boolean existe = false;
                for (int j = 0; j < 5; j++) {
                    if (letraUser == palabra_jugar.charAt(j)) {
                        existe = true;
                    }
                }
                
                if (existe) {
                    resultado[i] = letraUser; 
                } else {
                    resultado[i] = '*'; 
                }
            }
        }
        return resultado;
    }

    public static String generaPalabra(String a[], int indice) {
        return a[indice];
    }
}
