import processing.core.PApplet;

public class Aro {

	private PApplet app;
	private int x, y;

	public Aro(PApplet app, int x, int y) {
		this.app = app;
		this.x = x;
		this.y = y;
	}

	public void pintar() {
		app.stroke(255, 0, 255);
		app.strokeWeight(5);
		app.noFill();
		app.ellipse(x, y, 50, 50);
		app.noStroke();

		
	}

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
