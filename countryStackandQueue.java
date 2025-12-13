import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * 
 * This class prompts the user for a file(of countries) then creates a stack and priority queue, which is sorted by happiness
 * index(of the countreis), with the contents of the file. Then a menu is provided to the user which offers choices to print the
 * stack, pop and push a country from or onto the stack, print the priority queue, remove and insert a country
 * from or onto the priority queue, and to exit the program.
 * 
 * @author Keith Brandenburg
 * @version 16 February 2025
 */
public class countryStackandQueue {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		System.out.println("\nStacks and Priority Queues");
		
		int size = 0;
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        Stack countryStack = new Stack(150);
        PriorityQ countryQueue = new PriorityQ(150);

        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            fileScanner.nextLine(); 

            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                String name = data[0];
                String capital = data[1];
                int population = Integer.parseInt(data[2]);
                double gdp = Double.parseDouble(data[3]);
                int area = Integer.parseInt(data[4]);
                double happinessIndex = Double.parseDouble(data[5]);
                
                Country country = new Country(name, capital, population, gdp, area, happinessIndex);
                countryStack.push(country);
                countryQueue.insert(country);
                size++;
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file name and try again.");
            scanner.close();
            return;
        }
        
        System.out.println("Stack created of " + size + " countries");
        System.out.println("Priority queue created of " + size + " countries");
        
        int choice;
        boolean running = true;
        while (running) {
            System.out.println("1) Print stack");
            System.out.println("2) Pop a country object from stack");
            System.out.println("3) Push a country object onto stack");
            System.out.println("4) Print priority queue");
            System.out.println("5) Remove a country object from priority queue");
            System.out.println("6) Insert a country object into priority queue");
            System.out.println("7) Exit");
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				scanner.nextLine();
			} else {
				scanner.nextLine();
				choice = -1;
			}

            switch (choice) {
                case 1:
                    countryStack.printStack();
                    break;
                case 2:
                    countryStack.pop();
                    System.out.println("One country is popped from Stack");
                    break;
                case 3:
                    System.out.println("Enter country details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Capital: ");
                    String capital = scanner.nextLine();
                    System.out.print("Population: ");
                    int population = scanner.nextInt();
                    System.out.print("GDP: ");
                    double gdp = scanner.nextDouble();
                    System.out.print("Area: ");
                    int area = scanner.nextInt();
                    System.out.print("Happiness Index: ");
                    double happinessIndex = scanner.nextDouble();
                    scanner.nextLine();
                    countryStack.push(new Country(name, capital, population, gdp, area, happinessIndex));
                    System.out.println("One country " + name + " is pushed onto stack.");
                    break;
                case 4:
                    countryQueue.printPriorityQ();
                    break;
                case 5:
                    countryQueue.remove();
                    System.out.println("One country is removed from priority queue.");
                    break;
                case 6:
                    System.out.println("Enter country details:");
                    System.out.print("Name: ");
                    name = scanner.nextLine();
                    System.out.print("Capital: ");
                    capital = scanner.nextLine();
                    System.out.print("Population: ");
                    population = scanner.nextInt();
                    System.out.print("GDP: ");
                    gdp = scanner.nextDouble();
                    System.out.print("Area: ");
                    area = scanner.nextInt();
                    System.out.print("Happiness Index: ");
                    happinessIndex = scanner.nextDouble();
                    scanner.nextLine();
                    countryQueue.insert(new Country(name, capital, population, gdp, area, happinessIndex));
                    System.out.println("One country " + name + " is inserted ont priority queue.");
                    break;
                case 7:
                    running = false;
                    System.out.println("Have a good day!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        scanner.close();
        
    }

}


