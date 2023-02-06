package repoblacion.utilidades;

public class Consola {


	private  Consola() {

	}

	public static int leerAnchura() {

		int anchura;

		do {
			System.out.println("Intoducede la anchura del bosque: " );

			anchura = Entrada.entero();

		}
		while(anchura < 0 && anchura > 1000);
		return anchura;
	}


	public static int leerAltura() {

		int altura;

		do {
			System.out.println("Intoducede la altura del bosque: " );
			altura = Entrada.entero();

		}
		while(altura < 0 && altura > 500);
		return altura;
	}

	public static int leePoblacion() {


		int poblacion;

		do {System.out.println("Intoducede la poblacion de especies: " );
			poblacion = Entrada.entero();

		}
		while(poblacion < 0 && poblacion > (2*(1000+500)));
		return poblacion;
	}


}
