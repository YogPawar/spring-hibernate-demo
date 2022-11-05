package com.yogsoft.hibernate.demo;

import com.yogsoft.hibernate.entity.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

  public static void displayStudent(List<Student> studentList) {
    for (Student student : studentList) {
      System.out.println(student);
    }
  }

  public static void main(String[] args) {

    // create session factory
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();

    try {

      // create the student object
      Student theStudent = new Student("Yogesh", "Pawar", "yogesh.go.com");

      // start the transaction
      session.beginTransaction();

      //query student
      List<Student> studentList = session.createQuery("from student").list();
      displayStudent(studentList);

      System.out.println(
          "***********************************Single Filter***********************************************");
      studentList = session.createQuery("from student s where s.lastName= 'Pawar'")
          .getResultList();
      displayStudent(studentList);

      System.out.println(
          "***********************************Multiple Filters***********************************************");
      studentList = session.createQuery(
          "FROM student s WHERE s.firstName='Riyansh' AND lastName='Pawar'").getResultList();
      displayStudent(studentList);

      System.out.println(
          "*****************************LIKE Clause*****************************************************");
      studentList = session.createQuery("FROM student s WHERE s.email LIKE '%yogsoft%'")
          .getResultList();
      displayStudent(studentList);

      session.getTransaction().commit();
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
