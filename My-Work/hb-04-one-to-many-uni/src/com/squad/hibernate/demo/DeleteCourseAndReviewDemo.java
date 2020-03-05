package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Review;
import com.squad.hibernate.demo.entity.Student;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get the course
			Course course = session.get(Course.class, 10);
			
			
			// print the course
			System.out.println("Deleting the course...");
			System.out.println(course);
			
			// delete the course
			session.delete(course);
			
			// print the course reviews
			System.out.println(course.getReviews());
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
