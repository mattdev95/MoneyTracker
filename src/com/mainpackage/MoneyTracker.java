package com.mainpackage;

import java.util.Scanner;

public class MoneyTracker {
    // create your variable for the amount of money you are going to enter, the amount you are entering, the
    private double enterMoney;
    private int timesToEnter;
    // this will allow the value to be accessed by the child classes, otherwise it will be 0 if you did not have static
    private static double remainingTotal;
    // allow the scanner object to be accessed by all the child classes
    public static final Scanner keyInput = new Scanner(System.in);

    // set the constructor (more for checking values that are correct, otherwise not needed)
    public MoneyTracker(double enterMoney, int timesToEnter){
        setEnterMoney(enterMoney);
        setTimeToEnter(timesToEnter);

    }
    // check the value of money is greater than one and set it the value
    private void setEnterMoney(double enterMoney){
        if(enterMoney < 1){
            throw new IllegalArgumentException("You need to enter more money!");
        }
        else{
            this.enterMoney = enterMoney;
        }
    }
    // this method is not needed, just here to show the use of getters
    private double getEnterMoney(){
        return enterMoney;
    }

    // check the value of times to enter is a valid number and set it the value
    private void setTimeToEnter(int timesToEnter){
        if(timesToEnter < 1){
            throw new IllegalArgumentException("You need to enter more times to enter!");
        }
        else{
            this.timesToEnter = timesToEnter;
        }
    }
    // this method is not needed, just to show the use of getters
    private int getTimesToEnter(){
        return timesToEnter;
    }

    // set the value the money that is remaining and this will be accessed by the child classes
    public void setRemainingTotal(double remainingTotal){
        MoneyTracker.remainingTotal = remainingTotal;
    }
    // get the value of remaining money from the calculation
    public double getRemainingTotal(){
        return remainingTotal;
    }

    // this will be override in other classes
    public double calculateVAT(){
        // set a default
        return 0;
    }
    // create an amount of money method
    public void enterAmount(){
        // empty
    }
}
