package nl.vinyamar.java8walktru;

import java.util.List;
import java.util.function.Consumer;

public class Collection8Consumer {
	public static void main(String... args) {

		List<Something> things = Helper.someThings();

		System.err.println("Do something functional interfaces");
		consumeSomething(things, new Consumer<Something>() {

			@Override
			public void accept(Something t) {
				System.err.println(t);
			}
		});

		System.err.println("Do something functional interfaces, using lambda");
		consumeSomething(things, (t) -> System.err.println(t));

		System.err.println("Do something functional interfaces, using lambda method reference (new operator ::) ");
		consumeSomething(things, System.err::println);

		System.err.println("Do something functional interfaces, using stream");
		things.stream().forEach(new Consumer<Something>() {

			@Override
			public void accept(Something t) {
				System.err.println(t);
			}
		});

		System.err.println("Do something functional interfaces, using stream and method reference");
		things.stream().forEach(System.err::println);
	}

	public static void doSomething(List<Something> things, Doer<Something> doer) {
		for (Something s : things) {
			doer.doSomething(s);
		}
	}

	public static void consumeSomething(List<Something> things, Consumer<Something> consumer) {
		for (Something s : things) {
			consumer.accept(s);
		}
	}
}
