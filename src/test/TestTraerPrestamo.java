package test;

import java.util.List;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		PrestamoABM abm = new PrestamoABM();
		ClienteABM abmCli = new ClienteABM();
		int dni = 13597534;
		long idPrestamo = 1;
		
		System.out.println("----->Traer prestamo con id: " + idPrestamo);
		
		Prestamo p = abm.traerPrestamo(idPrestamo);
		
		if(p.getCliente() == null) System.out.println("\n-------->El siguiente prestamo no posee un Cliente!!! CAOS!");
		System.out.println(p + "\nPertenece a : " + p.getCliente().toString());
		
		Cliente c = abmCli.traerCliente(dni);
		System.out.println("\n---------------->Prestamos del Cliente: " + c);
		List<Prestamo> prestamos = abm.traerPrestamos(c);
		if(prestamos == null) throw new Exception("\n------------->El cliente no posee ningun prestamo.");
		for(Prestamo o : prestamos) System.out.println(o + "\n------------->Pertenece a : " + o.getCliente().toString());

	}

}
