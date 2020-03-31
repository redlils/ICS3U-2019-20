package me.Kaleb;

import java.util.Scanner;

public class Main {
  
  public static void main(String[] args) {
    runProgramOne();
    runProgramTwo();
    runProgramThree();
  }
  
  private static void runProgramOne() {
    Scanner keyedInput = new Scanner(System.in);
  
    int[] numbers = new int[10];
    int total = 0;
  
    System.out.println("Enter ten integers and they will be added together:");
    for (int i = 0; i <= 9; i = i + 1)
    {
      numbers[i] = keyedInput.nextInt();
    }
  
    for (int i = 0; i <= 9; i = i + 1)
    {
      total = total + numbers[i];
    }
  
    System.out.println("The sum of those numbers is:");
    System.out.println(total);
  }
  
  private static void runProgramTwo() {
    Scanner keyedInput = new Scanner (System.in);
  
    String [ ] friends = new String [10];
  
    System.out.println("Enter the names of ten friends:");
    for (int i = 0; i <= 9; i = i + 1)
    {
      friends[i] = keyedInput.nextLine();
    }
  
    System.out.println("The fourth and seventh names listed were:");
    System.out.println("Fourth: " + friends[3]);
    System.out.println("Seventh: " + friends[6]);
  }
  
  private static void runProgramThree() {
    Scanner keyedInput = new Scanner (System.in);
  
    double [ ] marks = {34.7, 54.1, 34.8, 99.6, 43.6, 43.2};
    double total=0;
    double average;
  
    System.out.println("These are the marks:");
    for (int i = 0; i<=5; i= i + 1)
    {
      System.out.println(marks[i]);
    }
  
    for (int i = 0; i<=5; i= i + 1)
    {
      total = total + marks[i];
    }
  
    average = total/6;
  
    average = average * 10;
    average = Math.round(average);
    average = average/10;
  
    System.out.println("The average mark is:");
    System.out.println(average);
  }
}
