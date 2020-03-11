package me.Kaleb;

import java.util.Scanner;

public class MainClass {
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    
  }
  
  private static boolean confirm(String prompt, Scanner reader) {
    System.out.print(prompt + " [y/n]: ");
    while (!reader.hasNext("[yY|nN]")) {
      System.out.print(prompt + " [y/n]: ");
      reader.next();
    }
    
    return reader.next().equalsIgnoreCase("y");
  }
  
  private static T getSelectionFromList<T>() {
  
  }
  
}
