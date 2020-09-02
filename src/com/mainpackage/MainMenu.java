package com.mainpackage;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class MainMenu extends MoneyTracker {
    String option;
    public MainMenu(double enterMoney, int timesToEnter) {
        super(enterMoney, timesToEnter);
    }

    public void startMainMenu(){
        System.out.println("Welcome to the money tracker please pick an option:");
        System.out.println("Option 1: Enter money to check if you have enough for your projects");
        System.out.println("Option 2: Check your remaining balance");
        System.out.println("Option 3: Exit");
        System.out.print("Please enter an option:");
        // make sure the user enter the correct input

        try{


                option = super.keyInput.next();



        } catch (InputMismatchException e){
            System.out.println("Please renter your option!");
            System.out.print("Please enter an option:");
            startMainMenu();
        } catch (NoSuchElementException r){
            System.out.println("Please renter your option!");
            System.out.print("Please enter an option:");
            startMainMenu();
        }


        // pick a option

        switch (option){
            case "1":
                var newCalMon = new CalculateMoney(2,2);
                newCalMon.startProgram();
            case "2":
                System.out.println("not available");
            case "3":
                System.exit(0);


        }
    }
}
