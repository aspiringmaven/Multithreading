package me.sumitkawatra.java8.concept.lambda.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda & reference together.
 * 
 * @author sumkawat
 *
 */
public class Practice1 {
	public static void main(String[] args) {

		List<Stock> stocks = Arrays.asList(new Stock(200), new Stock(150), new Stock(120), new Stock(155));

		/**
		 * lambda + method-reference example.
		 */
		stocks.sort(Comparator.comparing(Stock::getPrice));

		stocks.stream().forEach((stock) -> {
			System.out.println(stock);
		});
		
		
		/**
		 *----------------REVERSE Sorting example.
		 */
		System.out.println("\n");
		stocks.sort(Comparator.comparing(Stock::getPrice).reversed());

		stocks.stream().forEach((stock) -> {
			System.out.println(stock);
		});

	}
}

class Stock {

	private int price;

	public Stock(int price) {
		super();
		this.setPrice(price);
	}

	@Override
	public String toString() {
		return "Stock [price=" + getPrice() + "]";
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}