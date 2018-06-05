package test;

import java.util.GregorianCalendar;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PrestamoABM abm = new PrestamoABM();
		ClienteABM abmCli = new ClienteABM();
		
		long idCliente = 1;
		Cliente c = abmCli.traerCliente(idCliente);
		
		GregorianCalendar fecha = new GregorianCalendar(2018, 03, 13);
		int id = abm.agregar(fecha, 500.54d, 30.4d, 12, c);
		
		System.out.println("El id del nuevo prestamo es el: " + id);
	}

}
