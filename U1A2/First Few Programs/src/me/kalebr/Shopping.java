package me.kalebr;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Shopping {
  
  static final double USB_PRICE = 19.99;
  static final double KEYBOARD_PRICE = 49.99;
  static final double MOUSE_PRICE = 25.99;
  
  static DecimalFormat moneyFormatter = new DecimalFormat("$0.00");
  
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("Hello! Welcome to Kaleb's Computer Shop! To get started, please enter the amount of USB Storage Devices you would like to purchase: ");
    int boughtUSBs = inputScanner.nextInt();
    
    System.out.print("Next, please enter the amount of keyboards you would like to purchase: ");
    int boughtKeyboards = inputScanner.nextInt();
    
    System.out.print("Finally, please enter the amount of computer mice you would like to purchase: ");
    int boughtMice = inputScanner.nextInt();
    
    double usbTotal = boughtUSBs * USB_PRICE;
    double keyboardTotal = boughtKeyboards * KEYBOARD_PRICE;
    double mouseTotal = boughtMice * MOUSE_PRICE;
  
    double subtotal = usbTotal + keyboardTotal + mouseTotal;
  
  
    System.out.println("Thank you for shopping! Your receipt goes as follows:");
    System.out.println("----------------------------------------------------");
    System.out.println("- USB Storage Device (x" + boughtUSBs + "): " + moneyFormatter.format(usbTotal));
    System.out.println("- Keyboard (x" + boughtKeyboards + "): " + moneyFormatter.format(keyboardTotal));
    System.out.println("- Computer Mouse (x" + boughtMice + "): " + moneyFormatter.format(mouseTotal));
    System.out.println("----------------------------------------------------");
    System.out.println("Subtotal: " + moneyFormatter.format(subtotal));
    System.out.println("----------------------------------------------------");
    System.out.println("Tax - HST (13%): " + moneyFormatter.format(subtotal * 0.13));
    System.out.println("----------------------------------------------------");
    System.out.println("Total: " + moneyFormatter.format(subtotal * 1.13));
    System.out.println("----------------------------------------------------");
  }
  
}
