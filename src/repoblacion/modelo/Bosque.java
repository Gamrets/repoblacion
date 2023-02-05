package repoblacion.modelo;

import java.util.Random;

public class Bosque {
	
	public static final int MAX_ALTURA = 500;
	public static final int MINIMO = 10;
	public static final int MAX_ANCHURA= 1000;
	public static final int MAX_ESPECIES = 4;
	
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador;
	private int ancho;
	private int alto;
	
	private Arbol[] arboles;
	
	public Bosque(int ancho,int alto, int poblacion) {
		
		setAncho(ancho);
		setAlto(alto);
		
		
	}
	
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		
		if(MINIMO < 10 || ancho > MAX_ANCHURA) {
			
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
	
	
	
	public void checkPoblacion(int poblacion) {

		int perimetro = ancho * 2 + alto * 2;
		
		if (poblacion > perimetro) {
			throw new IllegalArgumentException("ERROR: La población no puede superar el perímetro del bosque.");
		}
	}
	

}
