package ejercicio2.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Ejercicio2 {

	private List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

	public void showArray(Consumer<Integer> consumer) {
		list.forEach(consumer);
	}

	public void showArray(BiConsumer<Integer, Integer> biconsumer) {
		for (int i = 0; i < list.size(); i++) {
			biconsumer.accept(i, list.get(i));
		}
	}

	public int countArray(Predicate<Integer> predicate) {
		int count = 0;
		for (int i : list) {
			if (predicate.test(i)) {
				count++;
			}
		}
		return count;
	}

	public List<Integer> filterArray(Predicate<Integer> predicate) {
		List<Integer> copy = new ArrayList<Integer>(list);
		copy.removeIf(predicate.negate());
		return copy;
	}

	public List<Integer> transformArray(UnaryOperator<Integer> unaryOper) {
		List<Integer> copy = new ArrayList<Integer>();
		for (int i : list) {
			copy.add(unaryOper.apply(i));
		}
		return copy;
	}

	public static void main(String[] args) {
		Ejercicio2 m = new Ejercicio2();
		System.out.print("showArray para mostrar los elementos en la misma línea: ");
		Consumer<Integer> c = t -> System.out.print(t + " ");
		m.showArray(c);
		System.out.print("\nshowArray para mostrar los elementos cada uno en una línea: ");
		Consumer<Integer> c1 = t -> System.out.print("\n" + t);
		m.showArray(c1);
		System.out.print("\nshowArray para mostrar los elementos con su índice: ");
		BiConsumer<Integer, Integer> bic = (t, u) -> System.out.printf("\nElemento %d: %d", t, u);
		m.showArray(bic);
		System.out.println();
		System.out.print("\ncountArray para contar pares: ");
		Predicate<Integer> pares = t -> t % 2 == 0;
		System.out.print(m.countArray(pares));
		System.out.print("\ncountArray para contar impares: ");
		Predicate<Integer> impares = t -> t % 2 != 0;
		System.out.print(m.countArray(impares));
		System.out.print("\ncountArray para contar los mayores de 3: ");
		Predicate<Integer> mayores = t -> t > 3;
		System.out.print(m.countArray(mayores));
		System.out.println();
		System.out.print("\nfilterArray para filtrar pares:");
		System.out.print(Arrays.toString(m.filterArray(pares).toArray()));
		System.out.print("\nfilterArray para filtrar impares: ");
		System.out.print(Arrays.toString(m.filterArray(impares).toArray()));
		System.out.print("\nfilterArray para filtrar los mayores de 3: ");
		System.out.print(Arrays.toString(m.filterArray(mayores).toArray()));

		System.out.println();
		System.out.print("\ntransformArray para obtener el doble: ");
		UnaryOperator<Integer> doble = t -> t * 2;
		System.out.print(Arrays.toString(m.transformArray(doble).toArray()));
		System.out.print("\ntransformArray para obtener el triple: ");
		UnaryOperator<Integer> triple = t -> t * 3;
		System.out.print(Arrays.toString(m.transformArray(triple).toArray()));
	}

}
