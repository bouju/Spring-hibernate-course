package com.squad.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Instructor;
import com.squad.hibernate.demo.entity.InstructorDetail;
import com.squad.hibernate.demo.entity.Student;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Instructor.class)
				 .addAnnotatedClass(InstructorDetail.class)
				 .buildSessionFactory();


		//create session
		Session session = factory.getCurrentSession();
		
		
		// create the objects
		Instructor instructor = new Instructor("Mushu", "Senjak", "mbouju@squad.com", null);
		InstructorDetail instructorDetail = new InstructorDetail("ytube.com", "Ponny");
		instructor.setInstructorDetail(instructorDetail);
		
		try {
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
