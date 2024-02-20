package org.example.app;

//This class has all the information for each individual prospect, and also the method for calculating the mortgage
public class Prospect {
    int number;
    private String name;
    private double loan;
    private double interest;
    private int years;
    private double mortgage;

    public Prospect(int i){
        number = i;
    }

    public void prospectSetup(){
        TextReader prospectInfo = new TextReader(number);
        prospectInfo.read();
        name = prospectInfo.getName();
        loan = prospectInfo.getLoan();
        interest = prospectInfo.getInterest();
        years = prospectInfo.getYears();
        calculateMortgage();
    }

    /**
    E = mortgage = Fixed monthly payment
    b = Interest on a monthly basis
    U = Total loan
    p = Number of payments
     */
    public void calculateMortgage(){
        //Converts from yearly interest to monthly
        double b = interest / 12 / 100;
        //Converts years to amount of months
        int p = years * 12;

        double U = loan;
        double numerator = U * (b * powerOf(1 + b, p));
        double denominator = powerOf(1 + b, p) - 1;
        mortgage = numerator / denominator;
    }

    //Method written for calculating a number to the power of a given exponent
    private double powerOf(double number, int exponent){
        double result = number;
        if(exponent == 0){
            return 1;
        }
        else{
            for (int i = 1; i < exponent; i++){
                result = result * number;
            }
        }
        return result;
    }

    public double getInterest() {
        return interest;
    }

    public int getNumber(){
        return number;
    }

    public String getName() {
        return name;
    }

    public double getLoan() {
        return loan;
    }

    public int getYears() {
        return years;
    }
    public double getMortgage(){
        return mortgage;
    }
}
