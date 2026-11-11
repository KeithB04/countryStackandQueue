
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Loads country information from a CSV file and stores the countries
 * in an array-based stack and priority queue.
 *
 * The priority queue organizes countries by happiness index,
 * with the highest index having the highest priority.
 *
 * @author Keith Brandenburg
 * @version 11 November 2026
 */
public class countryStackandQueue {

    private static final int CAPACITY = 150;

    public static void main(String[] args) {

        System.out.println("\nCountry Stack and Priority Queue");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        Stack countryStack = new Stack(CAPACITY);
        PriorityQ countryQueue = new PriorityQ(CAPACITY);

        int size = 0;

        // Load country information from the CSV file.
        try (Scanner fileScanner = new Scanner(new File(fileName))) {

            // Skip the CSV header.
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }

            while (fileScanner.hasNextLine()) {

                String line = fileScanner.nextLine();

                // Skip empty lines.
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    String[] data = line.split(",", -1);

                    if (data.length != 6) {
                        System.out.println("Skipping invalid CSV row: " + line);
                        continue;
                    }

                    String name = data[0].trim();
                    String capital = data[1].trim();
                    long population = Long.parseLong(data[2].trim());
                    double gdp = Double.parseDouble(data[3].trim());
                    double area = Double.parseDouble(data[4].trim());
                    double happinessIndex = Double.parseDouble(data[5].trim());

                    if (name.isEmpty() || capital.isEmpty()
                            || population <= 0 || area <= 0
                            || !Double.isFinite(gdp) || gdp < 0
                            || !Double.isFinite(happinessIndex)) {

                        System.out.println("Skipping invalid country: " + name);
                        continue;
                    }

                    Country country = new Country(
                            name, capital, population, gdp, area, happinessIndex);

                    if (!countryStack.isFull() && !countryQueue.isFull()) {
                        countryStack.push(country);
                        countryQueue.insert(country);
                        size++;
                    } else {
                        System.out.println("Maximum capacity reached.");
                        break;
                    }

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Skipping invalid CSV row: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file name.");
            scanner.close();
            return;
        }

        System.out.println("\nStack created with " + size + " countries.");
        System.out.println("Priority queue created with " + size + " countries.");

        boolean running = true;

        while (running) {

            System.out.println("\n1) Print stack");
            System.out.println("2) Pop a country from stack");
            System.out.println("3) Push a country onto stack");
            System.out.println("4) Print priority queue");
            System.out.println("5) Remove a country from priority queue");
            System.out.println("6) Insert a country into priority queue");
            System.out.println("7) Exit");

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    countryStack.printStack();
                    break;

                case 2:
                    if (!countryStack.isEmpty()) {
                        countryStack.pop();
                        System.out.println("A country was popped from the stack.");
                    } else {
                        System.out.println("The stack is empty.");
                    }
                    break;

                case 3:
                    if (!countryStack.isFull()) {
                        Country stackCountry = readCountry(scanner);

                        if (stackCountry != null) {
                            countryStack.push(stackCountry);
                        }
                    } else {
                        System.out.println("The stack is full.");
                    }
                    break;

                case 4:
                    countryQueue.printPriorityQ();
                    break;

                case 5:
                    if (!countryQueue.isEmpty()) {
                        countryQueue.remove();
                        System.out.println("A country was removed from the priority queue.");
                    } else {
                        System.out.println("The priority queue is empty.");
                    }
                    break;

                case 6:
                    if (!countryQueue.isFull()) {
                        Country queueCountry = readCountry(scanner);

                        if (queueCountry != null) {
                            countryQueue.insert(queueCountry);
                        }
                    } else {
                        System.out.println("The priority queue is full.");
                    }
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

    /**
     * Reads country information from the user.
     *
     * @param scanner the input scanner
     * @return a Country object, or null if the input is invalid
     */
    private static Country readCountry(Scanner scanner) {

        try {
            System.out.println("\nEnter country details:");

            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Capital: ");
            String capital = scanner.nextLine().trim();

            System.out.print("Population: ");
            long population = Long.parseLong(scanner.nextLine().trim());

            System.out.print("GDP: ");
            double gdp = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Area: ");
            double area = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Happiness Index: ");
            double happinessIndex = Double.parseDouble(scanner.nextLine().trim());

            if (name.isEmpty() || capital.isEmpty()
                    || population <= 0 || area <= 0
                    || !Double.isFinite(gdp) || gdp < 0
                    || !Double.isFinite(happinessIndex)) {

                System.out.println("Invalid country information.");
                return null;
            }

            return new Country(
                    name, capital, population, gdp, area, happinessIndex);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Country was not added.");
            return null;
        }
    }
}
