package com.mainpackage;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MainMenu extends MoneyTracker {
    String option;
    public MainMenu(double enterMoney, int timesToEnter) {
        super(enterMoney, timesToEnter);
    }

    public void startMainMenu() throws NullPointerException {
        System.out.println("Welcome to the money tracker please pick an option: \n Option 1: Enter money to check if you have enough for your projects \n " + "Option 2: Check your remaining balance \n Option 3: Exit");
        System.out.print("Please enter an option:");
        // make sure the user enter the correct input
        try {
            // allow the user to enter a value
            option = super.keyInput.next();
            // to check if the user entered the correct value
            if (option.contains("1") || option.contains("2") || option.contains("3")) {

                switch (option) {
                    case "1":
                        var newCalMon = new CalculateMoney(2, 2);
                        newCalMon.startProgram();
                    case "2":
                        System.out.println("not available");
                    case "3":
                        System.exit(0);

                }
            }

            else {
                // this is if the value is incorrect
                System.out.println("You have entered the wrong value!");
                startMainMenu();

            }

        } catch(InputMismatchException e) {
            System.out.println("Please re-enter your option!");
            startMainMenu();
        } catch(NoSuchElementException r) {
            System.out.println("Please re-enter your option!");
            startMainMenu();
        }

    }
}
