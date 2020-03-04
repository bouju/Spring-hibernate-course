package com.squad.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.squad.hibernate.demo.entity.Employee;
import com.squad.hibernate.demo.entity.Student;

public class ProjectEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a employee object
			System.out.println("Creating new employee object...");
			Employee employeeOne = new Employee("Mathis", "Bouju", "SQUAD");
			Employee employeeTwo = new Employee("Mathilde", "Juric", "ATOS");
			Employee employeeThree = new Employee("SUshi", "Dragon", "TWITCH");
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the employee...");
			System.out.println(employeeOne);
			session.save(employeeOne);
			session.save(employeeTwo);
			session.save(employeeThree);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: "+employeeOne.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+ employeeOne.getId());
			Employee employee = session.get(Employee.class, employeeOne.getId());
			
			System.out.println("Get complete: "+ employee);
			//commit transaction
			session.getTransaction().commit();
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// query from a company
			System.out.println("Get employee from SQUAD...");
			List<Employee> employees = session.createQuery("from Employee where company='SQUAD'").getResultList();
			displayEmployees(employees);
			session.getTransaction().commit();
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete 
			System.out.println("Delete Sushi Dragon");
			session.createQuery("delete from Employee where id ="+employeeThree.getId()).executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done !");
			
		} finally {
			factory.close();
		}

	}
	
	private static void displayEmployees(List<Employee> employees) {
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}

}
