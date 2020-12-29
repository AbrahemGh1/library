
package com.demo.hibernate.utility;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static HibernateUtil instance = new HibernateUtil();
	private SessionFactory sessionFactory;

	public static HibernateUtil getInstance() {
		return instance;
	}

	private HibernateUtil() {

		String hibernatePropsFilePath = "C:\\Users\\Abrahem\\Desktop\\WS\\test\\src\\main\\resources\\hibernate.cfg.xml";

		File hibernatePropsFile = new File(hibernatePropsFilePath);

		Configuration configuration = new Configuration();
		configuration.configure(hibernatePropsFile);
		configuration.addAnnotatedClass(com.demo.hibernate.entity.Book.class);
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());

		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();

		return session;
	}
}
