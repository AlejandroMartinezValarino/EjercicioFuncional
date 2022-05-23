package ejercicio5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Alumno a = new Alumno("Luis", true, 7.5);
		Alumno a1 = new Alumno("Pepe", false, 6.5);
		Alumno a2 = new Alumno("Antonio", true, 8);
		Alumno a3 = new Alumno("Ana", false, 8);
		Alumno a4 = new Alumno("Juan",true,8);
		Alumno a5 = new Alumno("Rodrigo",false,9);
		Alumno a6 = new Alumno("Ana",true,7.5);
		Alumno a7 = new Alumno("Antonio",false,8.5);
		List<Alumno> alumnos = Arrays.asList(a,a1,a2,a3,a4,a5,a6,a7);
		alumnos.sort(Comparator.comparing(Alumno::getNombre));
		alumnos.forEach(System.out::println);
		System.out.println();
		alumnos.sort(Comparator.comparing(Alumno::getNombre).thenComparing(Alumno::getNota).reversed());
		alumnos.forEach(System.out::println);
		
	}

}
