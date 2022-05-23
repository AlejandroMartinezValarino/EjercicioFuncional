package ejercicio5;

public class Alumno {
	private String nombre;
	private boolean repetidor;
	private double nota;
	
	public Alumno(String nombre, boolean repetidor,double nota) {
		this.nombre = nombre;
		this.nota = nota;
		this.repetidor = repetidor;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", repetidor=" + repetidor + ", nota=" + nota + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public double getNota() {
		return nota;
	}
}
