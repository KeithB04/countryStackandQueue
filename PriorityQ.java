
// TODO: Auto-generated Javadoc
/**
 * The Class PriorityQ. This class creates a priority queue of countries sorted based off happiness index. This
 * class offers methods to check if the queue is full or empty and methods to insert or remove into the queue or
 * from the queue. This class also offers a method that prints the queue using the tostring method from the 
 * country class.
 */
public class PriorityQ {

	/** The queue. */
	private Country[] queue;
    
    /** The size. */
    private int size;

    /**
     * Instantiates a new priority Q.
     *
     * @param capacity the capacity
     */
    public PriorityQ(int capacity) {
        queue = new Country[capacity];
        size = 0;
    }

    /**
     * Checks if is full.
     *
     * @return true, if is full
     */
    public boolean isFull() {
        return size == queue.length;
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert.
     *
     * @param country the country
     */
    public void insert(Country country) {
        if (isFull()) return;
        int i;
        for (i = size - 1; i >= 0 && queue[i].getHappinessIndex() < country.getHappinessIndex(); i--) {
            queue[i + 1] = queue[i];
        }
        queue[i + 1] = country;
        size++;
    }

    /**
     * Removes the beginning of the PriorityQ.
     */
    public void remove() {
    	if (size > 0) {
            System.out.println("Removed: " + queue[0]);
            System.arraycopy(queue, 1, queue, 0, --size);
        } else {
            System.out.println("Priority Queue is empty!");
        }
    }

    /**
     * Prints the priority Q.
     */
    public void printPriorityQ() {
    	System.out.println("Priority Queue Contents:");
        System.out.println(String.format("%-45s %-15s %-10s %-10s %-10s", "Name", "Capital", "GDPPC", "APC", "Happiness Index"));
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (int i = 0; i < size; i++) {
            System.out.println(queue[i].toString());
        }
    }
	
}
