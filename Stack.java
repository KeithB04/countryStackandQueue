
// TODO: Auto-generated Javadoc
/**
 * The Class Stack. This class creates a stack of countries and offers methods to check if the stack is empty
 * or full along with methods to push and pop countries on or off the stack. This class also provides a method
 * to print the entire stack using the tostring methods from the Country class.
 */
public class Stack {
	
	/** The stack. */
	private Country[] stack;
    
    /** The top. */
    private int top;

    /**
     * Instantiates a new stack.
     *
     * @param size the size
     */
    public Stack(int size) {
        stack = new Country[size];
        top = -1;
    }

    /**
     * Checks if is full.
     *
     * @return true, if is full
     */
    public boolean isFull() {
        return top == stack.length - 1;
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Push.
     *
     * @param country the country
     */
    public void push(Country country) {
        if (!isFull()) {
            stack[++top] = country;
        }
    }

    /**
     * Pop.
     *
     * @return the country
     */
    public Country pop() {
        return isEmpty() ? null : stack[top--];
    }

    /**
     * Prints the stack.
     */
    public void printStack() {
        System.out.println("Stack Contents:");
        System.out.println(String.format("%-45s %-15s %-10s %-10s %-10s", "Name", "Capital", "GDPPC", "APC", "Happiness Index"));
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].toString());
        }
    }

}
