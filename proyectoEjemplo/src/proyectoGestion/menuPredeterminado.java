package proyectoGestion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import proyectoModelos.Usuario;

public class menuPredeterminado {

	private static Scanner inputInt = new Scanner(System.in);
	private static Scanner inputString = new Scanner(System.in);

	public static void main(String[] args) {
		
		  ArrayList<Usuario> usuarios = new ArrayList<>();

	       /* usuarios.add(new Usuario("Juan", "Pérez", LocalDate.of(1990, 5, 15), "Sevilla", "Espanol",
	                "contraseña1", "Atento y carinioso", "Hetero", new ArrayList<String>() {{
	                    add("Futbol");
	                    add("Cine Clasico");
	                }}));
	        usuarios.add(new Usuario("Maria", "Garcia", LocalDate.of(1995, 8, 23), "Almeria", "Espanol",
	                "contraseña2", "Simpatica, amiga de mis amigas", "Hetero", new ArrayList<String>() {{
	                    add("Perros");
	                    add("Yoga");
	                }}));
	        usuarios.add(new Usuario("John", "Mamon", LocalDate.of(1985, 3, 8), "Huelva", "Espanol",
	                "contraseña3", "Fiestero y Trabajador", "Homo", new ArrayList<String>() {{
	                    add("Interés 5");
	                    add("Interés 6");
	                }}));
	        usuarios.add(new Usuario("Julia", "Perez", LocalDate.of(2000, 11, 2), "Cordoba", "Espanol",
	                "contraseña4", "Soy una chica amable y sincera", "Bi", new ArrayList<String>() {{
	                    add("Pintura");
	                    add("Series TV");
	                }}));
	        usuarios.add(new Usuario("Carlos", "Ramirez", LocalDate.of(1992, 1, 20), "Jaen", "Espanol",
	                "contraseña5", "Pasional, maniatico", "Hetero", new ArrayList<String>() {{
	                    add("Tenis");
	                    add("Videojuegos");
	                }}));
	        usuarios.add(new Usuario("Ana", "Mena", LocalDate.of(1988, 7, 13), "Malaga", "Espanol",
	                "contraseña6", "estudiante", "Hetero", new ArrayList<String>() {{
	                    add("Informatica");
	                    add("Futbol");
	                }}));
	        usuarios.add(new Usuario("Miguel", "Gutiérrez", LocalDate.of(1998, 4, 29), "Malaga", "Espanol",
	                "contraseña7", "atento, amable, risueño", "Bi", new ArrayList<String>() {{
	                    add("Boxeo");
	                    add("Perros");
	                }}));
	        usuarios.add(new Usuario("Sofia", "Moreno", LocalDate.of(1983, 9, 6), "Huelva", "Espanol",
	                "contraseña8", "Descripción 8", "Homo", new ArrayList<String>() {{
	                    add("Hardware");
	                    add("Pop");
	                }}));*/
	        usuarios.add(new Usuario("Jorge", "Gonzalez", LocalDate.of(1980, 12, 15), "Sevilla", "Espanol",
	                "contraseña9", "Perfeccionista, atento", "Bi", new ArrayList<String>() {{
	                    add("Futbol");
	                    add("Italiano");
	                }}));
	        usuarios.add(new Usuario("Tomas", "Demileche", LocalDate.of(1988, 12, 15), "Jaen", "Ingles",
	                "contraseña10", "Puntual, responsable", "Hetero", new ArrayList<String>() {{
	                    add("Fulbol");
	                    add("Italiano");
	                }}));
	   
	        
	        List <Usuario> filtrar=Usuario.personasConMasDatosEnComun(usuarios);
	        
	        mostrarInteresesComunes(filtrar);
	      
	        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
	        
	      
	  
		
		List<Usuario> filtro = new ArrayList<>();
		Usuario usuarioPrueba = new Usuario();
		filtro.add(usuarioPrueba);
		
		

	
	
	
	
	for (Usuario usuario : usuarios) {
	    System.out.println("Nombre: " + usuario.getNombre());
	    System.out.println("Fecha de nacimiento: " + usuario.getFechaNacimiento());
	    System.out.println("Intereses: " + usuario.getIntereses());
	    System.out.println("------------------------------");
	}
	
	
	String nombre, apellido, ciudad, idioma, descripcion, preferencias, contrasenia;
	LocalDate fechaNacimiento;
	ArrayList<String> interesesUsuario = new ArrayList<>();


	System.out.print("Nombre: ");
	nombre = inputString.next();
	System.out.print("Apellido: ");
	apellido = inputString.next();
	System.out.println("Ingrese su fecha de nacimiento");
	fechaNacimiento = Util.solicitarFecha();
	System.out.print("Ciudad: ");
	ciudad = inputString.next();
	System.out.print("Idioma: ");
	idioma = inputString.next();
	System.out.print("Descripcion: ");
	descripcion = inputString.next();

	System.out.println("Escoja sus preferencias : HETERO | HOmO | BI ");
	preferencias = inputString.next();
	// TODO REALIZAR BUCLE
	if (!(preferencias.equalsIgnoreCase("hetero") || preferencias.equalsIgnoreCase("Homo")
			|| preferencias.equalsIgnoreCase("bi")))
		System.out.println("Revise su eleccion");

	interesesUsuario = mostrarInteresesDisponibles(); // Revisar esto posteriormente. Me da que podria plantearse
														// mejor
	System.out.println("Por ultimo introduzca una contrasenia: ");
	contrasenia = inputString.next();

	Usuario usuarioNuevo = new Usuario(nombre, apellido, fechaNacimiento, ciudad, idioma, contrasenia, descripcion,
			preferencias, interesesUsuario);

	System.out.println(usuarioNuevo.calcularCompatiblidad(usuarioPrueba));
		
	}
	/*public static void compararIntereses(ArrayList<Usuario> usuarios) {
	    ArrayList<Usuario> usuariosConInteresesEnComun = new ArrayList<>();
	    for (int i = 0; i < usuarios.size(); i++) {
	        Usuario usuario1 = usuarios.get(i);
	        for (int j = i + 1; j < usuarios.size(); j++) {
	            Usuario usuario2 = usuarios.get(j);
	            ArrayList<String> intereses1 = usuario1.getIntereses();
	            ArrayList<String> intereses2 = usuario2.getIntereses();
	            for (String interes : intereses1) {
	                if (intereses2.contains(interes)) {
	                    if (!usuariosConInteresesEnComun.contains(usuario1)) {
	                        usuariosConInteresesEnComun.add(usuario1);
	                    }
	                    if (!usuariosConInteresesEnComun.contains(usuario2)) {
	                        usuariosConInteresesEnComun.add(usuario2);
	                    }
	                    break;
	                }
	            }
	        }
	    }
	    for (Usuario usuario : usuariosConInteresesEnComun) {
	        System.out.println(usuario.getNombre());
	    }
	}*/
	






