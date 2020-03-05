package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Review;
import com.squad.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Course course = new Course("Pacman - How To Score One million points");

			
			// save the course ... and everage the cascade all :-)
			System.out.println("\n Saving the course");
			session.save(course);
			System.out.println("Saved the course: "+course);
			
			//create the students
			Student studentOne = new Student("John", "Doe", "john@squad.com");
			Student studentTwo = new Student("Mary", "Public", "mary@squad.com");
			Student studentThree = new Student("Mushu", "Senjak", "mushu@squad.com");
			Student studentFour = new Student("Titi", "Glaçon", "titi@squad.com");
			
			// add students to the course
			course.addStudent(studentOne);
			course.addStudent(studentTwo);
			course.addStudent(studentThree);
			//course.addStudent(studentFour);
			
			// save the students
			System.out.println("\nSaving students ...");
			session.save(studentOne);
			session.save(studentTwo);
			session.save(studentThree);
			//session.save(studentFour);
			System.out.println("Students Saved");
			
			System.out.println("########################################");
			System.out.println("tring something");
			studentFour.addCourse(course);
			session.save(studentFour);
			System.out.println("End of trying");
			System.out.println("########################################");
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
