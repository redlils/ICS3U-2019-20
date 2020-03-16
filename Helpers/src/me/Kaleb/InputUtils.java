/*
    Created on 2020-03-16 at 12:10 AM
    Author: Kalcoder
*/
package me.Kaleb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
  //  Confirm selection/operation with user
  public static boolean confirm(String prompt, Scanner reader) {
    System.out.print(prompt + " [y/n]: ");
    while (!reader.hasNext("[yY|nN]")) {
      System.out.print(prompt + " [y/n]: ");
      reader.next();
    }
    
    return reader.next().equalsIgnoreCase("y");
  }
  
  //  Get selection from provided list
  public static <T> T getSelectionFromList(String prompt, Scanner reader, List<T> items) {
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
  @SafeVarargs public static <T> T getSelectionFromList(String prompt, Scanner reader, T... items) {
    return getSelectionFromList(prompt, reader, Arrays.asList(items));
  }
  
  //  Get index from selection from list
  public static int getIndexFromSelection(String prompt, Scanner reader, List<?> items) {
//    Create StringBuilder for better concatenation
    StringBuilder output = new StringBuilder(prompt + " [");

//    Loop through all provided items and add them to output message
    for (int i = 0; i < items.size(); i++) {
      Object item = items.get(i);
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
    
    return reader.nextInt() - 1;
  }
  
  //  Translate array into list for getIndexFromSelection
  public static int getIndexFromSelection(String prompt, Scanner reader, Object... items) {
    return getIndexFromSelection(prompt, reader, Arrays.asList(items));
  }
}
