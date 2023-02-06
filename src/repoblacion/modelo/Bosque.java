package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

public class Bosque {

	public static final int MAX_ALTURA = 500;
	public static final int MINIMO = 10;
	public static final int MAX_ANCHURA = 1000;
	public static final int MAX_ESPECIES = 4;

	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador;
	private int ancho;
	private int alto;

	private Arbol[] arboles;

	// Aunque no lo ponga en diagrama de clases decedi crear un variable poblacion
	// para poder guardar valor poblacion recibido por constructor
	// Para despues usarlo en metodo duplicar bosque

	private int poblacion;

	public Bosque(int ancho, int alto, int poblacion) {

		setAncho(ancho);
		setAlto(alto);
		setPoblacion(poblacion);
		checkPoblacion(poblacion);
		arboles = new Arbol[poblacion];
		repoblar();
	}

	public int getAncho() {
		return ancho;
	}

	public void setPoblacion(int poblacion) {

		if (poblacion <= 1) {
			throw new IllegalArgumentException("ERROR: La población debe ser mayor que cero.");
		}

		this.poblacion = poblacion;
	}

	public void setAncho(int ancho) {

		if (MINIMO < 10 || ancho > MAX_ANCHURA) {

			throw new IllegalArgumentException("ERROR: Anchura no válida.");
		}

		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {

		if (alto < MINIMO || alto > MAX_ALTURA) {

			throw new IllegalArgumentException("ERROR: Altura no válida.");
		}

		this.alto = alto;
	}

	public void setArboles(Arbol[] arboles) {

		if (arboles != null)
			this.arboles = arboles;
	}

	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	public Arbol[] duplicaBosque() {

		Arbol[] copiaBosque = new Arbol[poblacion]; // creo una array de la misma capacidad que tiene array que voy a
		// copiar

		for (int i = 0; i < poblacion - 1; i++) { // voy recorriendo el array

			copiaBosque[i] = arboles[i]; // y le voy asignado valores que tiene array original

		}
		return copiaBosque;
	}

	public void checkPoblacion(int poblacion) {

		int perimetro = ancho * 2 + alto * 2;

		if (poblacion > perimetro) {
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
	}

	// He creado un metodo para generar especie aleatoria
	private Especie generarEspecieAleatoria() {

		// Especie especieAleatoria = null;

		// Generamos especie aleatoria
		int n = generador.nextInt(7) + 0;

		switch (n) {
			case 0:
				return Especie.ALAMO;

			case 1:
				return Especie.ENCINA;

			case 2:
				return Especie.CASTANO;

			case 3:
				return Especie.CIPRES;

			case 4:
				return Especie.PINO;

			case 5:
				return Especie.ROBLE;

			case 6:
				return Especie.OLIVO;

			default:
				return null;
		}
	}

	private void repoblar() {

		generador = new Random();

		double x = generador.nextDouble(-ancho / 2, ancho / 2);
		double y = generador.nextDouble(-alto / 2, alto / 2);

		Especie epecieAnterior;
		Especie especieAleatoria;

		boolean especieCompatible = false;

		for (int i = 0; i < arboles.length - 1; i++) {

			// obtenemos especia de posicion anterior

			if ((i - 1) >= 0) {

				epecieAnterior = arboles[(i - 1)].getEspecie();
			} else {
				epecieAnterior = null;
			}


			// Vamos generando una especie y comprobandola con anterior en caso de que sea incompatible repetimos el proceso y en caso contrario salimos del bicle
			do {

				especieAleatoria = generarEspecieAleatoria();

				if (especieAleatoria == Especie.ALAMO && (epecieAnterior == Especie.CASTANO
						|| epecieAnterior == Especie.CIPRES || epecieAnterior == Especie.OLIVO)) {

					especieCompatible = false;
				}

				if (especieAleatoria == Especie.OLIVO
						&& (epecieAnterior == Especie.ALAMO || epecieAnterior == Especie.ENCINA)) {

					especieCompatible = false;
				}

			} while (!especieCompatible);

			arboles[i] = new Arbol(especieAleatoria, new Posicion(x, y));

		}

	}


	public void realizarCalculos() {

		//Creo 2 arboeles de referencia el de centro y mas alejado del centro
		Posicion centro = new Posicion(0, 0);
		Posicion perimetro = new Posicion(1000, 500);
		Arbol arbolMasAlejadoReferenciado = new Arbol(Especie.ALAMO, centro);
		Arbol arbolMasCercanoReferenciado = new Arbol(Especie.ALAMO, perimetro);

		//Recorro todos arboles y comparo con mas centrado
		for (Arbol arbole : arboles) {

			try {
				if (arbole.getPosicion().distancia(centro) < arbolMasAlejadoReferenciado.getPosicion().distancia(centro)) {
					arbolMasCentrado = arbole;
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}

		//Recorro todos arboles y comparo con mas alejado
		for (Arbol arbole : arboles) {

			try {
				if (arbole.getPosicion().distancia(centro) > arbolMasCercanoReferenciado.getPosicion().distancia(perimetro)) {
					arbolMasAlejado = arbole;
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	@Override
	public String toString() {
		return "Bosque [ancho=" + ancho + ", alto=" + alto + ", arboles=" + Arrays.toString(arboles) + "]";
	}


}
