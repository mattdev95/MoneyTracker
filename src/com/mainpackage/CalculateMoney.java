package com.mainpackage;

import java.util.Arrays;
import java.util.InputMismatchException;

public class CalculateMoney extends MoneyTracker {
    // setup your variables
    private double amountMoney;

    private  int timeToEnter;
    public double remainingTotal;
    private double total = 0;
    // create an array of values
    private double[] values;
    // not used
    private double valueWithVAT;
    // create a money tracker object to access certain methods
    private MoneyTracker newMonTrack = new MoneyTracker(5, 5);

    // create the constructor from the parent class
    public CalculateMoney(double enterMoney, int timesToEnter) {
        super(enterMoney, timesToEnter);
    }
    public void startProgram() {
        // run each of the methods
        enterAmount();
        enterTimes();
        getResults();

    }
    // get the money from the user and then do some magic to it!
    @Override
    public void enterAmount() {

        try {
            System.out.print("Please enter the amount of money: ");
            // check the user has entered the correct value
            while (!keyInput.hasNextDouble()) {
                System.out.println("You have entered the wrong input, only numbers!");
                System.out.print("Please enter the amount of money: ");
                keyInput.next();
            }
            // set the variable the value entered
            amountMoney = keyInput.nextDouble();

            // get the amount of money with vat
            valueWithVAT = amountMoney - calculateVAT();

        } catch(InputMismatchException t) {
            System.out.println("You have entered the wrong value!");
            // redo entry only if the while loop does not work
            enterAmount();
        }

    }
    // allow entry of the amount of times you want to enter you money into
    private void enterTimes() {
        try {

            System.out.print("Please enter the amount of times you need to enter a value: ");
            // if the value is not correct
            while (!keyInput.hasNextInt()) {
                System.out.println("You have entered the wrong input, only numbers!");
                System.out.print("Please enter the amount of times you need to enter a value: ");

                keyInput.next();
            }
            // set the variable the value if correct
            timeToEnter = keyInput.nextInt();

            // you need to store each of the values in an array
            // check if the value entered is correct
            MoneyTracker tracker = new CalculateMoney(amountMoney, timeToEnter);
            // create a flexible array
            values = new double[timeToEnter];
            // this will go through the number of times you have entered to enter a value
            for (int i = 0; i < timeToEnter; i++) {

                System.out.print("Please enter your desired value: ");
                // if the input is incorrect
                while (!keyInput.hasNextDouble()) {
                    System.out.println("You have entered the wrong input, only numbers!");
                    System.out.print("Please enter your desired value: ");
                    keyInput.next();
                }
                // allow the iteration of each of the values
                values[i] = keyInput.nextDouble();
              //  System.out.println(values[i]);
            }
        } catch(InputMismatchException q) {
            System.out.println("You have entered the wrong value!");
            // redo entry
            enterTimes();
        }

    }
    // add all the values here
   private double countMoney() {
        // go through each value in the array
        for (double value : values) {
            total = total + value;
       }
        return total;
    }

    // get the results
    private void getResults() {
        try {
            // get the remaining total
            remainingTotal = amountMoney - countMoney();
            // set the remaining total
            newMonTrack.setRemainingTotal(remainingTotal);

            // check if the user entered too much money to add up the expenditure
            if (remainingTotal > amountMoney || remainingTotal < 0) {

                System.out.println("You have overspend your amount! \n You need to re-enter again!");
                // reset all the values
                amountMoney = 0;
                valueWithVAT = 0;
                timeToEnter = 0;
                total = 0;
                remainingTotal = 0;
                // go back to the start
                startProgram();
            }

            else {
                System.out.println("************************************************************************************************************************");
                System.out.println("The total amount you entered is €" + String.format( "%.2f", amountMoney )  + " and your costs are and you remain with €" +
                        String.format( "%.2f", remainingTotal )  );
                System.out.println("************************************************************************************************************************");
            }
        } catch(NullPointerException e) {
            System.out.println("Something has gone wrong");
        }
        var d = new MainMenu(7, 7);
        d.startMainMenu();

    }
    // using polymorphism here
    @Override
    public double calculateVAT() {
        return amountMoney * 0.2;
    }
}