
package proyectoModelos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {

	private static int numeroUsuarios;

	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNacimiento;
	protected String ciudad;
	protected String idioma;
	protected int edad;
	protected String sexo;
	protected String contrasenia;
	protected String descripcion;
	protected String preferencias;
	protected ArrayList<String> intereses= new ArrayList();

	public Usuario() {
		super();

		nombre = "UsuarioPrueba";
		apellido = "ProbarApellido";
		fechaNacimiento = LocalDate.of(1993, 03, 14);
		ciudad = "Sevilla";
		idioma = "Espanol";
		edad=29;
		contrasenia = "123Ma!";
		descripcion = "en una palabra: betico";
		preferencias = "indiferente";
		this.intereses.add("rpg");this.intereses.add("plataformas");this.intereses.add("informatica");
		Usuario.numeroUsuarios++;
	}

	public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, String ciudadNacimiento, String idioma,
			String contrasenia, String descripcion, String preferencias, ArrayList<String> intereses) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudadNacimiento;
		this.idioma = idioma;
		this.edad=calcularEdad(fechaNacimiento);
		this.contrasenia = contrasenia;
		this.descripcion = descripcion;
		this.preferencias = preferencias;
		this.intereses = intereses;
	}

	public static int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getPreferencias() {
		return preferencias;
	}

	public static void setNumeroUsuarios(int numeroUsuarios) {
		Usuario.numeroUsuarios = numeroUsuarios;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public String getciudad() {

		return ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getIdioma() {
		return idioma;
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
				
		
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public void setIntereses(ArrayList<String> intereses) {
		this.intereses = intereses;
	}

	public int getEdad() {
		return edad;
	}
	
	public int  calcularEdad(LocalDate fechaNacimiento) {
		LocalDate fechaActual= LocalDate.now();
	
		return Period.between(fechaNacimiento, fechaActual).getYears();
		
		
	}
	public String calcularCompatiblidad(Usuario Usuario_a_comparar) {
		
		// TODO hay que trabajar sobre este metodo.
		
		String mensaje = null;
		int compatiblidad = 0;
		int diferenciaEdad = Math.abs(this.edad - Usuario_a_comparar.edad);
		int num_interesesComunes; // Al tama�o del array de cosas comunes que tengan lo voy a multiplicar por 10
		
		List<String> interesesComunes = new ArrayList<String>(this.intereses);
		    interesesComunes.retainAll(Usuario_a_comparar.getIntereses());
		    
		if(diferenciaEdad<=5)
			compatiblidad=+10;
		if(this.ciudad.equals(Usuario_a_comparar.getciudad()))
			compatiblidad=+10;
		
		num_interesesComunes=interesesComunes.size()*10;
		compatiblidad=+num_interesesComunes;
		
		if(this.preferencias.equals(Usuario_a_comparar.preferencias))
			compatiblidad=+20;
		
	// TODO  He planteado esto como un String para ahorrame trabajo posteriormente. Ya veremos si es buena idea o no.
		
		if(compatiblidad>100) {
			mensaje="PARECE QUE SOIS MUY PERO QUE MUY COMPATIBLES. MUY MAL TENDRIA QUE DARSE\nCOMPATIBILIDAD: "
					+ compatiblidad;
		}
		else {
			mensaje="Tu compatiblidad con este usuario es la siguiente: "+compatiblidad;
		}
		
		return mensaje;
		
	}

	@Override
	public String toString() {
		String output = "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Nombre", nombre);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Apellido", apellido);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Edad", edad);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Ciudad", ciudad);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Idioma", idioma);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Preferencias", preferencias);
		output += "+------------------+---------------------+\n";
		output += String.format("| %-16s | %-19s |%n", "Intereses", intereses);
		output += "+------------------+---------------------+\n";
		  output += "\nDescripci�n:\n";
	        output += "+----------------------------------------+\n";
	        output += String.format("| %-38s |%n", descripcion);
	        output += "+----------------------------------------+\n";

		return output;

	}
	public static List<Usuario> filtrarPorCiudad( List<Usuario> ciudades,String ciudad) {
        List<Usuario> filtradas = new ArrayList<>();
        for (Usuario c : ciudades) {
            if (c.getciudad().equalsIgnoreCase(ciudad)) {
                filtradas.add(c);
            }
        }
        return filtradas;
    }
    public static List<Usuario> filtrarPorEdad(List<Usuario> edad, int edadMinima, int edadMaxima) {
        return edad.stream()
                .filter(ciudades -> ciudades.getEdad() >= edadMinima && ciudades.getEdad() <= edadMaxima)
                .collect(Collectors.toList());
    }

    public static List<Usuario> filtrarPorIdioma(List<Usuario> idioma,String lengua){
    	
    	List<Usuario> filtrado=new ArrayList<>();
    	
    	for (Usuario c: idioma) {
    		if (c.getIdioma().equalsIgnoreCase(lengua)){
    			filtrado.add(c);
    			
    		}
    	}
    	
		return filtrado;
    	
    }
 
    public int compara(Usuario p) {
        int datosEnComun = 0;
        
        if (this.edad == p.edad) {
            datosEnComun++;
        }
        if (this.ciudad.equalsIgnoreCase(p.ciudad)) {
        	datosEnComun++;
        }
        if (this.preferencias.equalsIgnoreCase(p.preferencias)) {
        	datosEnComun++;
        }
   
    
        return datosEnComun;
    }
    
    public static List<Usuario> personasConMasDatosEnComun(List<Usuario> usuario) {
        List<Usuario> resultado = new ArrayList<>();
        int maxDatosEnComun = 0;
        for (int i = 0; i < usuario.size(); i++) {
            for (int j = i+1; j < usuario.size(); j++) {
                int datosEnComun = usuario.get(i).compara(usuario.get(j));
                if (datosEnComun > maxDatosEnComun) {
                    resultado.clear();
                    resultado.add(usuario.get(i));
                    resultado.add(usuario.get(j));
                    maxDatosEnComun = datosEnComun;
                } else if (datosEnComun == maxDatosEnComun) {
                    resultado.add(usuario.get(i));
                    resultado.add(usuario.get(j));
                }
            }
        }
     
  
        return resultado;
    }
}
