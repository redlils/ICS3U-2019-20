package me.Kaleb;

import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    runProgramOne();
    runProgramTwo();
    runProgramThree();
  }
  
  private static void runProgramOne() {
    // Creates Scanner for input
    Scanner keyedInput = new Scanner(System.in);
  
    // Declare and initialize the array to store inputted numbers and the total of all numbers
    int[] numbers = new int[20];
    int total = 0;
  
    // Prompt user for twenty integers to be added
    System.out.println("Enter twenty integers and they will be added together:");
    for (int i = 0; i < numbers.length; i++)
    {
      // Add inputted number to numbers[]
      numbers[i] = keyedInput.nextInt();
    }
  
    // Loop through all values in numbers[] and add them together
    for (int i = 0; i < numbers.length; i++)
    {
      total = total + numbers[i];
    }
  
    // Print total of numbers in numbers[]
    System.out.println("The sum of those numbers is:");
    System.out.println(total);
  }
  
  private static void runProgramTwo() {
    // Creates Scanner for input
    Scanner keyedInput = new Scanner(System.in);
  
    // Declare and initialize an array of 5 strings called friends
    String[] friends = new String[5];
  
    // Prompt user for 5 names of friends
    System.out.println("Enter the names of five friends:");
    for (int i = 0; i < friends.length; i++)
    {
      friends[i] = keyedInput.nextLine();
    }
  
    // Print 2nd, 3rd and 4th inputted names
    System.out.println("The second, third and fourth names listed were:");
    System.out.println("Second: " + friends[1]);
    System.out.println("Third: " + friends[2]);
    System.out.println("Fourth: " + friends[3]);
  }
  
  private static void runProgramThree() {
    // Creates Scanner for input
    Scanner keyedInput = new Scanner(System.in);
  
    // Declare and initialize an array of doubles called marks, a double to hold the total of all values in marks[], and a double to hold average of all values in marks[]
    double[] marks = {34.7, 54.1, 34.8, 99.6, 43.6, 43.2};
    double total=0;
    double average;
  
    // Print out all marks
    System.out.println("These are the marks:");
    for (int i = 0; i < marks.length; i++)
    {
      System.out.println(marks[i]);
    }
  
    // Add all marks together
    for (int i = 0; i < marks.length; i++)
    {
      total = total + marks[i];
    }
  
    // Calculate average of all marks and store it in average variable
    average = total/6;
    average *= 10;
    average = Math.round(average);
    average /= 10;
  
    // Print out average
    System.out.println("The average mark is:");
    System.out.println(average);
  }
}
