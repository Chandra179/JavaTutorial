package programmer.zaman.now.application;

import programmer.zaman.now.data.Data;
import programmer.zaman.now.data.Product;

public class Application {
	public static void main(String[] args) {

		Product product = new Product("Mac Book Pro", 30_000_000);
		System.out.println(product.name);
		System.out.println(product.price);
		System.out.println(product.equals(product));
		System.out.println(product.hashCode());
		System.out.println(product.toString());

		Data data = new Data();

	}
}
