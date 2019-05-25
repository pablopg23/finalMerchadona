package merchadona.empleados;

import merchadona.Merchadona;

public class Reponedor extends Empleado {

	// Metodos

	public Reponedor(String nombre, int hash) {
		// TODO Auto-generated constructor stub
		super(nombre, hash);
	}

	public void reponerProductos() {
		int numeroProd;
		int cantidad;

		System.out.println("Elija un producto escribiendo su" + " numero (0 para salir) - Reponer");
		Merchadona.listarProductos();
		numeroProd = Merchadona.sc.nextInt() - 1;

		while (numeroProd >= 0) {
			System.out.println("Has elegido: " + Merchadona.productos.get(numeroProd).getNombre());
			System.out.println("�Cuantos va a reponer?");
			cantidad = Merchadona.sc.nextInt();

			Merchadona.productos.get(numeroProd).aniadirCantidad(cantidad);

			System.out.println("Elija un producto escribiendo su" + " numero (0 para salir) - Reponer");
			Merchadona.listarProductos();
			numeroProd = Merchadona.sc.nextInt() - 1;

		}

	}

}
