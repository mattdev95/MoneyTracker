package com.mainpackage;

import java.util.Scanner;

public class MoneyTracker {
    // create your variable for the amount of money you are going to enter, the amount you are entering, the
    private double enterMoney;
    private int timesToEnter;

    public final Scanner keyInput = new Scanner(System.in);

    // set the contructor
    public MoneyTracker(double enterMoney, int timesToEnter){
        setEnterMoney(enterMoney);
        setTimeToEnter(timesToEnter);

    }
    private void setEnterMoney(double enterMoney){
        if(enterMoney < 1){
            throw new IllegalArgumentException("How you have entered a value too low!");
        }
        else{
            this.enterMoney = enterMoney;
        }
    }
    private double getEnterMoney(){
        return enterMoney;
    }
    private void setTimeToEnter(int timesToEnter){
        if(enterMoney < 1){
            throw new IllegalArgumentException("How you have entered a value too low!");
        }
        else{
            this.timesToEnter = timesToEnter;
        }
    }

    private int getTimesToEnter(){
        return timesToEnter;
    }

    // this will be overried in other classes
    public double calculateVAT(){
        // set a default
        return 0;
    }
}
