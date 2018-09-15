package cs544.bank.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CurrencyConverter implements ICurrencyConverter{

    private SessionFactory sessionFactory;

    public void setSessionFactoryBean(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public double euroToDollars (double amount){
		System.out.println("CurrencyConverter: converting "+amount+" dollars to euros");
        return 1.57 * amount;
    }
    
    public double dollarsToEuros (double amount){
        return 0.637 * amount;
    }
}
