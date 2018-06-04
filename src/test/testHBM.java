package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class testHBM {
	public static void main(String[] args) throws Exception{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
			
		session.beginTransaction();
		session.close();
		System.out.println("Hasta aca ok!");
	}
}
