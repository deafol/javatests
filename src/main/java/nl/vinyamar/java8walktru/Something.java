package nl.vinyamar.java8walktru;

public class Something {

	private double amount;

	public Something(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		return "Amount: " + amount;
	}
}