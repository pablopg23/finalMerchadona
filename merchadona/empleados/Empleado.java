
package merchadona.empleados;

import merchadona.Merchadona;
import merchadona.productos.*;

public class Empleado {

	// Atributos

	String nombre;
	public int hash;

	// Métodos

	public Empleado(String nombre, int hash) {
		this.nombre = nombre;
		this.hash = hash;
	}

	public boolean altaEmpleado(String nombre, String tipo) {
		char comp = tipo.toLowerCase().charAt(0);
		int tamanio = Merchadona.empleados.size() + 1;

		if (this.hash == 1) {
			if (comp == 'c') {
				Merchadona.empleados.put(tamanio, new Cajero(nombre, tamanio));
				return true;
			} else if (comp == 'r') {
				Merchadona.empleados.put(tamanio, new Reponedor(nombre, tamanio));
				return true;
			} else {
				System.out.println("Tiene que ser un empleado valido");
				return false;
			}

		} else {
			System.out.println("Este empleado no tiene permisos");
			return false;
		}

	}

	public boolean altaProducto(String nombre, double precio, String tipo) {
		char comp = tipo.toLowerCase().charAt(0);
		if (this.hash == 1) {
			if (comp == 'p') {
				Merchadona.productos.add(new Perecedero(nombre, precio));
				return true;
			} else if (comp == 'i') {
				Merchadona.productos.add(new Imperecedero(nombre, precio));
				return true;
			} else {
				System.out.println("Tiene que ser un producto valido");
				return false;
			}
		} else {
			System.out.println("Este empleado no tiene permisos");
			return false;
		}
	}

	public void listarCajeros() {

		if (this.hash == 1) {
			// Se tiene que recorrer el array de empleados
			// Comprobar si la clase del V es cajero
			// En ese caso, se imprime el nombre y la cantidad
			for (int i = 1; i <= Merchadona.empleados.size(); i++) {
				Empleado empleadito = Merchadona.empleados.get(i);
				if (empleadito.getClass() == Cajero.class) {
					Cajero cajerito = (Cajero) empleadito;
					System.out.println(cajerito.nombre + " -- " + cajerito.getTotal_ventas());
				}
			}
		} else {
			System.out.println("Este empleado no tiene permisos");
		}
	}

	public void bajaProducto(int number) {
		if (this.hash == 1) {
			Merchadona.productos.remove(number);
		} else {
		}
	}

	public void bajaEmpleado(int number) {
		if (this.hash == 1) {
			Merchadona.empleados.remove(number);
		} else {
		}
	}

	@Override
	public String toString() {
		return this.getClass() + " [nombre=" + nombre + ", hash=" + hash + "]";
	}

}
