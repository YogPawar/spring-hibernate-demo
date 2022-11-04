package com.yogsoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yogsoft.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the student object
			Student theStudent = new Student("Yogesh", "Pawar", "yogesh.go.com");

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
