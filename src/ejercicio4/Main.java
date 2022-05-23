package ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Luis");
		lista.add("Pepe");
		lista.add("Antonio");
		lista.add("Rodrigo");
		lista.add("Ana");
		lista.add("Juan");
		lista.add(null);
		lista.add(null);
		
		lista.forEach(System.out::println);
		//los Comparator sin el "nullsfirst" y "nullslast" no funcionan por el NullPointerException
		lista.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
		System.out.println();
		lista.forEach(System.out::println);
		lista.sort(Comparator.nullsLast(Comparator.reverseOrder()));
		System.out.println();
		lista.forEach(System.out::println);
	}

}
