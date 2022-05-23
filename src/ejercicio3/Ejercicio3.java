package ejercicio3;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio3 {

	
	
	public static void main(String[] args) {
		Map<String,Double> empleados = new HashMap<>();
		empleados.put("Ana", 2000.96);
		empleados.put("Rodrigo", 2500.74);
		empleados.put("Juan", 1000.45);
		empleados.put("Antonio", 3000.32);
		empleados.put("Pepe", 1500.58);
		
		empleados.forEach((k,v) -> System.out.printf("Empleado: %-8s Sueldo: %.2f\n",k,v));
		empleados.computeIfAbsent("Luis", v -> 1000.00);
		System.out.printf("Empleado: %-8s Sueldo: %.2f\n","Luis",empleados.get("Luis"));
		empleados.computeIfPresent("Luis", (k,v) -> v + 200.00);
		System.out.printf("Empleado: %-8s Sueldo: %.2f\n","Luis",empleados.get("Luis"));
		empleados.replaceAll((k,v) -> v + (v/10));
		System.out.println();
		empleados.forEach((k,v) -> System.out.printf("Empleado: %-8s Sueldo: %.2f\n",k,v));
	}

}
