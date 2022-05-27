package programmer.zaman.now.collection;

import java.util.Iterator;
import java.util.List;

public class IterableApp {
	public static void main(String[] args) {

		System.out.println("ITERABLE");
		Iterable<String> names = List.of("Eko", "Kurniawan", "Khannedy");
		names.forEach((e) -> System.out.println(e));

//		for (var name : names) {
//			System.out.println(name);
//		}

		System.out.println("ITERATOR");
		Iterator<String> iterator = names.iterator();
		iterator.forEachRemaining((e) -> System.out.println(e));

//		while (iterator.hasNext()) {
//			String name = iterator.next();
//			System.out.println(name);
//		}

	}
}
