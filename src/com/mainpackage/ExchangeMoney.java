package com.mainpackage;

import java.util.InputMismatchException;

public class ExchangeMoney extends MoneyTracker {
    // setup your variables
    private String option;
    private double enteredAmount;
    private double calAmount;


    public ExchangeMoney(double enterMoney, int timesToEnter) {
        super(enterMoney, timesToEnter);
    }

    /*
        This class will have all the methods and functionality to exchange euros to pounds
         */

    // allow the user to choose if they want to enter and exchange there own amount of money or use the remaining money
    public void chooseOption(){
        System.out.println("Please choose an option: \n Option 1 - Enter an amount of money to exchange \n " +
                "Option 2 - Exchange the amount of money you have remaining ");
        System.out.print("Please enter an option: ");
        try{
            option = super.keyInput.next();

            switch(option){
                case "1":
                    enterAmount();
                case "2":
                    exchangeMoney();
            }

        } catch (InputMismatchException e){
            System.out.println("You have entered the wrong value");
            chooseOption();
        }
    }

    // allow the user to enter the amount of money they need
    @Override
    public void enterAmount(){
        // you need to allow entry for the user to enter their dersired amount

        try{
            System.out.print("Please enter the amount of money: ");
            // check the user has entered the right amount of money
            while (!super.keyInput.hasNextDouble()) {
                System.out.println("You have entered the wrong input, only numbers!");
                super.keyInput.next();
            }
            enteredAmount = super.keyInput.nextDouble();

            exchangeMoney();

        } catch (InputMismatchException r){
            System.out.println("You have entered the wrong input!");
            enterAmount();
        } catch (NullPointerException w){
            System.out.println("Something has gone wrong!");
        }
    }
    private double findExchangeRate(double amount){
        // to exchange to pounds
        return amount * 0.90;
    }
    // retrieve the amount of money from CalculateMoney class
    private double remainingMoney(){
        var remainTot = new CalculateMoney(2,2) ;
         return remainTot.moneyRemaining();
    }

    // allow the user to exchange the money of there directed amount, so depending if the user picks option 1,
    // it will use the money entered here or if the user picked option 2, it will calcuate the exchange rate from
    // the amount the user has left from the start.
    private void exchangeMoney(){
        // if the user picked option 1, it will take the money entered and exchanged

        try{
            if(option.equals("1")){
                System.out.println("The exchange money is £" + findExchangeRate(enteredAmount));

            } else {
                System.out.println("The money you have remaining exchanged into £" + findExchangeRate(remainingMoney()));

            }
            // go back to the main menu
            var newMain = new MainMenu(2,2);
            newMain.startMainMenu();
        } catch (InputMismatchException d){
            System.out.println("Something has gone wrong");
        }


    }


}