	/**
	 * @author DANI_
	 * Metodo por el cual mostramos al usuario un filtro de edad, donde se le preguta al usuario
	 * un minimo un maximo de años y luego se guarda  el resultado en un ArrayList y despues se llama
	 * a otro metodo por el cual se muestra por pantalla.
	 * @param usuarios
	 */
	public static void preguntaFiltroEdad(List<Usuario> usuarios) {
		
		int minimo,maximo;
		Scanner sc= new Scanner (System.in);
		System.out.println("Dime la Edad Minima que quieres filtrar");
		minimo=sc.nextInt();
		System.out.println("Dime la Edad Maxima que quieres filtrar");
		maximo=sc.nextInt();
		
		List<Usuario> personasPorEdad=Usuario.filtrarPorEdad(usuarios, minimo, maximo);
		mostrarFiltroEdad(personasPorEdad);
		
	
	}
	/**
	 * @author DANI_
	 * Metodo por el cual mostramos al usuario un filtro de Ciudad, donde se le preguta al usuario
	 * la ciudad que desea filtrar y luego se guarda  el resultado en un ArrayList y despues se llama
	 * a otro metodo por el cual se muestra por pantalla.
	 * @param usuarios
	 */

	public  static void preguntaFiltrosCiudad( List<Usuario> usuarios) {
		Scanner sc= new Scanner(System.in);
		String entradaDatos;
		System.out.println("Dime la Ciudad que quieres Filtrar");
	
		entradaDatos=sc.nextLine();
		
		 List<Usuario> personasPorCiudad = Usuario.filtrarPorCiudad(usuarios, entradaDatos);
		 mostrarFiltroCiudad(personasPorCiudad);
		
		
		
	}
	
