package merchadona;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import merchadona.empleados.*;
import merchadona.productos.*;

public abstract class Merchadona {

	// Atributos

	public static DecimalFormat df = new DecimalFormat("#.00");

	public static Scanner sc = new Scanner(System.in);

	public static HashMap<Integer, Empleado> empleados = new HashMap<Integer, Empleado>();

	/*
	 * Array de cajas que tiene el Merchadona disponibles
	 */
	private static Caja[] cajas = new Caja[5];
	private static int cajasAbiertas = 0;

	public static LinkedList<Producto> productos = new LinkedList<Producto>();

	// Metodos

	public static void main(String[] args) {

		System.out.println("Aniadir empleado1");
		// Añadir el empleado 1
		empleados.put(1, new Empleado("Admin", 1));
		Empleado admin = empleados.get(1);
		// Dar de alta un cajero
		System.out.println("Dar de alta un cajero (Sandra)");
		admin.altaEmpleado("Sandrita", "cajero");
		System.out.println("Dar de alta empleado generico (Sale mal)");
		admin.altaEmpleado("Kawaii", "generico");

		System.out.println(empleados.toString());

		// Dar de alta un reponedor
		System.out.println("Dar de alta reponedor");
		admin.altaEmpleado("Laurita", "reponedora");
		// Dar de alta productos
		System.out.println("Dar de alta productos");
		admin.altaProducto("Huevos", 3.0, "perecedero");
		admin.altaProducto("Leche", 5, "perecedero");
		admin.altaProducto("Papel Higienico", 0.5, "imperecedero");
		admin.altaProducto("Oleeeee", 0.0, "oleee");
		admin.altaProducto("Espejo", 30.7, "imperecedero");

		System.out.println("Listar productos");
		listarProductos();
		System.out.println("Aniadir cantidad a los productos");
		for (int i = 0; i < productos.size(); i++) {
			Producto productito = productos.get(i);
			productito.aniadirCantidad(5);

		}

		System.out.println("Listar cajeros");
		admin.listarCajeros();

		// Abrir tres cajas
		System.out.println("Abrir caja");
		abrirCaja((Cajero) empleados.get(2));
		abrirCaja((Cajero) empleados.get(2));
		abrirCaja((Cajero) empleados.get(2));

		// Cerrar la caja 2
		System.out.println("Cerrar caja2");
		cerrarCaja();
		// Hacer una compra en la caja 1
		System.out.println("Vender desde la caja 1 (Sandra)");
		cajas[1].vender();
		// Reponer productos
		System.out.println("Reponer productos");
		Reponedor reponedorcito = (Reponedor) empleados.get(3);
		reponedorcito.reponerProductos();

		sc.close();

	}

	public static void abrirCaja(Cajero cajero) {
		// Comprobacion con CajasAbiertas

		cajas[cajasAbiertas] = new Caja(cajero);
		cajasAbiertas++;
	}

	public static void cerrarCaja() {

		// Comprobacion con CajasAbiertas

		cajas[cajasAbiertas] = null;
		cajasAbiertas--;
	}

	public static void listarProductos() {
		for (int i = 0; i < productos.size(); i++) {
			System.out.println(i + 1 + ". " + productos.get(i).getNombre() + " - "
					+ df.format(productos.get(i).getPrecio()) + " - " + productos.get(i).getCantidad());

		}
	}

	public static void mostrarPrecioProducto(Producto productito) {

		for (int j = 0; j < 4; j++) {
			System.out.println(productito.getPrecio());
			if (productito.getClass() == Perecedero.class) {
				try {
					Thread.sleep(11000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
