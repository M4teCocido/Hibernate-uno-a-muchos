package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) throws Exception{
		String apellido = "Hernandez";
		String nombre = "Rodrigo";
		int dni = 31026186;
		GregorianCalendar fechaDeNacimiento = new GregorianCalendar(1984, 5, 06);
		
		ClienteABM abm = new ClienteABM();
		
		long ultimoIdCliente = abm.agregar(apellido, nombre, dni, fechaDeNacimiento);
		
		System.out.println(ultimoIdCliente);	
	}

}
