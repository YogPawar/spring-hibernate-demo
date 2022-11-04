package com.yogsoft.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yogsoft.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the student object
			Student theStudent = new Student("Riyansh", "Pawar", "riyansh.go.com");

			// start the transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Save the student into DB");
			session.save(theStudent);
			// commit transaction
			
			//retrieve the student from 
			
			session.getTransaction().commit();
			System.out.println("Data saved into DB");
			
			 session = factory.getCurrentSession();
				session.beginTransaction();
			//find the primary key
			System.out.println("The Primery Key : " + theStudent.getId());
			
			Student temp = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get Student : " + temp);
			



		} catch (Exception exception) {
			exception.printStackTrace();
		}
		// create session

	}

}
