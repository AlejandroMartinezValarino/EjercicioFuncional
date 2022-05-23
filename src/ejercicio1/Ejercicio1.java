package ejercicio1;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Ejercicio1 {
	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

	public void showArray(Consumer<Integer> consumer) {
		for (int i : array) {
			consumer.accept(i);
		}
	}

	public void showArray(BiConsumer<Integer, Integer> biconsumer) {
		for (int i = 0; i < array.length; i++) {
			biconsumer.accept(i, array[i]);
		}
	}

	public int countArray(Predicate<Integer> predicate) {
		int sol = 0;
		for (int i : array) {
			if (predicate.test(i)) {
				sol++;
			}
		}
		return sol;
	}

	public int[] filterArray(Predicate<Integer> predicate) {
		int length = array.length;
		int[] tmp = new int[length];
		int[] sol;
		int j = 0;
		for (int i = 0; i < length; i++) {
			if (predicate.test(array[i])) {
				tmp[j++] = array[i];
			}
		}
		sol = new int[j];
		for (int i = 0; i < j; i++) {
			sol[i] = tmp[i];
		}
		return sol;
	}

	public int[] transformArray(UnaryOperator<Integer> unaryOper) {
		int[] sol = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sol[i] = unaryOper.apply(array[i]);
		}
		return sol;
	}

	public static void main(String[] args) {
		Ejercicio1 m = new Ejercicio1();
		System.out.print("showArray para mostrar los elementos en la misma línea: ");
		Consumer<Integer> c = t -> System.out.print(t + " ");
		m.showArray(c);
		System.out.print("\nshowArray para mostrar los elementos cada uno en una línea: \n");
		Consumer<Integer> c1 = System.out::println;
		m.showArray(c1);
		System.out.print("showArray para mostrar los elementos con su índice: ");
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
		System.out.print(Arrays.toString(m.filterArray(pares)));
		System.out.print("\nfilterArray para filtrar impares: ");
		System.out.print(Arrays.toString(m.filterArray(impares)));
		System.out.print("\nfilterArray para filtrar los mayores de 3: ");
		System.out.print(Arrays.toString(m.filterArray(mayores)));

		System.out.println();
		System.out.print("\ntransformArray para obtener el doble: ");
		UnaryOperator<Integer> doble = t -> t * 2;
		System.out.print(Arrays.toString(m.transformArray(doble)));
		System.out.print("\ntransformArray para obtener el triple: ");
		UnaryOperator<Integer> triple = t -> t * 3;
		System.out.print(Arrays.toString(m.transformArray(triple)));
	}
}
