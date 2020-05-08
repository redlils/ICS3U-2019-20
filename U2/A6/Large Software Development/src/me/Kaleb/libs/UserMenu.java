package me.Kaleb.libs;

import java.util.List;
import java.util.Scanner;

/**
 * Represents a menu that can be modified and presented for user input
 */
public class UserMenu {
  
  /**
   * The title of the menu
   */
  String title;
  /**
   * The prompt for the menu
   */
  String prompt;
  /**
   * The different options the user can choose from
   */
  List<String> options;
  
  /**
   * Main constructor for {@link UserMenu}
   *
   * @param title The title of the menu
   * @param prompt The prompt for the menu
   * @param options The different options the user can choose from
   *
   * @see UserMenuBuilder
   */
  UserMenu(String title, String prompt, List<String> options) {
    this.title = title;
    this.prompt = prompt;
    this.options = options;
  }
  
  /**
   * Used to present the menu for user input.<br/>
   * Example (Using {@link UserMenuBuilder} to build the menu):<br/>
   * <code>UserMenu menu = new UserMenuBuilder("Kaleb's Quadratic Helper")<br/>
   *             .setPrompt("Please select an option")<br/>
   *             .addAllOptions("My",<br/>
   *             "example",<br/>
   *             "options")<br/>
   *             .build();<br/>
   *             menu.present();<code/>
   *
   * @return The selection the user made
   */
  public int present() {
    // Create a scanner to read user input
    Scanner reader = new Scanner(System.in);
    
    // Generate RegEx based on the amount of options in list
    String regex = "\\b(?:[1-";
    if (options.size() > 9) {
      regex += "9]|1[0-" + (options.size() % 10) + "])\\b";
    } else {
      regex += "9])\\b";
    }
    
    // Print the menu
    System.out.println(title);
    System.out.println("---------------------");
    System.out.println(prompt);
    for (String s :
            options) {
      System.out.println((options.indexOf(s) + 1) + ": " + s);
    }
    System.out.println("---------------------");

//    Verify input
    while (!reader.hasNext(regex)) {
      // If the input was invalid, print the menu again and wait for valid input
      System.out.println("---------------------");
      System.out.println(prompt);
      for (String s :
              options) {
        System.out.println((options.indexOf(s) + 1) + ": " + s);
      }
      System.out.println("---------------------");
      reader.next();
    }
  
    // Return the option that the user selected
    return reader.nextInt() - 1;
  }
}
