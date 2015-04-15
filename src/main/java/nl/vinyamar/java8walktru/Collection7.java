package nl.vinyamar.java8walktru;

import java.util.ArrayList;
import java.util.List;

public class Collection7 {
	public static void main(String... args) {

		List<Something> things = Helper.someThings();

		System.err.println("Filter");
		List<Something> filtered = filter(things);
		System.err.println(filtered);

		System.err.println("Sum");
		double sum = sum(filtered);
		System.err.println(sum);

	}

	public static List<Something> filter(List<Something> things) {
		List<Something> filtered = new ArrayList<>();
		for (Something s : things) {
			if (s.getAmount() > 100.00) {
				if (s.getAmount() < 1000.00) {
					filtered.add(s);
				}
			}
		}
		return filtered;
	}

	public static double sum(List<Something> things) {
		double d = 0.0;
		for (Something s : things) {
			d += s.getAmount();
		}
		return d;
	}

}
