package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	
	PrestamoDao dao = new PrestamoDao();
	
	public Prestamo traerPrestamo(long idPrestamo)throws Exception {
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if(p == null) throw new Exception("El prestamo que esta buscando no existe.");
		return p;
	}
	
	public List<Prestamo> traerPrestamos(Cliente c){
		return dao.traerPrestamo(c);
	}
	
	public void eliminar(long idPrestamo)throws Exception {
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if(p == null) throw new Exception("El prestamo que desea eliminar no existe.");
		dao.eliminar(p);
	}
	
	public void modificar(Prestamo p) {
		dao.actualizar(p);
	}
	
	public int agregar(GregorianCalendar fecha, double monto, double interes, int cuotas, Cliente c) {
		Prestamo p = new Prestamo(fecha, monto, interes, cuotas, c);
		return dao.agregar(p);
	}
}
