package cs544.bank.logging;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Logger implements ILogger{

	private SessionFactory sessionFactory;

	public void setSessionFactoryBean(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
