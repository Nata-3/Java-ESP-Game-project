/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: A program that tests extrasensory perception.
 * Due: 2/11/2025
 * Platform/compiler:
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: __________
*/

import java.util.*;
import java.io.*;

public class ESPGame {

	public static void main(String[] args) throws IOException {
		final int MAX_ROUNDS = 3;
		String file_name = "C:\\Users\\natna\\eclipse-workspace\\PROJECT 1\\colors.txt";
		Scanner scan = new Scanner(System.in);
        Random random = new Random();
		boolean playing = true;
		int correct_guesses = 0;
		
		
		while(playing) {
		System.out.println("Welcome to ESP - extrasensory perception!");
        System.out.println("Would you please choose one of the 4 options from the menu:");
        System.out.println("1- Read and display first 16 colors");
        System.out.println("2- Read and display first 10 colors");
        System.out.println("3- Read and display first 5 colors");
        System.out.println("4- Exit program");
        System.out.print("Enter the your choice: ");
        int choice = scan.nextInt();

        
        if (choice == 4) {
            break;
        }
		
        
        int displayed_colors;
        if (choice == 1) {
        	displayed_colors = 16;
        } else if (choice == 2) {
        	displayed_colors = 10;
        } else {
        	displayed_colors = 5;
        }
        
        
         File file = new File(file_name);  // Creates a new file object
         System.out.println("Looking for file at: " + file.getAbsolutePath());
         Scanner file_scan = new Scanner(file); // opens the file for reading using file_scan
        
        
        System.out.println("There are " + displayed_colors + " colors from the file:");
        int count = 0;
        String colors;
        while (file_scan.hasNextLine() && count < displayed_colors) { //checks if there is another line to read
            colors = file_scan.nextLine();
            System.out.println((count + 1) + " " + colors); // display the colors
            count++;
        }
        file_scan.close();

        

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            System.out.println("\nRound " + round);
            System.out.println("I am thinking of a color.");
            System.out.print("Enter your guess: ");
            String user_guess = scan.next();
            
            file_scan = new Scanner(file);
            count = 0;

            String random_color = "";
            int randomIndex = random.nextInt(displayed_colors);
            while (file_scan.hasNext() && count <= randomIndex) {
            	random_color = file_scan.nextLine().trim();
                count++;
            }
            file_scan.close();
            
            System.out.println("I was thinking of " + random_color + ".");
            if (user_guess.equalsIgnoreCase(random_color)) {
                correct_guesses++;
            }
        }
        
            System.out.println("Game Over");
            System.out.println("You guessed " + correct_guesses + " out of " + MAX_ROUNDS + " colors correctly.");

            System.out.print("Would you like to continue the game? Type Yes/No: ");
            String response = scan.next();
            if (!response.equalsIgnoreCase("Yes")) {
                playing = false;
            }
        
		} // While loop ends here
		
	        scan.nextLine();
		    System.out.print("Enter your name: ");
	        String name = scan.nextLine();
	        System.out.print("Describe yourself: ");
	        String description = scan.nextLine();
	        System.out.print("Due Date (MM/DD): ");
	        String dueDate = scan.nextLine();
		
	        System.out.println("\nUsername: " + name);
	        System.out.println("User Description: " + description);
	        System.out.println("Due Date: " + dueDate);
		

	        PrintWriter writer = new PrintWriter("EspGameResults.txt");
	        writer.println("Game Over");
	        writer.println("You guessed " + correct_guesses + " out of " + MAX_ROUNDS + " colors correctly.");
	        writer.println("Username: " + name);
	        writer.println("User Description: " + description);
	        writer.println("Due Date: " + dueDate);
	        writer.close();
	        
	}
		
}
	

	


