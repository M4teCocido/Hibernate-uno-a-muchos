package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();
	
	public Cliente traerCliente(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		if(c == null) throw new Exception ("No existe un cliente con ID: " + idCliente + ". Saludos!");
		return c;
	}
	
	public Cliente traerCliente(int dni) throws Exception {
		Cliente c = dao.traerCliente(dni);
		if(c == null) throw new Exception("No existe un cliente con DNI: " + dni + ". Saludos!");
		return c;
	}
	
	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento)throws Exception {
		if(dao.traerCliente(dni) != null) throw new Exception("Ya existe un cliente con DNI: " + dni);
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}
	
	public void modificar(Cliente c) throws Exception {
		Cliente cAux = dao.traerCliente(c.getDni());
		if(cAux != null && cAux.getIdCliente() != c.getIdCliente())throw new Exception("Ya existe un cliente con el DNI: " + c.getDni());
		dao.actualizar(c);
	}
	
	public void eliminar(long idCliente) throws Exception{
		Cliente c = dao.traerCliente(idCliente);
		if(c == null) throw new Exception("El cliente con ID: " + idCliente + " no existe. Saludos!");
		dao.eliminar(c);
	}
	
	public List<Cliente> traerCliente(){
		return dao.traerCliente();
	}
	
	public Cliente traerClienteYPrestamos(long idCliente) {
		return dao.traerClienteYPrestamos(idCliente);
	}
	
}
