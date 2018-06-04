package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;

import org.hibernate.HibernateException;

public class TestAgregarCliente {

	public static void main(String[] args)throws HibernateException {
		String apellido = "Hernandez";
		String nombre = "Jorge";
		int dni = 13597534;
		GregorianCalendar fechaDeNacimiento = new GregorianCalendar(1984, 5, 06);
		
		ClienteABM abm = new ClienteABM();
		
		long ultimoIdCliente = abm.agregar(apellido, nombre, dni, fechaDeNacimiento);
		
		System.out.println(ultimoIdCliente);	
	}

}
