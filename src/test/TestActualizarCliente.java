package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {

	public static void main(String[] args) throws Exception{
		
		ClienteABM abm = new ClienteABM();
		long id = 2;
		
		Cliente c = abm.traerCliente(id);
		System.out.println("Cliente a modificar --> " + c);

		c.setDni(31026186);
		abm.modificar(c); 
		int dni = 31026186;
		Cliente cModif = abm.traerCliente(dni);
		System.out.println("Cliente modificado --> " + cModif);
	}

}