	/**
	 * @author Manuel
	 * 
	 *         Metodo donde almacenanmos una variable String con el texto de cada
	 *         menu para usarlo en distintas partes del codigo
	 * 
	 * 
	 */
	
	private static void almacenPantallazos(int numeroPantallazo) {
		String bloqueTexto;
		switch (numeroPantallazo) {
		case 1:
			bloqueTexto = """
					�Qu� desea hacer?
					 1. - A�adir una nueva persona
					 2. - Buscar emparejamientos
					 3. - Salir del programa
					 """;
			System.out.println(bloqueTexto);

			break;
		case 2:
			bloqueTexto = """
					�Como desea buscar?
					1. - Filtrando
					2. - Personas con m�s datos en com�n
					3. - Personas con aficiones opuestas
					4.- B�squeda aleatoria
										""";
			System.out.println(bloqueTexto);
			break;
		
		case 3:
			bloqueTexto = """
					�Como Filtro quieres usar?
					1. -Por Edad
					2. -Por Idioma
					3. -Por ciudad
				
										""";
			System.out.println(bloqueTexto);
			break;


		default:
			break;
		}
	}

	/**
	 * @author Manuel Metodo que sirve como primer menu principal y donde anidaremos
	 *         los metodos principales
	 */
	private static void menuMarco() {

		// TODO Modificarlo segun lo que necesitemos

		int opcionUsuario;

		do {
			almacenPantallazos(1);
			opcionUsuario = inputInt.nextInt();
			switch (opcionUsuario) {
			case 1:
				crearUsuario();

				break;
			case 2:

				break;
			case 3:

				break;

			default:
				break;
			}
		} while (opcionUsuario != 3);

	}

	/**
	 * @author Manuel Metodo para crear una instancia de Usuario por parametros.
	 *         Tiene anidados varios metodos tantos de esta clase como de la clase
	 *         Util.
	 */
	public static void crearUsuario() {
		/*
		 * TODO Desarrollar este metodo para que mediante una serie de preguntas
		 * .
		 * almacenemos la informacion neceseria para pasarselo al constructor de clase
		 */

		/*
			
		 */
		Usuario usuarioPrueba = new Usuario();
		System.out.println(usuarioPrueba);
		String nombre, apellido, ciudad, idioma, descripcion, preferencias, contrasenia;
		LocalDate fechaNacimiento;
		ArrayList<String> interesesUsuario = new ArrayList<>();

		System.out.print("Nombre: ");
		nombre = inputString.next();
		System.out.print("Apellido: ");
		apellido = inputString.next();
		System.out.println("Ingrese su fecha de nacimiento");
		fechaNacimiento = Util.solicitarFecha();
		System.out.print("Ciudad: ");
		ciudad = inputString.next();
		System.out.print("Idioma: ");
		idioma = inputString.next();
		System.out.print("Descripcion: ");
		descripcion = inputString.next();

		System.out.println("Escoja sus preferencias : HETERO | HOmO | BI ");
		preferencias = inputString.next();
		// TODO REALIZAR BUCLE
		if (!(preferencias.equalsIgnoreCase("hetero") || preferencias.equalsIgnoreCase("Homo")
				|| preferencias.equalsIgnoreCase("bi")))
			System.out.println("Revise su eleccion");

		interesesUsuario = mostrarInteresesDisponibles(); // Revisar esto posteriormente. Me da que podria plantearse
															// mejor
		System.out.println("Por ultimo introduzca una contrasenia: ");
		contrasenia = inputString.next();

		Usuario usuarioNuevo = new Usuario(nombre, apellido, fechaNacimiento, ciudad, idioma, contrasenia, descripcion,
				preferencias, interesesUsuario);

		System.out.println(usuarioNuevo);
	}

