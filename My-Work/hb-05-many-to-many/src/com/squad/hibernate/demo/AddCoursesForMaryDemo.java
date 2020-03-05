package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Review;
import com.squad.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)								 
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get the student mary from database
			Student mary = session.get(Student.class, 6);
			System.out.println("\nLoaded mary: "+mary);
			System.out.println("his courses: "+ mary.getCourses()+"\n");
			
			// create more courses
			Course courseOne = new Course("Rubik's Cube - How to speed Cube");
			Course courseTwo = new Course("Atari 2600 - Game Development");		
			
			// add student to courses
			courseOne.addStudent(mary);
			courseTwo.addStudent(mary);
			session.save(courseOne);
			session.save(courseTwo);
			
			// save the courses
			session.save(courseOne);
			session.save(courseTwo);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
