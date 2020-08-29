package com.mainpackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateMoney extends MoneyTracker {
    double amountMoney;
    double valueWithVAT;
    int timeToEnter;
    double[] values;
    double total;
    double remainingTotal;
    MoneyTracker tracker;

    // create the contructor from the parent class
    public CalculateMoney(double enterMoney, int timesToEnter) {
        super(enterMoney, timesToEnter);
    }
    public void startProgram(){
       // while (!super.keyInput.toString().equals("X")){
            enterAmount();
            enterTimes();
            getResults();
       // }



    }
    // get the money from the user and then do some magic to it! Make a calculate
    private void enterAmount(){
        // create an instance
    //    var newMoney = new MoneyTracker(0,0);
        // get the amount from the user
        try{

                System.out.println("Please enter the amount of money: ");
                amountMoney = super.keyInput.nextDouble();


            // get the amount of money with vat
            valueWithVAT = amountMoney - calculateVAT();
        } catch (InputMismatchException t){
            System.out.println("You have entered the wrong value!");
            // redo entry
            amountMoney = 0;
            enterAmount();

        }


    }
    // allow entry of the amount of times you want to enter you money into
    private void enterTimes(){
        try{
            System.out.print("Please enter the amount of times you need to enter a value: ");
            timeToEnter = super.keyInput.nextInt();
            // you need to store each of the values in an array
            // check if the value entered is correct
            tracker = new CalculateMoney(amountMoney, timeToEnter);

            values = new double[timeToEnter];

            for(int i = 0; i < timeToEnter; i++){
                System.out.println("Please enter your desired value: ");
                // allow the iteration of each of the values
                values[i] = super.keyInput.nextDouble();
            }
        } catch (InputMismatchException q){
            System.out.println("You have entered the wrong value!");
            // redo entry
            enterTimes();
        }



    }
    // add all the values here
    private double countMoney(){
        for(double value : values){
            total = total + value;
        }
      return total;
    }
    private void getResults(){
        try {
            remainingTotal = amountMoney - countMoney();
            if (countMoney() > amountMoney) {
                System.out.println("You have overspend your amount!");
                System.out.print("You need to re-enter again!");
                // reset all the values
                amountMoney = 0;
                valueWithVAT = 0;
                timeToEnter = 0;
                total = 0;
                remainingTotal = 0;
                // go back to the start
                startProgram();
            } else {
                System.out.println("The total amount you entered is " + amountMoney + " and your costs are and you remain with " + remainingTotal);
            }
        }catch (NullPointerException e){
            System.out.println("Something has gone wrong");
        }

    }
    // using polymorphism here
    @Override
    public double calculateVAT(){
        return amountMoney * 0.5;
    }
}
