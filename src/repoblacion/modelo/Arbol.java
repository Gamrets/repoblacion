package repoblacion.modelo;

public class Arbol {

	private Especie especie;
	private Posicion posicion;


	public Arbol(Especie especie, Posicion posicion) {
		setEspecie(especie);
		setPosicion(posicion);
	}


	public Arbol(Arbol arbol) {
		if (arbol == null) {
			throw new NullPointerException("ERROR: No se puede copiar un árbol nulo.");
		}
		this.especie = arbol.getEspecie();
		this.posicion = arbol.getPosicion();
	}


	public Especie getEspecie() {
		return especie;
	}

	private  void setEspecie(Especie especie) {

		if(especie == null) {

			throw new NullPointerException("ERROR: La especie no puede ser nula.");
		}

		this.especie = especie;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {

		if (posicion == null) {

			throw new NullPointerException("ERROR: La posición no puede ser nula.");
		}

		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "especie=" + especie + ", posicion=(" + posicion + ")";
	}

}
