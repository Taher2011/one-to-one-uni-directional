package com.techgen.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techgen.entity.Aadhar;
import com.techgen.entity.Citizen;
import com.techgen.util.HibernateUtil;

public class OneToOneClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.openSession();

			Transaction transaction = session.getTransaction();

			transaction.begin();

			// persistAadharCitizen(session);
			// persistAadhar(session);
			// updateCitizenAadhar(session);
			// deleteAadhar(session);
			// deleteCitizen(session);

			transaction.commit();

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

	private static void persistAadharCitizen(Session session) {
		Aadhar aadhar = new Aadhar("FSVS-8488", "Indore", new Date());
		Citizen citizen = new Citizen("Taher", 30, "Male", aadhar);
		session.persist(citizen);
	}

	private static void persistAadhar(Session session) {
		Aadhar aadhar = new Aadhar("FSFS-8488", "Bhopal", new Date());
		session.persist(aadhar);
	}

	private static void updateCitizenAadhar(Session session) {
		Aadhar aadhar = getAadhar(session, 2L);
		Citizen citizen = new Citizen("Taher", 30, "Male", aadhar);
		session.persist(citizen);
	}

	private static Aadhar getAadhar(Session session, Long id) {
		Aadhar aadhar = session.get(Aadhar.class, id);
		return aadhar;
	}

	private static Citizen getCitizen(Session session, Long id) {
		Citizen citizen = session.get(Citizen.class, id);
		return citizen;
	}

	private static void deleteAadhar(Session session) {
		Aadhar aadhar = getAadhar(session, 4l);
		Citizen citizen = getCitizen(session, aadhar.getId());
		session.remove(citizen);
		session.remove(aadhar);
	}

	private static void deleteCitizen(Session session) {
		Citizen citizen = getCitizen(session, 1l);
		session.remove(citizen);
	}
}
