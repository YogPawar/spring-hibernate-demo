package com.yogsoft.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yogsoft.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the student object
			Student theStudent = new Student("Rajesh", "Pawar", "rajesh.go.com");
			Student theStudent2 = new Student("Riyansh", "Pawar", "riyansh.go.com");
			Student theStudent3 = new Student("Mahesh", "Pawar", "mahesh.com");
			
			session.save(theStudent2);
			session.save(theStudent3);


			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Save the student into DB");
			session.save(theStudent);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Data saved into DB");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		// create session

	}

}
