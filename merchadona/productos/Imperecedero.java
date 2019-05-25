package merchadona.productos;

public class Imperecedero extends Producto {

	// Atributos

	// No tiene atributos específicos

	// Metodos

	/**
	 * @param nombre
	 * @param precio
	 */
	public Imperecedero(String nombre, double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}

	public void aniadirCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

}
