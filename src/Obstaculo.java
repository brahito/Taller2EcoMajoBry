import processing.core.PApplet;
import processing.core.PImage;

public abstract class Obstaculo {
	protected PApplet app;
	protected int x, y;
	protected PImage imagen;

	public Obstaculo(PApplet app, int x, int y) {
		this.x = x;
		this.y = y;
		this.app = app;
	}

	public abstract void pintar();

	public abstract void mover();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
