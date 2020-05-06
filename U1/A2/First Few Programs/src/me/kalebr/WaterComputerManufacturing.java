package me.kalebr;

import java.util.Scanner;

public class WaterComputerManufacturing {
  
  static final double WATER_TONS_PER_COMBO = 1.5;
  
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("Hello! Welcome to Kaleb's Water and Computer Manufacturing cost calculator! To get started, please enter the amount of computer/monitor combos you own (1 computer:1 monitor): ");
    int combos = inputScanner.nextInt();
    double result = WATER_TONS_PER_COMBO * combos;
    System.out.println("Your computer/monitor combo" + (combos == 1 ? "" : "s") + " took " + result + " tons of water to manufacture!");
  }
  
}
