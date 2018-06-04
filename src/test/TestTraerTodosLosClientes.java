package test;
import java.util.ArrayList;
import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerTodosLosClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteABM ABM = new ClienteABM();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes = ABM.traerCliente();
		
		for(Cliente c : clientes){
			System.out.println(c.toString());
		}
	}

}
