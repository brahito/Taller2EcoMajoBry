import processing.core.PApplet;

public abstract class Obstaculo {
	protected PApplet app;
	protected int x, y;

	public Obstaculo(int x, int y, PApplet app) {
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
