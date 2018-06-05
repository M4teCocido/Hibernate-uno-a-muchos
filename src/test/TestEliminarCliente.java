package test;

import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) throws Exception {
		ClienteABM abm = new ClienteABM();
		long id = 3;
		
		abm.eliminar(id);
		
		System.out.println("El cliente con el ID: " + id + " fue eliminado satisfactoriamente. Saludos!");
	}

}
