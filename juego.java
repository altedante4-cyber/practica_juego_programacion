
import java.util.Scanner ;
import java.util.Random;

public class juego {
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
		
	Random leter = new Random();
	
		char opcion ;
		String palabras [] = {"ronaldo","messi","chicharito"};
		
		do {
			System.out.println("Ingrese la opcion salir(s/n) ");
			opcion = sc.nextLine().charAt(0);
			String usuario = "";
			int contador = 0 ; 
			
			int elegir_palabra = leter.nextInt(palabras.length);
			
			String palabra_jugar = palabras[elegir_palabra];
			
			
			while (contador < 6 ) {
				
				System.out.println("Ingrese la letra ");
				usuario = sc.nextLine();
				String palabra_buscada = "";
				for (int i = 0 ; i < palabra_jugar.length() ; i ++ ) {
						
						char a = palabra_jugar.charAt(i);
						
						palabra_buscada += "*";
						
						
					
				}
				System.out.println(palabra_buscada);
				
				
				
				
				
				
				contador ++; 
			}
			
			
		}while(opcion != 'n');
		
	
	}

}
