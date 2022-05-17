package programmer.zaman.now.application;

import programmer.zaman.now.data.City;

public class LocationApp {
	public static void main(String[] args) {

		// var location = new Location(); // ERROR
		var city = new City();
		city.name = "Jakarta";

		System.out.println(city.name);

	}
}
