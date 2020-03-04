package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Student;

public class EagerLazyDemo {

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
			System.out.println("squad: Instructor: "+instructor);
			
			// get course for the instructor
			System.out.println("squad: Courses" + instructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("squad: Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
