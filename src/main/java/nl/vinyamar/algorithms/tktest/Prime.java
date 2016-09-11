package nl.vinyamar.algorithms.tktest;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prime {

	public static void printPrimes(int first, int second) {
		IntStream.range(Math.max(1, first + 1), second)
				.filter(value -> isPrime(value))
				.forEach(value -> System.out.println(value));
	}

	public static void printPrimesParallel(int first, int second, int numberOfCores) {
		ExecutorService es = Executors.newFixedThreadPool(establishNumberOfCoresToUse(numberOfCores));
		es.execute(() -> {
			List<Integer> primesList = IntStream.range(Math.max(1, first + 1), second)
					.parallel()
					.filter(value -> isPrime(value))
					.boxed().collect(Collectors.toList());
			primesList.sort(Integer::compareTo);
			primesList.forEach(System.out::println);
		});
		es.shutdown();
	}

	private static int establishNumberOfCoresToUse(int numberOfCores) {
		int numberOfAvailableCores = Runtime.getRuntime().availableProcessors();
		if (numberOfCores > numberOfAvailableCores) {
			System.out.println(String.format("number of cores specified %s exceeds number of available cores %s. Using the latter!!)", numberOfCores, numberOfAvailableCores));
			return numberOfAvailableCores;
		}
		return numberOfCores;
	}

	private static boolean isPrime(int value) {
		for (int i = 2; i < value; i++) {
			if (value % i == 0)
				return false;
		}
		return true;
	}


	public static void main(String[] args) {
		printPrimes(-1, 31);
		printPrimes(10, 1001);
		printPrimesParallel(10, 101, 12);
	}
}
