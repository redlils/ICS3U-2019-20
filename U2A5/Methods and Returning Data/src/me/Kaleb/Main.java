package me.Kaleb;

import me.Kaleb.libs.UserMenu;
import me.Kaleb.libs.UserMenuBuilder;
import me.Kaleb.libs.parabola.Parabola;

import java.util.Scanner;

/**
 * Main class for the "<b>Methods and Returning Data Back to the Main Program</b>" assignment for <b>U2A5</b> of the <b>ICS3U</b> course.
 */
public class Main {
  
  /**
   * Main method
   *
   * @param args Arguments provided by the executor
   */
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    
    // Build user menu
    UserMenu menu = new UserMenuBuilder("Kaleb's Quadratic Helper")
            .setPrompt("Please select an option")
            .addAllOptions("Convert from Standard form to Vertex form", "Convert from Vertex form to Standard form", "Convert from Standard form to Factored form", "Convert from Factored form to Standard form", "Convert from Factored form to Vertex form", "Convert from Vertex form to Factored form", "Find variable from Vertex form", "Find variable from Standard form", "Find variable from Factored form", "Exit")
            .build();
  
    while (true) {
      // Present the menu and get selection from user
      int selection = menu.present();
    
      if (selection == 0) {
        // Selection: Convert from Standard form to Vertex form
        // Create variables a, b, c to represent a b and c in a standard parabola equation
        // ax^2 + bx + c
        double a;
        double b;
        double c;
      
        // Get input for a, b, c and store in variables
        System.out.print("Please input your \"a\" value: ");
        a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"b\" value: ");
        b = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"c\" value: ");
        c = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    
        // Convert from standard to vertex using convert()
        Parabola parabola = new Parabola(Parabola.ParabolaType.STANDARD, a, b, c);
        parabola = parabola.convert(Parabola.ParabolaType.VERTEX);
      
