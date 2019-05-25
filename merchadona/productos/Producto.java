package merchadona.productos;

public class Producto {
	// Atributos

	int cantidad;
	private String nombre;
	double precio;

	// Metodos

	public Producto(String nombre, double precio) {
		this.cantidad = 0;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void aniadirCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

	public void restarCantidad(int cantidad) {
		if (this.cantidad > 0) {
			this.cantidad -= cantidad;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

}
