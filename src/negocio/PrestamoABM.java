package negocio;

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
	
	public void eliminar() {
		
	}
}
