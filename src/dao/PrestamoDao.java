package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
import datos.Prestamo;

public class PrestamoDao {
	private static Session session;
	private Transaction tx;
	
	private void  iniciaOperacion()throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaException(HibernateException he) {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos: " + he);
	}
	
	public int agregar(Prestamo objeto)throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he){
			manejaException(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Prestamo p)throws HibernateException {
		try {
			iniciaOperacion();
			session.save(p);
			tx.commit();
		}catch(HibernateException he) {
			manejaException(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Prestamo p) {
		try {
			iniciaOperacion();
			session.delete(p);
			tx.commit();
		}catch(HibernateException he) {
			manejaException(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public Prestamo traerPrestamo(long idPrestamo) {
		Prestamo objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo p inner join fetch p.cliente c where p.idPrestamo = " + idPrestamo;
			objeto = (Prestamo) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings ("unchecked")
	public List<Prestamo> traerPrestamo(Cliente c) {
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo p inner join fetch p.cliente c where c.idCliente = " + c.getIdCliente();
			lista = session.createQuery(hql).list();
		}finally {
			session.close();
		}
		
		return lista;
	}
	
	
	
}
