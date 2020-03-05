package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);

			

			if (instructorDetail!= null) {
				// print the instructor detail
				System.out.println("Found instructor detail: " + instructorDetail);

				// print the assciated instructor
				System.out.println("The associated instructor: "+ instructorDetail.getInstructor());
				
				// now let's detlete the instructor detail
				System.out.println("Deleting InstructorDetail: "+ instructorDetail);
				session.delete(instructorDetail);
				
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
