package merchadona.productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.Timer;

public class Perecedero extends Producto {

	// Atributos

	LocalDateTime fechaRepo;
	private int contador;
	private Timer timer = new Timer(10000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (contador < 6) {
				precio -= (precio * 10 / 100);
				contador++;
			} else {
				precio = 0;
			}
		}
	});

	// Metodos

	public Perecedero(String nombre, double precio) {
		super(nombre, precio);
		fechaRepo = LocalDateTime.now();
		contador = 0;
		// TODO Auto-generated constructor stub
	}

	public void aniadirCantidad(int cantidad) {
		this.cantidad += cantidad;
		fechaRepo = LocalDateTime.now();
		timer.start();
	}

}
