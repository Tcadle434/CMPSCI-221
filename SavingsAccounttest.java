/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thoma
 */

import java.text.DecimalFormat;

class Test {
    
    public static void main(String args[] ) 
    {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        
        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);
        
        SavingsAccount.setInterestRate(0.04);
        
        System.out.println("Savings Account Balances");
        System.out.printf("%25s%25s%25s\n", "Month", "saver1", "saver2");
        
        for (int month = 1; month <= 12; month += 1) 
        {
            int monthNumber = month;
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            
            double balance1 = saver1.getSavingsBalance();
            double balance2 = saver2.getSavingsBalance();
            
            DecimalFormat df = new DecimalFormat("#.00");
            
          
            
            System.out.printf("%25s%25s%25s\n", monthNumber, df.format(balance1), df.format(balance2));
            
        }
        
        SavingsAccount.setInterestRate(0.05);

        
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        
        double balance1 = saver1.getSavingsBalance();
        double balance2 = saver2.getSavingsBalance();
        
        DecimalFormat df = new DecimalFormat("#.00");
        
        System.out.printf("%25s%25s%25s\n", "13", df.format(balance1), df.format(balance2));
    }
                
        
        
        
        
    }
