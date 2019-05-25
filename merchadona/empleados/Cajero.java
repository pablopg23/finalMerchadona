package merchadona.empleados;

import merchadona.Merchadona;

public class Cajero extends Empleado {

	// Atributos

	private float total_ventas;

	// Metodos

	public Cajero(String nombre, int hash) {
		// TODO Auto-generated constructor stub
		super(nombre, hash);
		total_ventas = 0;
	}

	public boolean aniadirProducto(int numeroProd, int cantidad) {

		if (Merchadona.productos.get(numeroProd).getCantidad() < cantidad) {
			System.out.println("No hay suficientes, avise a un reponedor");
			return false;
		} else {
			if (Merchadona.productos.get(numeroProd).getPrecio() > 0) {
				this.total_ventas += Merchadona.productos.get(numeroProd).getPrecio();
				System.out.println("El producto se ha aniadido correctamente");
				// La cantidad se va restando seg�n se vende, no hay una memoria de productos.
				Merchadona.productos.get(numeroProd).restarCantidad(cantidad);
				return true;
			} else {
				System.out.println("Este producto no se puede vender");
				return false;
			}
		}

	}

	public float getTotal_ventas() {
		return total_ventas;
	}

	public void setTotal_ventas(float total_ventas) {
		this.total_ventas = total_ventas;
	}

}
