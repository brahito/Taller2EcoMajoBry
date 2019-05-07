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

	public abstract void mover();

}
