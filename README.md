#Country Stack and Priority Queue

This is a Java application that reads country information from a CSV file and stores the data into two custom array based data structures, a stack and a priority queue.

The program allows the user to interact with both structures through a menu interface. Countries in the priority queue are organized by happiness index, with the highest index having the highest priority.

##Features:
- CSV File Processing: Reads country information from a CSV file and creates Country objects
- Stack Implementation: Uses an array based stack to store countries and supports push, pop, and print operations
- Priority Queue Implementation: Uses an array based priority queue that automatically organizes countries based on happiness index
- Interactive Menu: Allows users to manipulate and display both data structures
- Country Calculations: Calculates GDP per capita (GDPPC) and area per capita (APC)

##Technologies Used
- Java
- Object Oriented Programming
- Arrays
- Stack and Priority Queue Data Structures
- File Input and CSV Processing

##How to Run
#####Using Eclipse
1. Clone or download this repository
1. Open Eclipse and import the project
1. Make sure all four Java source files are included in the project
1. Run countryStackandQueue.java
1. When prompted, enter the path to the CSV file

####Using the Command Line
1. Having cloning or downloading the repository, compile the Java files
1. Run the application
1. When prompted, enter the path to the CSV file

##CSV File Format
The program expects a CSV file containing six columns in the following order:   
1. Name
1. Capital
1. Population
1. GDP
1. Area
1. HappinessIndex

##Available Operations
When the program starts, users can select from the following menu options:  
1. Print the contents of the stack.
1. Pop a country from the stack.
1. Push a country onto the stack.
1. Print the contents of the priority queue.
1. Remove the highest-priority country from the priority queue.
1. Insert a country into the priority queue.
1. Exit the program.

##Data Structure Behavior
Stack(LIFO): The stack follows the last in, first out principle. The most recently added country is the first one removed.   
Priority Queue: The priority queue organizes the countries according to their happiness index in descending order. The country with the highest happiness index is removed first.

##Author
Keith Brandenburg
