package repoblacion.modelo;

public class Posicion {

	private double x;
	private double y;

	public double getX() {
		return x;
	}

	private void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	private void setY(double y) {
		this.y = y;
	}

	public Posicion(double x, double y) {

		setX(x);
		setY(y);

	}

	public Posicion(Posicion posicion) {

		if (posicion == null) {
			throw new NullPointerException("ERROR: No se puede copiar una posición nula.");
		} else {
			setX(posicion.getX());
			setY(posicion.getY());
		}
	}

	public double distancia(Posicion posicion) {

		if (posicion == null) {

			throw new NullPointerException("ERROR: No se puede calcular la distancia a una posición nula.");
		}

		double posicionX1 = posicion.getX();
		double posicionY1 = posicion.getY();
		double posicionX2 = getX();
		double posicionY2 = getY();
		double X = posicionX2 - posicionX1;
		double Y = posicionY2 - posicionY1;
		double distancia = Math.sqrt(X * X + Y * Y);
		return distancia;

	}

	@Override
	public String toString() {
		return new String(String.format("x=%5.3f, y=%5.3f", x, y));
	}

}
