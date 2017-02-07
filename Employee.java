/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_2;

import java.text.DecimalFormat;

/**
 *
 * @author thomas
 */
public class Employee {
    
    private final String firstName;
    private final String lastName;
    private final String ssNumber;
    //protected double earnings;
    
    public Employee(String firstName, String lastName, 
            String ssNumber)
    {
       this.firstName = firstName;
       this.lastName = lastName;
       this.ssNumber = ssNumber;
       //this.earnings = earnings; 
       
        
    } 
    
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    
    public String getssNumber()
    {
        return ssNumber;
    }
    
    DecimalFormat df = new DecimalFormat("#.00");
   // @Override
    //public String toString()
   // {
        //return String.format("%s: %s %s %n%s: %s\n", "")
    //}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CommissionEmployee employee1 = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
        
        BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);

        SalariedEmployee employee3 = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
        
        HourlyEmployee employee4 = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
        
        HourlyEmployee employee5 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
        
        System.out.printf("%s%s%s%s%s", employee1, employee2, employee3, employee4, employee5);
    }
    
}

class CommissionEmployee extends Employee
{
    private double grossSales;
    private double commissionRate;
    //private double earnings;
    
    public CommissionEmployee(String firstName, String lastName,
            String ssNumber, double grossSales, double commissionRate)
    {
        super(firstName, lastName, ssNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
        //this.earnings = earnings;
    }
    
    public void setGrossSales (double grossSales)
    {
        this.grossSales = grossSales;
    }
    
    public double getGrossSales ()
    {
        return grossSales;
    }
    
    public void setCommissionRate(double commissionRate)
    {
        this.commissionRate = commissionRate;
    }
    
    public double getCommissionRate()
    {
        return commissionRate;
    }
    
    public double getEarnings()
    {
        return getCommissionRate() * getGrossSales();
    }
    
    //DecimalFormat df = new DecimalFormat("#.00");
    
    @Override
    public String toString()
    {
        return String.format("%s: %s %s %s:%s%n%s: %s%n%s: %s%n%s: $%s\n",
                "Commissioned Employee", getFirstName(), getLastName(), "with ssn", getssNumber(),
                "Gross Sales", df.format(getGrossSales()), 
                "Commission Rate", getCommissionRate(),
                "Earnings", df.format(getEarnings()) );
    }
}




class BasePlusCommissionEmployee extends CommissionEmployee 
{
    //private double grossSales;
    //private double commissionRate;
    private double baseSalary;

    
    public BasePlusCommissionEmployee(String firstName, String lastName,
            String ssNumber, double grossSales, double commissionRate, double baseSalary)
    {
       super(firstName, lastName, ssNumber, grossSales, commissionRate);
       this.baseSalary = baseSalary; 
    }
    
    public void setBaseSalary (double baseSalary)
    {
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary ()
    {
        return baseSalary;
    }
    @Override
    public double getEarnings()
    {
        
       return getBaseSalary() + super.getEarnings();
    }
   
    //DecimalFormat df = new DecimalFormat("#.00");
    
    @Override
    public String toString()
    {
        return String.format("%s: %s %s %s:%s%n%s: %s%n%s: %s%n%s: $%s%n%s: $%s\n",
                "Base Salary Plus Commissioned Employee", getFirstName(), getLastName(), "with ssn", getssNumber(),
                "Gross Sales", df.format(getGrossSales()), 
                "Commission Rate", getCommissionRate(),
                "with Base Salary of", df.format(getBaseSalary()),
                "Earnings", df.format(getEarnings()) );
     
    }
}


class SalariedEmployee extends Employee
{
    private double salary;
    
    public SalariedEmployee(String firstName, String lastName, 
            String ssNumber, double salary)
    {
        super(firstName, lastName, ssNumber);
        this.salary = salary;
    }
    
    public void setSalary(double salary)
    {
        this.salary = salary;
        
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    //@Override
    public double getEarnings()
            {
                return salary;
            }
    
    
    @Override
    public String toString()
    {
        return String.format("%s: %s %s %s:%s%n%s: %s%n%s: $%s\n",
                "Salaried Employee", getFirstName(), getLastName(), "with ssn", getssNumber(),
                "Salary", df.format(getSalary()), 
                "Earnings", df.format(getEarnings()) );
    }
    
    
}


class HourlyEmployee extends Employee
{
    private double hourlyWage;
    private int hoursWorked;
    
    public HourlyEmployee(String firstName, String lastName, String ssNumber,
            double hourlyWage, int hoursWorked)
    {
        super(firstName, lastName, ssNumber);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
                
    }
    
    public void setWage(double hourlyWage)
    {
        if(hourlyWage > 0)
            this.hourlyWage = hourlyWage;
    }
    
    public double getWage()
    {
        return hourlyWage;
    }
    
    public void setHours(int hoursWorked)
    {
        if (hoursWorked > 0 && hoursWorked < 168)
            this.hoursWorked = hoursWorked;
    }
    
    public double getHours()
    {
        return hoursWorked;
    }
    //@Override
    public double getEarnings()
    {
        if (hoursWorked > 40)
            return hourlyWage * 40 + (hoursWorked - 40) * (1.5 * hourlyWage);
        else 
            return hourlyWage * hoursWorked;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s: %s %s %s:%s%n%s: %s%n%s: %s%n%s: $%s\n",
                "Commissioned Employee", getFirstName(), getLastName(), "with ssn", getssNumber(),
                "Hourly Wage", df.format(getWage()), 
                "Hours Worked", df.format(getHours()),
                "Earnings", df.format(getEarnings()) ); 
    }
}




