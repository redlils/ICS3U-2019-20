package me.Kaleb;

import java.util.Scanner;

import static me.Kaleb.InputUtils.*;

public class MainClass {
  
  public static void main(String[] args) {
//    Create Scanner for user input
    Scanner reader = new Scanner(System.in);
    
//    Introduction
    System.out.println("Welcome to Kaleb's Choose your Own Adventure Game!");
    System.out.println("To play this game, all you have to do is follow the prompts provided.");
    
//    Confirm that the user is ready to play
    if (!confirm("Are you ready?", reader)) {
      System.out.println("Come back when you're ready!");
      System.exit(0);
    }
//    Set the scene
    System.out.println();
    System.out.println("Welcome to America! You and your friends Micheal and Jim have just arrived in New York. You need to go to a hotel, and Micheal and Jim are leaving the decision up to you.");
    int selectionOne = getIndexFromSelection("Where would you like to go?", reader, "The shady one star hotel", "The fancy 4 star hotel");
    
//    Flow path for "Shady one star hotel."
    if (selectionOne == 0) {
      System.out.println();
      System.out.println("You tell your friends that you're all going to the one star hotel that's nearby. They look at you like you're crazy. You've arrived at the hotel. The man inside looks like he's been on many drugs and isn't fit to run a hotel. You're starting to wonder how this is even legal when the man asks you what kind of room you would like.");
      int selectionTwo = getIndexFromSelection("The man gives you the following options. Pick a room! What's the worst that could happen...", reader, "The best room they have (whatever that means)", "The next available room");
  
//      Flow path for "The best room they have (whatever that means...)"
      if (selectionTwo == 0) {
        System.out.println();
        System.out.println("You've decided to choose the best room they have! The man then leads you to your room. As he's escorting you to your room, the man says \"This is the best room we got! Take it or leave it!\" Upon entering the room, you realize that it's filthy. You start to wonder. 'This is the best room they have? Whatever, lets just pay up and we cam leave tomorrow.' When you take out your wallet, you suddenly notice that you just barely had enough to afford this room. What luck! You pay the man. He grins and says \"pleasure doing business with ya,\" and proceeds to walk out. When he closes the door, you suddenly hear a lock click. You go up to the door to try it, and sure enough, it's been locked from the outside.");
        int selectionThree = getIndexFromSelection("You're stuck deciding what to do, so Micheal decides that the group should", reader, "Use their phones to call for help", "Jump out the window and try to escape");
  
//        Flow path for "Use their cell phones to call for help"
//        Ending 1/8: "Lost" Cause
        if (selectionThree == 0) {
          System.out.println();
          System.out.println("You try to use your phones. No luck, there's no signal. You all collectively decide that jumping out of the window is a stupid idea. So you wait. And wait. And wait... Eventually, you decide that one of you should jump out of the window to go find help. You all decide that Jim should be the one to do it, as Jim is the most fit out of all of you. Jim jumps out of the window, leaving you and Micheal to stay in the hotel room while he goes and finds help. Five hours later, and Jim nor the police have showed up yet. You start to wonder what happened to Jim, and what would happen to you if you were to try to leave...");
          System.out.println();
          System.out.println("Ending 1/8: \"Lost\" Cause");
          
//        Flow path for "Jump out the window and try to escape"
//        Ending 2/8: "Broke"-ing and Entering
        } else if (selectionThree == 1) {
          System.out.println();
          System.out.println("You decide to leave through the window as a group, leaving everything behind. As you're leaving, you realize that you all forgot the little money that you had, and that this means that you aren't able to buy anything or go anywhere. So, you decide to try and run back to the hotel to grab the money that your group collectively has. When you arrive in your room, the man at the front lobby is waiting there for you, and he looks angry...");
          System.out.println();
          System.out.println("Ending 2/8: \"Broke\"-ing and Entering");
        }
        
//      Flow path for "The next available room"
      } else if (selectionTwo == 1) {
        System.out.println();
        System.out.println("You decide to ask for the next available room. You figure that if you can just get this over with, you can move on tomorrow. You pay the man, and he leads you to the room. It's disgusting. But, you just accept it, and after paying the man, you realize that you just had enough money for the room. What were to happen if you went for the best room? After a stressful event, you just want to get some sleep.");
        System.out.println("You wake up, and quickly learn that Micheal and Jim are nowhere to be found. The hotel is also a lot less noisy as well. You start to wonder what happened to you and everybody else");
        int selectionThree = getIndexFromSelection("You need to do something, so what will you do to find out what happened?", reader, "Stay in the room and call your friends", "Leave the hotel and ask around");
  
//        Flow path for "Stay in the room and call your friends"
//        Ending 3/8 "Call" Alone
        if (selectionThree == 0) {
          System.out.println();
          System.out.println("You've decided to stay in your room and try to contact your friends. First you try to call Micheal, but all you get is a dial tone. After that you try Jim. Again, all you got was a dial tone. You then look over at the side table, and there are your friend's phones. You start to wonder. What happened...?");
          System.out.println();
          System.out.println("Ending 3/8: \"Call\" Alone");
          
//        Flow path for "Leave the hotel and ask around"
//        Ending 4/8: Lost in New York
        } else if (selectionThree == 1) {
          System.out.println();
          System.out.println("You decide to leave the room and look for your friends. The only problem is that you have no leads as to where they are, and New York is a pretty big place...");
          System.out.println();
          System.out.println("Ending 4/8: Lost in New York");
        }
      }
//    Flow path for "The fancy 4 star hotel"
    } else if (selectionOne == 1) {
      System.out.println();
      System.out.println("You decided that it would be a good idea to go to the four star hotel over the shady looking hotel nearby. Your friends all think it's a good idea as well. When you arrive at the hotel, the man behind the counter in the lobby asks you for your name. You tell him, and he says that they have a reservation under your name. You and your friends all look at each other knowing full well that none of you made a reservation.");
      int selectionTwo = getIndexFromSelection("Do you lie about having a reservation, or tell the truth?", reader, "Tell them the reservation is yours", "Tell them that they have a mistake");
  
//      Flow path for "Tell them the reservation is yours"
      if (selectionTwo == 0) {
        System.out.println();
        System.out.println("You \"confirm\" that you have a reservation. Lucky for you, whoever actually had this reservation paid in advance! You get to stay in a four star hotel for free! Later that night, the real reservation owners come along and ask for their room. They then find out that you stole their reservation.");
        int selectionThree = getIndexFromSelection("You can either run, or fight them", reader, "Run", "Fight");
  
//        Flow path for "Run"
//        Ending 5/8: Flight
        if (selectionThree == 0) {
          System.out.println();
          System.out.println("You try to run away. Congratulations, you've made it out of your sticky situation. Or so you thought... Now you're in hot water with the police. You should know that you can't just steal someone's reservation and expect to get away with it!");
          System.out.println();
          System.out.println("Ending 5/8: Flight");
          
//        Flow path for "Fight"
//        Ending 6/8: Not so good fight
        } else if (selectionThree == 1) {
          System.out.println();
          System.out.println("You figure that you should try to fight your way out. It seems like a good idea at first, but it quickly goes wrong. If only the group of people who originally had this reservation weren't boxers...");
          System.out.println();
          System.out.println("Ending 6/8: Not so good fight");
        }
        
//      Flow path for "Tell them they have a mistake"
      } else if (selectionTwo == 1) {
        System.out.println();
        System.out.println("You decide to be honest, despite what your friends thought you should do and tell the man that the reservation is not for you. You then ask for a room, because that's what you originally came here for. Upon receiving your bill, you find that it's super expensive. You don't have that kind of money!");
        int selectionThree = getIndexFromSelection("You need to do something, and you certainly can't afford a room here.", reader, "Leave", "Ask for money");
  
//        Flow path for "Leave"
//        Ending 7/8: "Leave it"
        if (selectionThree == 0) {
          System.out.println();
          System.out.println("You decide to leave, as you don't want to make a fool of yourself. Micheal and Jim are super bummed, but you can always go next year, right?");
          System.out.println();
          System.out.println("Ending 7/8: Leave it");

//        Flow path for "Ask for money"
//        Ending 8/8: The Big Apple
        } else if (selectionThree == 1) {
          System.out.println();
          System.out.println("You text your other friend, Sean for money. He very hesitantly agrees, but he expects you to pay him back. You agree to your end of the deal, and Sean transfers you the money you need. You and your friends end up getting the room, and enjoying yourselves in New York. Turns out there's a good side to every adventure!");
          System.out.println("Ending 8/8: The Big Apple");
        }
      }
    }
  }
}
