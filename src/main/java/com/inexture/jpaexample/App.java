package com.inexture.jpaexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
		EntityManager em = emf.createEntityManager();

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("jpaconfig.xml");

//		Student s1 = (Student) context.getBean("student");
//		s1.setName("yash");
//		s1.setCity("ahmedabad");
//
//		Address a1 = (Address) context.getBean("address");
//		a1.setHome("107");
//		a1.setCountry("india");
//		s1.setAddress(a1);

//		em.getTransaction().begin();
//		em.persist(s1);
//		em.persist(a1);
//		em.getTransaction().commit();
		
		Student s2 = em.find(Student.class, 1);
		System.out.println(s2);
		s2.setName("Defg");
		
		em.getTransaction().begin();
		
		Student s3 = em.find(Student.class, 11);
		em.remove(s3);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		
	}
}