	private static ArrayList<String> mostrarInteresesDisponibles() {
		// TODO La lista de intereses es provisional. Habra que retocarla de cara al
		// final

		String interesUnico = null; // String que usaremos para almacenar la opcion del usuario
		ArrayList<String> interesesUsuario = new ArrayList<>(); // Lista dinamica con la que podremos darle elasticidad
																// a las opciones
		// y al perfil por si quisiera modificar algo
		String bloqueTexto;
		boolean bandera = true;

		// Declaramos una lista dinamica para poder a�adir o quitar posteriormente

		String[][] listaIntereses = { { "Deportes:", "Futbol", "Baloncesto", "Tenis", "Boxeo" },
				{ "M�sica:", "Rock", "Pop", "Electr�nica" }, { "Arte y cultura:", "Pintura" },
				{ "Mascotas:", "Perros", "Gatos" }, { "Comida:", "Italiana", "Japonesa", "Mexicana" },
				{ "Bienestar y salud:", "Yoga", "Realfooder" }, { "Tecnolog�a:", "Informatica", "Hardware" },
				{ "Videojuegos:", "Rpg", "Estrategia", "Plataformas" },
				{ "Cine y TV:", "Cine clasico", "Series TV", "Ciencia ficcion" },

		};

		// Imprimir filas de datos
		for (int i = 0; i < listaIntereses.length; i++) {
			System.out.printf("%-3d", i + 1);
			for (int j = 0; j < listaIntereses[i].length; j++) {
				System.out.printf("%-20s", listaIntereses[i][j]);
			}
			System.out.println();
		}

		bloqueTexto = """

				Debe seleccionar un minimo de 3 intereses.
				Escriba sus prefrencias despues de la lista.
				Cuando finalice o desee acabar, teclee fin.

				""";
		System.out.print(bloqueTexto);

		while (bandera) {

			interesUnico = inputString.next();

			if (interesUnico.equalsIgnoreCase("fin"))
				bandera = false;

			else
				interesesUsuario = agregarInteresesUsuario(listaIntereses, interesUnico, interesesUsuario);

		}
		return interesesUsuario;

	}

	/**
	 * @author Manuel
	 * 
	 *         Metodo por el cual agregamos el interes escogido por el usuario,
	 *         proveniente de un array bidimensional que contiene los permitidos, a
	 *         un ArrayList. Se ha controlado que no se puedan introducir las
	 *         categorias generales colocando el indice fuera de la variable j
	 *         (siempre empieza en 1)
	 * 
	 * 
	 * @param interesesPermitidos arrayBidimensinoal que contiene los intereses que
	 *                            se pueden escoger
	 * @param interesEscogido     String que contiene la seleccion del usuario
	 * @param interesesUsuario    arraylist que va generandose hasta que el usuario
	 *                            decide acabar
	 * @return Devuelve el arrayList con los intereses introducidos
	 */
	private static ArrayList<String> agregarInteresesUsuario(String[][] interesesPermitidos, String interesEscogido,
			ArrayList<String> interesesUsuario) {

		// TODO poner algun tipo de mensaje para comentarle al usuario si se ha a�adido
		// o no algo a su lista

		for (int i = 0; i < interesesPermitidos.length; i++) {
			for (int j = 1; j < interesesPermitidos[i].length; j++) { // Controlamos que no se pueda introducir el
																		// INDICE

				if (interesesPermitidos[i][j].equalsIgnoreCase(interesEscogido)
						&& !interesesUsuario.contains(interesEscogido)) // Ignore case para que no haya problemas
					interesesUsuario.add(interesEscogido);
			}
		}

		return interesesUsuario;
	}
	/**
	 * @author DANI_
	 * Metodo por el cual se muestra al usuario por pantalla el resultado de filtrar una ciudad.
	 * @param personasPorCiudad
	 * @return
	 */
	public static List<Usuario> mostrarFiltroCiudad( List<Usuario>personasPorCiudad ){
		   for (Usuario u : personasPorCiudad) {
	            System.out.println(u.getNombre());
	        }
		return personasPorCiudad;
	   
}
	/**
	 * @author DANI_
	 * Metodo por el cual se muestra al usuario por pantalla el resultado de filtrar por edad.
	 * @param personasPorCiudad
	 * @return
	 */
	public static List <Usuario> mostrarFiltroEdad(List<Usuario> personasEnRangoDeEdad) {
		  for (Usuario persona : personasEnRangoDeEdad) {
	            System.out.println(persona.getNombre());
	        }
		return personasEnRangoDeEdad;
		
	}
	public static List <Usuario>mostrarInteresesComunes( List <Usuario> interesesComunes) {
	  	 
				for (Usuario persona : interesesComunes) {
	            System.out.println(persona.toString());
	        }
	  	 
		
		return interesesComunes;


	}
	public static List <Usuario> mostrarFiltroIdioma(List<Usuario> personasIdioma) {
		  for (Usuario persona :  personasIdioma) {
	            System.out.println(persona.getNombre());
	        }
		return personasIdioma;
		
	}
}
