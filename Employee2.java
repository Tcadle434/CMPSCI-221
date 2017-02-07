/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_3;

/**
 *
 * @author thoma
 */
//import java.text.DecimalFormat;

/**
 *
 * @author thomas
 */
public abstract class Employee2 {
    
    private final String firstName;
    private final String lastName;
    private final String ssNumber;
    //private double percent;

    
    public Employee2(String firstName, String lastName, 
            String ssNumber)
    {
       this.firstName = firstName;
       this.lastName = lastName;
       this.ssNumber = ssNumber;  
       //this.percent = percent;
        
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
    
    //DecimalFormat df = new DecimalFormat("#.00");
    
    
   @Override
    public String toString()
    {
        return String.format("%s %s with ssn: %s\n", getFirstName(), getLastName(), getssNumber());
    }
    
    
    public abstract double earnings();
        // abstract superclass implementation of earnings
    
    public abstract void raise(double percent);
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.print("Employee information.\n");
        
        CommissionEmployee commissionEmployee = new CommissionEmployee("Fred", "Jones", "111-11-1111", 2000.0, .05);
        
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Sue", "Smith", "222-22-2222", 3000.0, .05, 300);

        SalariedEmployee salariedEmployee = new SalariedEmployee("Sha", "Yang", "333-33-3333", 1150.0);
        
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Ian", "Tanning", "444-44-4444", 15.0, 50);
        
        HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Angela", "Domchek", "555-55-5555", 20.0, 40);
        
        System.out.printf("%s%s%s%s%s\n", commissionEmployee, basePlusCommissionEmployee, salariedEmployee, hourlyEmployee, hourlyEmployee2);
        
        Employee2[] employees = new Employee2[5];
        
        employees[0] = commissionEmployee;
        employees[1] = basePlusCommissionEmployee;
        employees[2] = salariedEmployee;
        employees[3] = hourlyEmployee;
        employees[4] = hourlyEmployee2;
        
        
        System.out.print("Employee information after raises.\n");
        
        for (Employee2 currentEmployee: employees) // structure: (class object : array)
        {

            
            if (currentEmployee instanceof SalariedEmployee)
                    {
                       currentEmployee.raise(1.04);
                    }
            
            else
            {
                currentEmployee.raise(1.02);
            }
        }
        
        System.out.printf("%s%s%s%s%s\n", commissionEmployee, basePlusCommissionEmployee, salariedEmployee, hourlyEmployee, hourlyEmployee2);
        
        
    }
    
}

class CommissionEmployee extends Employee2
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
    
    @Override
    public double earnings()
    {
        return getCommissionRate() * getGrossSales();
    }
    
    @Override
    public void raise(double percent){
        setCommissionRate(getCommissionRate() * percent);
    }  
    
    @Override
    public String toString()
    {
        return String.format("%s: %s%s: $%.2f %n%s: %.4f%n%s: $%.2f\n",
                "Commissioned Employee", super.toString(),
                "Gross Sales", getGrossSales(), 
                "Commission Rate", getCommissionRate(),
                "Earnings", earnings());
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
    public double earnings()
    {
        
       return getBaseSalary() + super.earnings();
    }
    
    @Override
    public void raise(double percent){
        setCommissionRate(getCommissionRate() * percent);
        setBaseSalary(getBaseSalary() * percent);
    }
   

    
    @Override
    public String toString()
    {
        
        return String.format("%s: %s %s with ssn: %s%n%s: $%.2f %n%s: %.4f%n%s: $%.2f%n%s: $%.2f \n", 
      
                "Base Salary Plus Comissioned Employee",getFirstName(), getLastName(), getssNumber(), 
                "Gross Sales", getGrossSales(),
                "Commission Rate", getCommissionRate(),
                "with Base Salary of", getBaseSalary(),
                "Earnings", earnings());
     
    }
}


class SalariedEmployee extends Employee2
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
    
    @Override
    public double earnings()
    {
        return getSalary();
    }
    
    @Override
    public void raise(double percent){
        setSalary(getSalary() * percent);
    }
    

    @Override
    public String toString()
    {
        return String.format("Salaried Employee: %s%s: $%.2f%n%s: $%.2f\n", 
                super.toString(), "Salary", getSalary(),
                "Earnings", earnings());       

    }
    
    
}


class HourlyEmployee extends Employee2
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
    @Override
    public double earnings()
    {
        if (hoursWorked > 40)
            return getWage() * 40 + (getHours() - 40) * (1.5 * getWage());
        else 
            return getWage() * getHours();
    }
    
    @Override
    public void raise(double percent){
        setWage(getWage() * percent);
    };
    
    
    @Override
    public String toString()
    {
        return String.format("hourly employee: %s%s: $%.2f%n%s: %.2f%n%s: $%.2f\n",
                super.toString(), "hourly wage", getWage(),
                "hours worked", getHours(),
                "Earnings", earnings());
                
    }
}


    

