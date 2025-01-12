package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
		public static void main(String args[])
		{
			StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure("Hibernate.cfg.xml").build();
			Metadata metadata=new MetadataSources(registry).getMetadataBuilder().build();
			SessionFactory factory=metadata.getSessionFactoryBuilder().build();
			Session session= factory.openSession();
			
			Student s1=new Student();
			s1.setName("varsha");
			s1.setEmail("varshaduggirala03@gmail.com");
			s1.setPassword("Varsha@123");
			
			Transaction tx=session.beginTransaction();
			session.save(s1);
			tx.commit();
			
			session.close();
			factory.close();
			
			System.out.println("Data Inserted Successfully"); 
			
			
		}
}