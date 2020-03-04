package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			Student student = session.get(Student.class, 1);
			
			// delete the student
			if(student != null) {
				session.delete(student);
			}

			
			//commit transaction
			session.getTransaction().commit();
			
			// query to delete
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=3").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		} finally {
			factory.close();
		}

	}

}
