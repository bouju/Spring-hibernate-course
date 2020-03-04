package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			// create the object
			Instructor instructor = 
					new Instructor("Mushu", "Senjak", "mbouju@squad.fr", null);
			
			InstructorDetail instructorDetail =
					new InstructorDetail("ytube.com", "Poney");
			
			//associate the object
			instructor.setInstructorDetail(instructorDetail);
			
			
			// start a transaction
			session.beginTransaction();

			// save the instructor
			// note: this will ALSO save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
