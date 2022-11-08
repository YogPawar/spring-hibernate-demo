package com.yogsoft.hibernate.crud;

import com.yogsoft.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();

    try {
      int studentId = 1;
      session.beginTransaction();

      Student student = session.get(Student.class, studentId);
      System.out.println("Student Before Update" + student);
      student.setFistName("Yogesh Updated");
      session.getTransaction().commit();

      //update emial id
      session = factory.getCurrentSession();
      session.beginTransaction();
      System.out.println("Update student email id");
      session.createQuery("UPDATE student SET email='support@gmail.com'").executeUpdate();
      session.getTransaction().commit();

    } catch (Exception exception) {
      exception.printStackTrace();
    }
    // create session

  }

}
