
/**
 * Implements an array-based stack of Country objects.
 * Supports standard stack operations, including push, pop,
 * checking whether the stack is empty or full, and printing
 * the contents of the stack.
 *
 * The stack follows the Last In, First Out (LIFO) principle.
 *
 * @author Keith Brandenburg
 */
public class Stack {

    /** Array used to store Country objects. */
    private Country[] stack;

    /** Index of the top element in the stack. */
    private int top;

    /**
     * Creates a stack with the specified capacity.
     *
     * @param size the maximum number of countries
     * @throws IllegalArgumentException if size is not positive
     */
    public Stack(int size) {

        if (size <= 0) {
            throw new IllegalArgumentException(
                    "Stack capacity must be greater than zero.");
        }

        stack = new Country[size];
        top = -1;
    }

    /**
     * Checks whether the stack is full.
     *
     * @return true if the stack is full, otherwise false
     */
    public boolean isFull() {
        return top == stack.length - 1;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack is empty, otherwise false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the current number of countries
     */
    public int size() {
        return top + 1;
    }

    /**
     * Pushes a country onto the top of the stack.
     *
     * @param country the country to add
     * @return true if the country was added, otherwise false
     */
    public boolean push(Country country) {

        if (isFull() || country == null) {
            return false;
        }

        stack[++top] = country;
        return true;
    }

    /**
     * Removes and returns the country at the top of the stack.
     *
     * @return the removed country, or null if the stack is empty
     */
    public Country pop() {

        if (isEmpty()) {
            return null;
        }

        Country removedCountry = stack[top];
        stack[top] = null;
        top--;

        return removedCountry;
    }

    /**
     * Prints the contents of the stack from top to bottom.
     */
    public void printStack() {

        System.out.println("\nStack Contents:");

        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }

        System.out.println(
                String.format("%-45s %-15s %-10s %-10s %-10s",
                        "Name", "Capital", "GDPPC", "APC",
                        "Happiness Index"));

        System.out.println(
                "---------------------------------------------------------------------------------------------------");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
