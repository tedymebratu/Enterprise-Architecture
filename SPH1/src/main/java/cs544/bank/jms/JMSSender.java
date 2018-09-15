package cs544.bank.jms;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class JMSSender implements IJMSSender{

	private SessionFactory sessionFactory;

	public void setSessionFactoryBean(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
