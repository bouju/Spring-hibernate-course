package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Student;

public class CreateCourseDemo {

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
			session.beginTransaction();

			// get the instructor from bd
			Instructor instructor = session.get(Instructor.class, 1);
			
			// create the object
			Course courseOne = new Course("Mathematic - one plus one");
			Course courseTwo = new Course("Esport - trainning of APM");
			Course courseThree = new Course("TrackMania - How to NeoDrift");
			
			//associate the object
			instructor.add(courseOne);
			instructor.add(courseTwo);
			instructor.add(courseThree);
			
			// save the courses
			session.save(courseOne);
			session.save(courseTwo);
			session.save(courseThree);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
