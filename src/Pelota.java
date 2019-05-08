import processing.core.PApplet;
import processing.core.PVector;

public abstract class Pelota {
	protected PVector posicion;
	protected PVector velocity;
	protected PVector acceleration;
	protected PApplet app;
	protected float r = 8;
	protected float topspeed = 10;

	public Pelota(PApplet app, float x, float y) {
		this.app = app;
		posicion = new PVector(x, y);
		velocity = new PVector();
		acceleration = new PVector();
	}

	public void update() {
		velocity.add(acceleration);
		velocity.limit(topspeed);
		posicion.add(velocity);
		acceleration.mult(0);
	}

	public void applyForce(PVector force) {
		acceleration.add(force);
	}

	public abstract void pintar();

	public boolean validarAro(Aro aro) {
		if (app.dist(posicion.x, posicion.y, aro.getX(), aro.getY()) < 25) {
			return true;
		}
		return false;
	}

	public boolean validarEnemigo(Obstaculo obstaculo) {
		if (app.dist(posicion.x, posicion.y, obstaculo.getX(), obstaculo.getY()) < 25) {
			return true;
		}
		return false;
	}

	public float getX() {
		return posicion.x;
	}

	public float getY() {
		return posicion.y;
	}
}
