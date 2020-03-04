package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.squad.hibernate.demo.entity.Course;
import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query with HQL

			// get the instructor from bd
			Query<Instructor> query =
					session.createQuery("select i from Instructor i "
								+ "JOIN FETCH i.courses "
								+ "where i.id=:instructorId ", 
							Instructor.class);
			
			// set parameter on query
			query.setParameter("instructorId", 1);
			
			//execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("squad: Instructor: "+instructor);

			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\nsquad: The session is now closed!\n");
			
			// get courses for the instructor
			System.out.println("squad: Courses: "+ instructor.getCourses());
			
			System.out.println("squad: Done !");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
