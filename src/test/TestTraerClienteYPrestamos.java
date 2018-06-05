package test;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;

public class TestTraerClienteYPrestamos {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		long idCliente = 1;
		ClienteABM abm = new ClienteABM();
		
		Cliente c = abm.traerClienteYPrestamos(idCliente);
		System.out.println("\n----> Traer Cliente y prestamos idCliente: " + idCliente);
		System.out.println("\n" + c);
		for(Prestamo o : c.getPrestamos()) System.out.println("\n->" + o);
	}

}
