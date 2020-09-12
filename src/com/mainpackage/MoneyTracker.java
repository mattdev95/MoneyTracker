package com.mainpackage;

import java.util.Scanner;

public class MoneyTracker {
    // create your variable for the amount of money you are going to enter, the amount you are entering, the
    private double enterMoney;
    private int timesToEnter;
    public double remainingTotal;

    public final Scanner keyInput = new Scanner(System.in);

    // set the constructor
    public MoneyTracker(double enterMoney, int timesToEnter){
        setEnterMoney(enterMoney);
        setTimeToEnter(timesToEnter);

    }
    private void setEnterMoney(double enterMoney){
        if(enterMoney < 1){
            throw new IllegalArgumentException("You need to enter more money!");
        }
        else{
            this.enterMoney = enterMoney;
        }
    }
    private double getEnterMoney(){
        return enterMoney;
    }
    private void setTimeToEnter(int timesToEnter){
        if(timesToEnter < 1){
            throw new IllegalArgumentException("You need to enter more times to enter!");
        }
        else{
            this.timesToEnter = timesToEnter;
        }
    }

    private int getTimesToEnter(){
        return timesToEnter;
    }


    public void setRemainingTotal(double remainingTotal){

            this.remainingTotal = remainingTotal;


    }
    // make this public
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
