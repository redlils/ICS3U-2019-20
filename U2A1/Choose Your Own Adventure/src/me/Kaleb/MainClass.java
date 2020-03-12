package me.Kaleb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainClass {
  
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    
    
  }
  
//  Confirm selection/operation with user
  private static boolean confirm(String prompt, Scanner reader) {
    System.out.print(prompt + " [y/n]: ");
    while (!reader.hasNext("[yY|nN]")) {
      System.out.print(prompt + " [y/n]: ");
      reader.next();
    }
    
    return reader.next().equalsIgnoreCase("y");
  }
  
//  Get selection from provided list
  private static <T> T getSelectionFromList(String prompt, Scanner reader, List<T> items) {
//    Create StringBuilder for better concatenation
    StringBuilder output = new StringBuilder(prompt + " [");
    
//    Loop through all provided items and add them to output message
    for (int i = 0; i < items.size(); i++) {
      T item = items.get(i);
      output.append(i + 1)
              .append(": ")
              .append(item.toString())
              .append((i + 1 == items.size()) ? "]: " : ", "); // Add tuple to change concatenation if item is last in list
    }
  
//    Print the list of items and the prompt
    System.out.print(output);
    
//    Verify input
    while (!reader.hasNext("[1-" + items.size() + "]")) {
      System.out.print(output);
      reader.next();
    }
    
//    Return selected item
    return items.get(reader.nextInt() - 1);
  }
  
//  Used to translate array into list for getSelectionFromList
  private static <T> T getSelectionFromList(String prompt, Scanner reader, T[] items) {
    return getSelectionFromList(prompt, reader, Arrays.asList(items));
  }
}