        // Print converted equation
        System.out.println("Your equation in vertex form is " + parabola);
        
      } else if (selection == 1) {
        // Selection: Convert from Vertex form to Standard form
        // Create variables a, h, k to represent a h and k in a vertex parabola equation
        // a(x-h)^2 + k
        double a;
        double h;
        double k;
    
        // Get input for a, h, k and store in variables
        System.out.print("Please input your \"a\" value: ");
        a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"h\" value: ");
        h = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"k\" value: ");
        k = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
  
        // Convert from Vertex to Standard using convert()
        Parabola parabola = new Parabola(Parabola.ParabolaType.VERTEX, a, h, k);
        parabola = parabola.convert(Parabola.ParabolaType.STANDARD);
    
        // Print converted equation
        System.out.println("Your equation in vertex form is " + parabola);
        
      } else if (selection == 2) {
        // Selection: Convert from Standard form to Factored form
        // Create variables a, b, c to represent a b and c in a standard parabola equation
        // ax^2 + bx + c
        double a;
        double b;
        double c;
      
        // Get input for a, b, c and store in variables
        System.out.print("Please input your \"a\" value: ");
        a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"b\" value: ");
        b = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"c\" value: ");
        c = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
  
        // Convert from standard to factored using convert()
        Parabola parabola = new Parabola(Parabola.ParabolaType.STANDARD, a, b, c);
        parabola = parabola.convert(Parabola.ParabolaType.FACTORED);
      
        // Print converted equation
        System.out.println("Your equation in factored form is " + parabola);
        
      } else if (selection == 3) {
        // Selection: Convert from Factored form to Standard form
        // Create variables a, r, s to represent a r and s in a standard parabola equation
        // a(x-r)(x-s)
        double a;
        double r;
        double s;
    
        // Get input for a, r, s and store in variables
        System.out.print("Please input your \"a\" value: ");
        a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"r\" value: ");
        r = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"s\" value: ");
        s = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
  
        // Convert from factored to standard using convert()
        Parabola parabola = new Parabola(Parabola.ParabolaType.FACTORED, a, r, s);
        parabola = parabola.convert(Parabola.ParabolaType.STANDARD);
    
        // Print converted equation
        System.out.println("Your equation in standard form is " + parabola);
        
      } else if (selection == 4) {
        // Selection: Convert from Factored form to Vertex form
        // Create variables a, r, s to represent a r and s in a standard parabola equation
        // a(x-r)(x-s)
        double a;
        double r;
        double s;
    
        // Get input for a, r, s and store in variables
        System.out.print("Please input your \"a\" value: ");
        a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"r\" value: ");
        r = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"s\" value: ");
        s = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
  
        // Convert from factored to vertex using convert()
        Parabola parabola = new Parabola(Parabola.ParabolaType.FACTORED, a, r, s);
        parabola = parabola.convert(Parabola.ParabolaType.VERTEX);
    
        // Print converted equation
        System.out.println("Your equation in vertex form is " + parabola);
    
      } else if (selection == 5) {
        // Selection: Convert from Vertex form to Factored form
        // Create variables a, h, k to represent a h and k in a vertex parabola equation
        // a(x-h)^2 + k
        double a;
        double h;
        double k;
    
        // Get input for a, b, c and store in variables
        System.out.print("Please input your \"a\" value: ");
        a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"h\" value: ");
        h = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"k\" value: ");
        k = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
  
        // Convert from vertex to factored using convert()
        Parabola parabola = new Parabola(Parabola.ParabolaType.VERTEX, a, h, k);
        parabola = parabola.convert(Parabola.ParabolaType.FACTORED);
    
        // Print converted equation
        System.out.println("Your equation in vertex form is " + parabola);
    
      } else if (selection == 6) {
        // Selection: Find variable from Vertex form
        // Declare a, r, s, x, y to represent a, r, s, x, y in a factored parabola equation
        // y = a(x-r)(x-s)
        double a;
        double h;
        double k;
        double x;
        double y;
        
        // Get input for x, y, h, and k and store in variables
        System.out.print("Please input your \"x\" value: ");
        x = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"y\" value: ");
        y = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"h\" value: ");
        h = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"k\" value: ");
        k = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
    
        // Calculate a
        a = Parabola.findVariable(Parabola.ParabolaType.VERTEX, Parabola.VertexVariable.A, y, x, h, k);
    
        // Print a
        System.out.println("a = " + a);
      } else if (selection == 7) {
        // Selection: Find variable from Standard form
        // Declare a, b, c, x, y to represent a, b, c, x, y in a standard parabola equation
        // y = ax^2 + bx + c
        double a;
        double b;
        double c;
        double x;
        double y;
    
        // Create the user menu to allow for the user to select which variable they would like to solve for
        UserMenuBuilder standardVariableMenu = new UserMenuBuilder()
                .setTitle("Select a variable")
                .setPrompt("Please select the variable you would like to find");
    
        // Add all variable options to user menu
        for (Parabola.StandardVariable value : Parabola.StandardVariable.values()) {
          standardVariableMenu.addOption(value.name().toLowerCase());
        }
    
        // Get selection from user
        int variableSelection = standardVariableMenu.build().present();
        
        // Select variable to solve for based on user input
        switch (variableSelection) {
          case 0:
            // Selection: a
            // Get input for x, y, b, and c and store in variables
            System.out.print("Please input your \"x\" value: ");
            x = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"y\" value: ");
            y = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"b\" value: ");
            b = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"c\" value: ");
            c = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            
            // Calculate a
            a = Parabola.findVariable(Parabola.ParabolaType.STANDARD, Parabola.StandardVariable.A, y, x, b, c);
    
            // Print a
            System.out.println("a = " + a);
            break;
          case 1:
            // Selection: b
            // Get input for x, y, a, and c and store in variables
            System.out.print("Please input your \"x\" value: ");
            x = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"y\" value: ");
            y = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"a\" value: ");
            a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"c\" value: ");
            c = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
      
            // Calculate b
            b = Parabola.findVariable(Parabola.ParabolaType.STANDARD, Parabola.StandardVariable.B, y, x, a, c);
      
            // Print b
            System.out.println("b = " + b);
            break;
          case 2:
            // Selection: c
            // Get input for x, y, a, and b and store in variables
            System.out.print("Please input your \"x\" value: ");
            x = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"y\" value: ");
            y = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"a\" value: ");
            a = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
            System.out.print("Please input your \"b\" value: ");
            b = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
      
            // Calculate c
            c = Parabola.findVariable(Parabola.ParabolaType.STANDARD, Parabola.StandardVariable.C, y, x, a, b);
      
            // Print c
            System.out.println("c = " + c);
            break;
        }
      } else if (selection == 8) {
        // Selection: Find variable from Factored form
        // Declare a, r, s, x, y to represent a, r, s, x, y in a factored parabola equation
        double a;
        double r;
        double s;
        double x;
        double y;
  
        // Get input for x, y, r, and s and store in variables
        System.out.print("Please input your \"x\" value: ");
        x = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"y\" value: ");
        y = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"r\" value: ");
        r = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
        System.out.print("Please input your \"s\" value: ");
        s = Double.parseDouble(reader.next("-*[0-9]+(?:.[0-9]+)*"));
  
        // Calculate a
        a = Parabola.findVariable(Parabola.ParabolaType.FACTORED, Parabola.FactoredVariable.A, y, x, r, s);
  
        // Print a
        System.out.println("a = " + a);
      } else if (selection == 9) {
        // Selection: Exit
        System.out.println("Goodbye!");
        System.exit(0);
      }
    }
  }
  
}
