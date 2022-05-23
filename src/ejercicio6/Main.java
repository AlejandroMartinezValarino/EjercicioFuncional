package ejercicio6;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import ejercicio5.Alumno;

public class Main {

	public Optional<Alumno> findRepeaterStudent(String nombre) {
		Alumno a = new Alumno("Luis", true, 7.5);
		Alumno a1 = new Alumno("Pepe", false, 6.5);
		Alumno a2 = new Alumno("Antonio", true, 8);
		Alumno a3 = new Alumno("Ana", false, 8);
		Alumno a4 = new Alumno("Juan", true, 8);
		Alumno a5 = new Alumno("Rodrigo", false, 9);
		Map<String, Alumno> alumnos = new HashMap<>();
		alumnos.put(a.getNombre(), a);
		alumnos.put(a1.getNombre(), a1);
		alumnos.put(a2.getNombre(), a2);
		alumnos.put(a3.getNombre(), a3);
		alumnos.put(a4.getNombre(), a4);
		alumnos.put(a5.getNombre(), a5);
		Alumno result = alumnos.get(nombre);
		Optional<Alumno> alumno;
		if (alumnos.containsKey(nombre) && result.isRepetidor()) {
			alumno = Optional.of(result);
		} else {
			alumno = Optional.empty();
		}
		return alumno;
	}

	public static void main(String[] args) {
		Main m = new Main();
		Optional<Alumno> a = m.findRepeaterStudent("Pepe");
		Optional<Alumno> a1 = m.findRepeaterStudent("Luis");
		Optional<Alumno> a2 = m.findRepeaterStudent("Paco");
		Alumno alumno;
		// 1
		System.out.println("Pepe");
		a.ifPresentOrElse(System.out::println,
				() -> System.out.println("Este alumno no existe en la BD o no es repetidor"));
		System.out.println("Luis");
		a1.ifPresentOrElse(System.out::println,
				() -> System.out.println("Este alumno no existe en la BD o no es repetidor"));
		System.out.println("Paco");
		a2.ifPresentOrElse(System.out::println,
				() -> System.out.println("Este alumno no existe en la BD o no es repetidor"));
		// 2
		System.out.println("Pepe");
		try {
			alumno = a.orElseThrow(IllegalStateException::new);
			System.out.println(alumno);
		} catch (IllegalStateException e) {
			System.out.println("Se ha lanzado una excepción");
		}
		System.out.println("Luis");
		try {
			alumno = a1.orElseThrow(IllegalStateException::new);
			System.out.println(alumno);
		} catch (IllegalStateException e) {
			System.out.println("Se ha lanzado una excepción");
		}
		System.out.println("Paco");
		try {
			alumno = a2.orElseThrow(IllegalStateException::new);
			System.out.println(alumno);
		} catch (IllegalStateException e) {
			System.out.println("Se ha lanzado una excepción");
		}
	}

}
