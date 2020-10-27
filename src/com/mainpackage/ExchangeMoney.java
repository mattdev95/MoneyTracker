package com.mainpackage;

import java.util.InputMismatchException;

public class ExchangeMoney extends MoneyTracker {
    // setup your variables
    private String option;
    private double enteredAmount;

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
        try {
            // allow user to enter an option
            option = keyInput.next();
            if (option.contains("1") || option.contains("2")) {

                switch (option) {
                    case "1":
                        enterAmount();
                    case "2":
                        exchangeMoney();
                }
            } else{
                // using recursion here as a temporary fix, not the best way to do this.
                System.out.println("You have entered the wrong value");
                chooseOption();
            }

            } catch(InputMismatchException e){
                System.out.println("You have entered the wrong value");
                chooseOption();
            }

    }
    public double moneyRemaining(){

        // so if they have not calculated the using option 1, they will be directed back to the main menu.
        var newMonTrack = new MoneyTracker(2,2);
        // to check if the user has entered money into option 1
        if(newMonTrack.getRemainingTotal() == 0){
            System.out.println("You have not calculated your expenditure, go back to option 1");
            // set default values, have no use here
            var newMenu = new MainMenu(2,2);
            newMenu.startMainMenu();
        }
        return newMonTrack.getRemainingTotal();
    }

    // allow the user to enter the amount of money they need
    @Override
    public void enterAmount(){
        // you need to allow entry for the user to enter their dersired amount

        try{

            // print the remainging amount if it exists
            System.out.print("Please enter the amount of money: ");

            // check the user has entered the right amount of money
            while (!keyInput.hasNextDouble()) {
                System.out.println("You have entered the wrong input, only numbers!");
                System.out.print("Please enter the amount of money: ");
                keyInput.next();
            }
            // if the input is equal a double value
            enteredAmount = keyInput.nextDouble();
            exchangeMoney();

        } catch (InputMismatchException r){
            System.out.println("You have entered the wrong input!");
            enterAmount();
        } catch (NullPointerException w){
            System.out.println("Something has gone wrong!");
            System.exit(0);
        }
    }
    private double findExchangeRate(double amount){
        // to exchange to pounds
        return amount * 0.90;
    }
    // retrieve the amount of money from CalculateMoney class


    // allow the user to exchange the money of there directed amount, so depending if the user picks option 1,
    // it will use the money entered here or if the user picked option 2, it will calcuate the exchange rate from
    // the amount the user has left from the start.
    private void exchangeMoney(){
        // if the user picked option 1, it will take the money entered and exchanged

        try{
            if(option.equals("1")){
                System.out.println("***************************************************************************************");
                System.out.println("The exchange money is £" + String.format( "%.2f", findExchangeRate(enteredAmount) )  );
                System.out.println("***************************************************************************************");

            } else {
                System.out.println("***************************************************************************************");
                System.out.println("The money you have remaining exchanged into £" +  String.format( "%.2f", findExchangeRate(moneyRemaining())) );
                System.out.println("***************************************************************************************");

            }
            // go back to the main menu
            // add some default values
            var newMain = new MainMenu(2,2);
            newMain.startMainMenu();
        } catch (InputMismatchException d){
            System.out.println("Something has gone wrong");
        }


    }


}
