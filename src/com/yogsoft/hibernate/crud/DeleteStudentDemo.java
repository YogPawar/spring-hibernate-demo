package com.yogsoft.hibernate.crud;

import com.yogsoft.hibernate.entity.Student;
import javax.swing.plaf.synth.SynthToolTipUI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();

    try {

      session.beginTransaction();
      int studId = 1;

      Student student = session.get(Student.class, studId);

      session.delete(student);

      session.getTransaction().commit();

      System.out.println("Delete using createQuery method");

      session = factory.getCurrentSession();
      session.beginTransaction();

      session.createQuery("DELETE FROM student WHERE first_name = 'Rajesh'").executeUpdate();
      session.getTransaction().commit();


    } catch (Exception exception) {
      exception.printStackTrace();
    }
    // create session

  }

}
