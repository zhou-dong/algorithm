package org.dzhou.interview.lambda;

import java.util.List;
import java.util.stream.Stream;

public class Country {

	private int population;
	private String continent;

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public int getPopulation(List<Country> countries, String continent) {
		int sum = 0;
		for (Country country : countries)
			if (country.getContinent().equals(continent))
				sum += country.getPopulation();
		return sum;
	}

	public int getPopulationLambda(List<Country> countries, String continent) {
		Stream<Country> sublist = countries.stream().filter(country -> {
			return country.getContinent().equals(continent);
		});
		Stream<Integer> populations = sublist.map(c -> c.getPopulation());
		int population = populations.reduce(0, (a, b) -> a + b);
		return population;
	}

	public int getPopulationLambda2(List<Country> countries, String continent) {
		Stream<Integer> populations = countries.stream()
				.map(c -> c.getContinent().equals(continent) ? c.getPopulation() : 0);
		return populations.reduce(0, (a, b) -> a + b);
	}

}
