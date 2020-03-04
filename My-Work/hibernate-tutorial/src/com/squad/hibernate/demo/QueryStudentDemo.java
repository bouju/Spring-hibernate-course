package com.squad.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2); // Actually John Doe
			
			// update first name to "Scoody"
			student.setFirstName("John");
			session.getTransaction().commit();
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// update email for all students to foo@squad.com
			session.createQuery("update Student set email='fooo@squad.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
