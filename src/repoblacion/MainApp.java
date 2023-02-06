package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {

	public static void main(String args[]) {

		Bosque bosque = null;

		int altura;
		int anchura;
		int poblacion;

		
		do {
			anchura = Consola.leerAnchura();
			altura = Consola.leerAltura();
			poblacion = Consola.leePoblacion();

			try {
				
				bosque = new Bosque(anchura, altura, poblacion);
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
			
		} while (bosque == null);

		bosque.realizarCalculos();

		System.out.println("El arbol mas cercano es " + bosque.getArbolMasCentrado().toString());
		System.out.println("El arbol mas alejado es " + bosque.getArbolMasAlejado().toString());
		
	}

}
