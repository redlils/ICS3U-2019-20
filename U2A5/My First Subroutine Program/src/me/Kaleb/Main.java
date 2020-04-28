package me.Kaleb;

import java.util.Scanner;

/**
 * Main class for the "<b>My First Subroutine Program</b>" assignment for <b>U2A5</b> of the <b>ICS3U</b> course.
 */
public class Main {
  
  /**
   * Main method
   *
   * @param args Arguments provided by the executor
   */
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to Kaleb's Math Calculator!");
    System.out.println("------------------------------------");
    presentMenu(reader);
  }
  
  /**
   * Main function to show the user menu
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void presentMenu(Scanner reader) {
    // Run loop forever (will be broken when user selects exit)
    while (true) {
      // Get selection from user
      int selection = InputUtils.getIndexFromSelection("Please select a calculation from the following list", reader, "Get vertex of parabola", "Minimum or Maximum of parabola", "Check if triangle is right", "Is a number prime", "Output prime numbers up to __", "Exit");
      // Perform different actions based on the user's selection
      switch (selection) {
        // Selection: "Get vertex of parabola"
        case 0:
          getVertex(reader);
          break;
        // Selection: "Minimum or Maximum of parabola"
        case 1:
          minOrMax(reader);
          break;
        // Selection: "Check if triangle is right"
        case 2:
          isTriangleRight(reader);
          break;
        // Selection: "Is a number prime"
        case 3:
          isPrime(reader);
          break;
        // Selection: "Output prime numbers up to __"
        case 4:
          outputPrimes(reader);
          break;
        // Selection: "Exit"
        case 5:
          System.out.println("Goodbye!");
          System.exit(0);
          break;
      }
    }
  }
  
  /**
   * Get the vertex based on numbers inputted by user
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void getVertex(Scanner reader) {
    // Create variables a, b, c to represent a b and c in a standard parabola equation
    // ax^2 + bx + c
    double a;
    double b;
    double c;
    
    // Create variables h and k to represent h and k in a vertex parabola equation
    // a(x-h)^2 + k
    double h;
    double k;
    
    // Get input for a, b, c and store in variables
    System.out.print("Please input your \"a\" value: ");
    a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input your \"b\" value: ");
    b = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input your \"c\" value: ");
    c = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    
    // Start calculations
    b /= a; // Factor out a(x^2 + (b/a)x) + c
    
    h = b / 2; // Get h from factored equation (which is b/2) (a bit of math done which to show visual which doesn't need to be done in code) a(x-b/2)^2 (other part)
    h = -h; // Invert h because of the - in x-h a(x-h)^2 (other part)
    
    k = -Math.pow(h, 2); // Square the newly calculated h a(x-h)^2 + h^2 + c
    k *= a; // Distribute a into the new h a(x-h)^2 + ah^2 + c
    k += c; // Add c to get k a(x-h)^2 + k
    
    // Print result
    System.out.printf("Your vertex is (%f, %f).\n", h, k);
  }
  
  /**
   * Determine if a parabola has a minimum or a maximum based on user input
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void minOrMax(Scanner reader) {
    // Create variable for a which represents a in any form of a parabola equation
    double a;
    
    // Get input for a
    System.out.print("Please input your \"a\" value: ");
    a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    // Print if the parabola has a maximum or a minimum (-a is a maximum, +a is a minimum)
    System.out.println("The parabola has a " + (a < 0 ? "maximum." : "minimum."));
  }
  
  /**
   * Determine if a triangle is right based on user input
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void isTriangleRight(Scanner reader) {
    // Create variables legA, legB, and hypotenuse to represent the two legs and the hypotenuse of a right triangle
    double legA;
    double legB;
    double hypotenuse;
    
    // Get input for legA, legB, and hypotenuse
    System.out.print("Please input the length of one leg: ");
    legA = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input the length of the other leg: ");
    legB = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input the length of the hypotenuse: ");
    hypotenuse = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    
    // Print if the triangle is right or not (if the Math.hypot() function returns the same value as the inputted hypotenuse value, the triangle is right)
    System.out.println("The triangle is " + (Math.hypot(legA, legB) == hypotenuse ? "right." : "not right."));
  }
  
  /**
   * Determine if a number is prime based on user input
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void isPrime(Scanner reader) {
    // Create variable x which represents the number we are determining if it is prime or not
    int x;
    
    // Get input for x
    System.out.print("Please input the number: ");
    x = reader.nextInt();
    
    System.out.println(x + ((x % 2 != 0 && x % 3 != 0 && x % 5 != 0 && x % 7 != 0) || (x == 1 || x == 2 || x == 3 || x == 5 || x == 7) ? " is prime!" : " is not prime."));
  }
  
  /**
   * Output the prime numbers until a number inputted by the user
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void outputPrimes(Scanner reader) {
    // Create variable maxNumber which represents the number we will stop counting at
    int maxNumber;
    
    // Get input for maxNumber
    System.out.println("Please enter the number you would like to find the primes up to");
    maxNumber = reader.nextInt();
    
    for (int i = 1; i <= maxNumber; i++) {
      if ((i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) || (i == 1 || i == 2 || i == 3 || i == 5 || i == 7)) {
        System.out.println(i); // Only output the number if it is prime
      }
    }
  }
}
