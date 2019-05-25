package merchadona;

import merchadona.empleados.Cajero;

public class Caja {

	// Atributos
	private Cajero empleado;
	private double precioTotalCompra;

	// Metodos

	public Caja(Cajero cajero) {
		this.empleado = cajero;
		precioTotalCompra = 0.0;
	}

	public void vender() {
		precioTotalCompra = 0.0;
		int numeroProd;
		int cantidad;
		System.out.println("Aniada un producto escribiendo su" + " numero (0 para salir)-Caja");
		Merchadona.listarProductos();
		numeroProd = Merchadona.sc.nextInt() - 1;

		while (numeroProd >= 0) {
			System.out.println("Has elegido: " + Merchadona.productos.get(numeroProd).getNombre());
			System.out.println("�Cuantos va a comprar?");
			cantidad = Merchadona.sc.nextInt();

			if (empleado.aniadirProducto(numeroProd, cantidad)) {
				precioTotalCompra += Merchadona.productos.get(numeroProd).getPrecio() * cantidad;
			}

			System.out.println("La compra asciende a: " + Merchadona.df.format(precioTotalCompra));

			System.out.println("Aniada un producto escribiendo su" + " numero (0 para salir)-caja");
			Merchadona.listarProductos();
			numeroProd = Merchadona.sc.nextInt() - 1;

		}

	}
}
