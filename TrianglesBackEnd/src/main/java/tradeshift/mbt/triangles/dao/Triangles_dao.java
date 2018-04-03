package tradeshift.mbt.triangles.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tradeshift.mbt.triangles.pojo.Triangles;

public class Triangles_dao {
	
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction transaction = null;
	
	public String getTriangleType_Side(Float sideA, Float sideB, Float sideC) {
		String res = null;
		if(sideA.equals(sideB) && sideA.equals(sideC)) {
			res =  "Equilateral";
		}else  if(sideA.equals(sideB) || sideA.equals(sideC) || sideB.equals(sideC) ) {
			res =  "Isosceles";
		} else if(!sideA.equals(sideB) && !sideA.equals(sideC) ) {
			res =  "Scalene";
		}
		return res;	
	}
	
	//Query to add triangle in DB
	public void addTriangle(Triangles triangle) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.save(triangle);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}	
}
