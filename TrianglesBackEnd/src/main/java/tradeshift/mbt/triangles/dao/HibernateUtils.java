package tradeshift.mbt.triangles.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	// a static initializer
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/** build a SessionFactory from hibernate.cfg.xml */
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/** return the SessionFactory */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}


}
