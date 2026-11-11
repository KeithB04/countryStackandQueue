
import java.util.Locale;

/**
 * Represents a country and stores its basic information,
 * including its name, capital, population, GDP, area,
 * and happiness index.
 *
 * Provides methods to calculate GDP per capita and
 * area per capita, as well as retrieve country information.
 *
 * @author Keith Brandenburg
 */
public class Country {

    /** Name of the country. */
    private final String name;

    /** Capital city of the country. */
    private final String capital;

    /** Population of the country. */
    private final long population;

    /** Gross Domestic Product of the country. */
    private final double gdp;

    /** Area of the country. */
    private final double area;

    /** Happiness index of the country. */
    private final double happinessIndex;

    /**
     * Creates a Country object with the specified information.
     *
     * @param name the country's name
     * @param capital the country's capital
     * @param population the country's population
     * @param gdp the country's GDP
     * @param area the country's area
     * @param happinessIndex the country's happiness index
     * @throws IllegalArgumentException if any information is invalid
     */
    public Country(String name, String capital, long population,
            double gdp, double area, double happinessIndex) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Country name cannot be empty.");
        }

        if (capital == null || capital.trim().isEmpty()) {
            throw new IllegalArgumentException("Capital cannot be empty.");
        }

        if (population <= 0) {
            throw new IllegalArgumentException("Population must be greater than zero.");
        }

        if (!Double.isFinite(gdp) || gdp < 0) {
            throw new IllegalArgumentException("GDP must be a valid nonnegative number.");
        }

        if (!Double.isFinite(area) || area <= 0) {
            throw new IllegalArgumentException("Area must be greater than zero.");
        }

        if (!Double.isFinite(happinessIndex)) {
            throw new IllegalArgumentException("Happiness index must be a valid number.");
        }

        this.name = name.trim();
        this.capital = capital.trim();
        this.population = population;
        this.gdp = gdp;
        this.area = area;
        this.happinessIndex = happinessIndex;
    }

    /**
     * Returns the country's name.
     *
     * @return the country name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the country's capital.
     *
     * @return the capital city
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Returns the country's population.
     *
     * @return the population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Returns the country's GDP.
     *
     * @return the GDP
     */
    public double getGDP() {
        return gdp;
    }

    /**
     * Returns the country's area.
     *
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * Calculates GDP per capita.
     *
     * @return GDP divided by population
     */
    public double getGDPPC() {
        return gdp / population;
    }

    /**
     * Calculates area per capita.
     *
     * @return area divided by population
     */
    public double getAPC() {
        return area / population;
    }

    /**
     * Returns the country's happiness index.
     *
     * @return the happiness index
     */
    public double getHappinessIndex() {
        return happinessIndex;
    }

    /**
     * Returns a formatted representation of the country.
     *
     * @return formatted country information
     */
    @Override
    public String toString() {

        return String.format(Locale.US,
                "%-45s %-15s %10.3f %10.6f %10.3f",
                name, capital, getGDPPC(), getAPC(), happinessIndex);
    }
}
