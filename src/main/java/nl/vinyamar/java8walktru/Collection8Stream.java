package nl.vinyamar.java8walktru;

import java.util.List;
import java.util.stream.Collectors;

public class Collection8Stream {

	public static void main(String... args) {

		List<Something> things = Helper.someThings();

		System.err.println("Filter lambda");
		List<Something> filtered = things.stream().parallel().filter( t -> t.getAmount() > 100.00 && t.getAmount() < 1000.00).collect(Collectors.toList());
		System.err.println(filtered);

		System.err.println("Sum lambda");
		double sum = filtered.stream().mapToDouble(t -> t.getAmount()).sum();
		System.err.println(sum);

	}}
