
// TODO: Auto-generated Javadoc
/**
 * The Class Country. This class sets up a country with a name, capital, population, gdp, area, and happiness
 * index. This class also provides methods to get the GDPPC, APC and the happiness index. This class also has a
 * to string method that returns a formatted string with the data of a country.
 */
public class Country {
	
	/** The name. */
	private String name;
    
    /** The capital. */
    private String capital;
    
    /** The population. */
    private long population;
    
    /** The gdp. */
    private double gdp;
    
    /** The area. */
    private double area;
    
    /** The happiness index. */
    private double happinessIndex;

    /**
     * Instantiates a new country.
     *
     * @param name the name
     * @param capital the capital
     * @param population the population
     * @param gdp the gdp
     * @param area the area
     * @param happinessIndex the happiness index
     */
    public Country(String name, String capital, long population, double gdp, double area, double happinessIndex) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.gdp = gdp;
        this.area = area;
        this.happinessIndex = happinessIndex;
    }

    /**
     * Gets the gdppc.
     *
     * @return the gdppc
     */
    public double getGDPPC() {
        return gdp / population;
    }

    /**
     * Gets the apc.
     *
     * @return the apc
     */
    public double getAPC() {
        return area / population;
    }

    /**
     * Gets the happiness index.
     *
     * @return the happiness index
     */
    public double getHappinessIndex() {
        return happinessIndex;
    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        return String.format("%-45s %-15s %10.3f %10.6f %10.3f", 
            name, capital, getGDPPC(), getAPC(), happinessIndex);
    }

}
