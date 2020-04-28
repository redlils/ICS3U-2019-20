package me.Kaleb;

import java.util.Scanner;

public class Main {
  
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
    double a;
    double b;
    double c;
    
    double h;
    double k;
    System.out.print("Please input your \"a\" value: ");
    a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input your \"b\" value: ");
    b = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input your \"c\" value: ");
    c = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    
    b /= a;
    
    h = b / 2;
    h = -h;
    
    k = -Math.pow(h, 2);
    k *= a;
    k += c;
    
    System.out.printf("Your vertex is (%f, %f).\n", h, k);
  }
  
  /**
   * Determine if a parabola has a minimum or a maximum based on user input
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void minOrMax(Scanner reader) {
    double a;
    
    System.out.print("Please input your \"a\" value: ");
    a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.println("The parabola has a " + (a < 0 ? "maximum." : "minimum."));
  }
  
  /**
   * Determine if a triangle is right based on user input
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void isTriangleRight(Scanner reader) {
    double legA;
    double legB;
    double hypotenuse;
    
    System.out.print("Please input the length of one leg: ");
    legA = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input the length of the other leg: ");
    legB = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    System.out.print("Please input the length of the hypotenuse: ");
    hypotenuse = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    
    System.out.println("The triangle is " + (Math.hypot(legA, legB) == hypotenuse ? "right." : "not right."));
  }
  
  /**
   * Determine if a number is prime based on user input
   *
   * @param reader The {@link java.util.Scanner} to use when reading input
   */
  private static void isPrime(Scanner reader) {
    int x;
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
    int maxNumber;
    
    System.out.println("Please enter the number you would like to find the primes up to");
    maxNumber = reader.nextInt();
    for (int i = 1; i <= maxNumber; i++) {
      if ((i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0) || (i == 1 || i == 2 || i == 3 || i == 5 || i == 7)) {
        System.out.println(i);
      }
    }
  }
}
