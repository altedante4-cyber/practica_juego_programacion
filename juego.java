
import java.util.Scanner ;
import java.util.Random;

public class juego {
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
		
	Random leter = new Random();
	
		char opcion ;
		String palabras [] = {"pirlo","cafes","messi"};
		
		do {
			System.out.println("Ingrese la opcion salir(s/n) ");
			opcion = sc.nextLine().charAt(0);
			String usuario = ""; // palabras que el usuario va introducir para encontrar la palabra
			int contador = 0 ; 
			
			int elegir_palabra = leter.nextInt(palabras.length);
			
			String palabra_jugar = palabras[elegir_palabra]; // guardamos la palabra aleatoria elegida para jugar la partida y es la que tiene que adivinar el usuario 
			
			// guardamos la palabra en un array tipo char  para ir comparando posiciones 

			char palabra_jugar_array [] = new char [palabra_jugar.length()];

			for (int i = 0 ; i < palabra_jugar.length() ;i++ ){

				char a = palabra_jugar.charAt(i);

				palabra_jugar_array[i]+= a ;
			}


			// partidas que le quedan al jugador por jugar 
			while (contador < 6 ) {
				
				System.out.println("Ingrese la letra ");
				usuario = sc.nextLine();

			
				//guardar lo que introduce el usuario en un array tipo char para poder verificar la posicion de cada caracter

				char palabra_usuario [] = new char [5];
				for (int i = 0 ; i < usuario.length() ; i++ ){
					 
					  char a = usuario.charAt(i);

					  palabra_usuario[i] += a; 
					  
				}


                  // guardamos en este array la palabra que tenemos que encontrar 

				char buscar [] = new char[palabra_jugar.length()];

				for (int i = 0 ; i < palabra_jugar.length() ; i ++ ) {
						
						char a = palabra_jugar.charAt(i);

						// colocamos tantos asteriscos como tenga la palabra que estamos jugando 
						
						buscar[i] += a;
	
						
				}				

				boolean palabra_encontra_posicion_incorrecta = false ;
				
				
				
				// este bucle nos sirve para ir comparando las letras que tiene o no tiene la palabra introducida por el usuario 
				for (int i = 0 ; i < palabra_usuario.length ; i++ ){
					
					//lo que hago aqui es ir comparando el array buscar que contiene la palabra en tipo caracter y si es igual ala palabra introducida por el usuario
					// que lo tenemos en un array tipo caracter pone astericos si coincide 

					if(buscar[i] == palabra_usuario[i]){
							//preguntar como convertir a mayuscula los tipos char 
							palabra_usuario[i] = palabra_usuario[i];
					}else{

						palabra_usuario[i]= '*';

					}
					
					System.out.print(palabra_usuario[i]);
					  
				}
				
		
				contador ++; 
			}
			
			
		}while(opcion != 'n');
		
	
	}

}
