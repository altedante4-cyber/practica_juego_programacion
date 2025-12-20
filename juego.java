import java.util.Scanner;
import java.util.Random;

public class juego {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random leter = new Random();
        char opcion;
        String palabras[] = {"pirlo", "cafes", "messi"};
		char[] caracteresEspeciales = {
    				'!', '@', '#', '$', '%', '^', '&', '*',
    				'(', ')', '-', '_', '=', '+',
    				'{', '}', '[', ']', '|',
    				'\\', ':', ';', '"', '\'',
    				'<', '>', ',', '.', '?', '/',
    				'¿', '¡','0','1','2','3','4','5','6','7','8','9'
					};
		char[] consonantes = {
            'b','c','d','f','g','h','j','k','l','m',
            'n','ñ','p','q','r','s','t','v','w','x','y','z'
        };
		char vocales_comprobar [] = {'a','e','i','o','u'};


        do {
            System.out.println("\nIngrese la opcion salir(s/n): ");
            opcion = sc.nextLine().charAt(0);
            
            if (opcion == 'n') {
                // Elegimos palabra aleatoria
                int elegir_palabra = leter.nextInt(palabras.length);
                String palabra_jugar = palabras[elegir_palabra]; //aqui elegimos la palabra a jugar 
                int contador = 0;  // contador para  terminar la partida 

				boolean encontrado_consonantes = false;
				boolean encontrado_palabra_no_admitida = false; //booleano que utilizamos para saber la ultima posicion del string usuario si tiene 'q' , 'x' ,'w' 
				boolean contador_vocales_seguidas = false;
				while (contador < 6 ) {
                    
                    String usuario ;
					int contador_interno = 0 ;
					boolean salir_bucle_errores = false ; 

					boolean no_tiene_vocales = false ; 
					boolean tiene_caracteres_especiales = false ; 

					do{
						
   			 			System.out.println("\nIngrese la palabra (5 letras y 2-3 vocales):");
    					usuario = sc.nextLine().toLowerCase();
					

    
   					 // Reiniciamos las banderas en cada vuelta del do-while
    				int contador_vocales = 0;
    				no_tiene_vocales = false; 

    				if (usuario.length() != 5) {
        	System.out.println("Error: Debe tener exactamente 5 letras.");
        		contador_interno++;
    } else {
			// aqui entramos si solo si tiene 5 letras   
		for (int i = 0; i < usuario.length(); i++) {
            char comprobar_vocal = usuario.charAt(i);
            for (int j = 0; j < vocales_comprobar.length; j++) {
                if (comprobar_vocal == vocales_comprobar[j]) {
                    contador_vocales++;
                }
            }
        }

		

        if (contador_vocales >= 2 && contador_vocales <= 3) {
            no_tiene_vocales = false;  // si tiene entre dos y tres letras
        } else {
    
	
			System.out.println("Error: Debe contener entre 2 y 3 vocales (tiene " + contador_vocales + ")");
            no_tiene_vocales = true; 
            contador_interno++;
        }

		// comprobar si tiene caracteres especiales o si tiene  espacios si tiene devolver un booleano  
			for(int i = 0 ; i < usuario.length() ; i++ ){
			 char c = usuario.charAt(i);

			 for (int k = 0 ; k < caracteresEspeciales.length ; k++ ){
				  
				   if ( c == caracteresEspeciales[k] || c == ' '){
						tiene_caracteres_especiales = true ; 
				   }
			 }
		}

	//las palabra no puede tener mas de tres consonantes seguidas 
	
	int contadorConsonantes = 0;

for (int i = 0; i < usuario.length(); i++) {

	// iteramos sobre el string usuario que es la palabra que introdujo el usuario 

    char letra = usuario.charAt(i);
    boolean esConsonante = false;

    // comprobar si es consonante dentro de nuestro array de consonantes 
    for (int j = 0; j < consonantes.length; j++) {
        if (letra == consonantes[j]) {
            esConsonante = true;
            break;
        }
    }

    // actualizar contador (UNA vez por letra) lo que hace la condicion es evalua si es consonante   incrementa el valor pero y dentro tenemos  otra 
	// condicon para ver si llega a tres nos devuelve un booleana para decirnos  que son tres y  mostrar por pantalla que estamos intentado introducir tre consonantes seguidas

    if (esConsonante) {
		if (contadorConsonantes == 3) {
			contadorConsonantes++;
            encontrado_consonantes = true;
            break;
        }
    } else {
        contadorConsonantes = 0;
    }
}

 // comprobar si no termina en las siguientes letras 'q' , 'w','x' podria hacerlo con un lasindexof 
 // recorrer sobre le string 

 char palabras_no_admitidas_ultimo_caracter [] = {'q','w','x'};
  for (int i = 0  ; i <usuario.length() ; i++ ){
	char c = ' ';   
	 if (i == 4 ){
		//sacamos el ultimo caracter 

		c = usuario.charAt(i);
		 
	 }
	   for(int j = 0 ; j < palabras_no_admitidas_ultimo_caracter.length ; j++ ){
		  
		 	  if (c == palabras_no_admitidas_ultimo_caracter[j]){
				 	encontrado_palabra_no_admitida = true;
					break;

			  }

	   }
 }

  // la palabra no puede contener dos vocales seguidas  
  int contdor_vocal_seguida  = 0 ; 

  for(int i = 0 ; i < usuario.length() ; i++ ){
	  //pasamos a caracter
	  char c = usuario.charAt(i); 
	  
	  boolean vocal_encontrada_letra = false ; // para comprobar letra por letra se va reiniciando cada vez 

	  for(int j = 0 ;  j < vocales_comprobar.length ; j++ ){
		 
		 if (c == vocales_comprobar[j] ){
			 vocal_encontrada_letra = true ;
			 break; 

		 }
		  
	  }
	  if(vocal_encontrada_letra){
		contdor_vocal_seguida ++;

		if (contdor_vocal_seguida == 3 ){
			tiene_caracteres_especiales = true ; 
			break; 

		}


	  }else{
			 contdor_vocal_seguida = 0 ; 
		}
	    
  }


    } 	// terminancion del else  

	if(tiene_caracteres_especiales){
		System.out.println("Error tiene 3 vocales seguidassssssssss ");
	}


	if(encontrado_consonantes){
		System.out.print("Error estas intentando introducir tres consonantes seguidas");

	}
	if(encontrado_palabra_no_admitida){
		 System.out.print("Erro la palabra no puede terminar ('q','x','w')");
	}


	if(tiene_caracteres_especiales){
		System.out.print("Error , vuelve a intentarlo tiene caracteres especiales tu palabara");
		contador_interno += 1 ; 
	}

	//condicion de salida de bucle por que ya introdujo 6 veces el mismo error 
    if (contador_interno >= 6) {
        salir_bucle_errores = true;
    }
	if(tiene_caracteres_especiales){
		contador_interno += 1 ; 
		System.out.print("Tiene caracteres especiales vuelve a intentarlo o tiene espacios ");
	}


   }while(usuario.length() != 5 && !salir_bucle_errores && !no_tiene_vocales && !tiene_caracteres_especiales && !encontrado_consonantes && !contador_vocales_seguidas );

				if (salir_bucle_errores) {
     	   			System.out.println("Demasiados intentos fallidos de entrada.");
        			break; // Esto rompe el bucle 'while (contador < 6)'
    			}
                    // Creamos un array para guardar el resultado visual de este intento
                    char resultado[] = new char[palabra_jugar.length()];

                    // Recorremos la palabra del usuario letra por letra
                    for (int i = 0; i < usuario.length(); i++) {
                        char letraUsuario = usuario.charAt(i); 
                        char letraSecreta = palabra_jugar.charAt(i); // la palabra que elegio de manera aleatorio y con la que estamos jugadno

                        // condiciones para comprobar si esta en la posicion o no 
                        if (letraUsuario == letraSecreta) {
                            if (letraUsuario >= 'a' && letraUsuario <= 'z') {
                                resultado[i] = (char) (letraUsuario - 32);
                            } else {
                                resultado[i] = letraUsuario;
                            }
                        } 
                        else {
                            // comprobar si la letra existe en otra posicion 
                            boolean existeEnOtraPosicion = false;
                            for (int j = 0; j < palabra_jugar.length(); j++) {
                                if (letraUsuario == palabra_jugar.charAt(j)) {
                                    existeEnOtraPosicion = true;
                                }
                            }

                            if (existeEnOtraPosicion) {
                                resultado[i] = letraUsuario; // Se queda en minuscula
                            } else {
                                // si no existe en la palabra ponemos asteriscos
                                resultado[i] = '*';
                            }
                        }
                    }

                    //imprimos el resultado 
                    System.out.print("Resultado: ");
                    for (int i = 0; i < resultado.length; i++) {
                        System.out.print(resultado[i]);
                    }
                    System.out.println(); // salto de linea 

					//condicion si el usuario aserto  
                    if (usuario.equals(palabra_jugar)) {
                        System.out.println("¡Ganaste!");
                        break;
                    }
                    
                    contador++;
                }
            }
        } while (opcion != 's'); 
	
	}
}