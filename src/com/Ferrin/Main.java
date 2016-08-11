package com.Ferrin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    try {
            Main main = new Main();
            main.run(args);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean runAgain = true;
    private long runNumber = 0;
    private Scanner userInput = new Scanner( System.in );

    private void run(String[] args) throws Exception {
        while(runAgain) {
            System.out.print("This program calculates the number of steps the 3n+1 problem takes to get to 1.\n");
            long number = input();
            long timeElapsed = solve(number);
            System.out.println("It took " + timeElapsed + "nanoseconds to get to one.");
            System.out.println("The calculations were run " + runNumber + " times.");
            setRunAgain();
        }
    }

    private void setRunAgain(){
        boolean newInputNeeded = true;
        String finish;
        System.out.println("Would you like to run the program again?(Y/N)");
        while(newInputNeeded) {
            finish = userInput.next();
            if (finish.equals("N") || finish.equals("n")) {
                runAgain = false;
                newInputNeeded = false;
            }
            else if (finish.equals("Y") || finish.equals("y")){
                newInputNeeded = false;
            }
            else if (finish.isEmpty()){
                newInputNeeded = true;
            }

        }
    }

    private long solve(long currentNumber){
        boolean numberIsNotOne = true;
        long timeTaken = 0;
        long nextNumber = 0;
        long startTime = System.nanoTime();
        while(numberIsNotOne) {
            runNumber++;
            if (currentNumber % 2 == 0) {
                nextNumber = divideBy2(currentNumber);
            }
            else{
                nextNumber = threeNPlusOne(currentNumber);
            }
            if(nextNumber == 1){
                numberIsNotOne = false;
            }
            else {
                currentNumber = nextNumber;
            }
        }
        timeTaken = (System.nanoTime())-startTime;
        return timeTaken;
    }

    private long divideBy2(long currentNumber){
        currentNumber = currentNumber/2;
        return currentNumber;
    }

    private long threeNPlusOne(long currentNumber){
        currentNumber = (currentNumber*3)+1;
        return currentNumber;
    }

    private long input() {
        boolean notValid = true;
        long finalInput = 0;

        while(notValid) {
            System.out.println("Enter the positive integer you would like to test:");
            long possibleInput = userInput.nextLong();
            if (possibleInput <= 0) {
                   System.out.println("Your input must be a positive integer.");
            }
            else {
                finalInput = possibleInput;
                notValid = false;
            }
        }

        return finalInput;
    }

}
