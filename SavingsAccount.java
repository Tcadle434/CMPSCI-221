/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thoma
 */
class SavingsAccount {
    
        static private double annualInterestRate;
        private double savingsBalance;
    
    public void calculateMonthlyInterest()
    {
        savingsBalance += savingsBalance * (annualInterestRate / 12);
    }
    
    public static void setInterestRate(double interest) 
    {
        annualInterestRate = interest;
    }
    
    public void setSavingsBalance(double balance) 
    {
        savingsBalance = balance;
    }
    
    public double getSavingsBalance()
    {
        return savingsBalance;
    }
    
}
