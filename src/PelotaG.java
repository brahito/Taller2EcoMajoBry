import processing.core.PApplet;

public class PelotaG extends Pelota {

	public PelotaG(PApplet app, float x, float y) {
		super(app, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {
		app.stroke(0);
		app.strokeWeight(2);
		app.pushMatrix();
		app.translate(posicion.x, posicion.y);
		app.ellipse(0, 0, r * 2, r * 2);
		app.popMatrix();

	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
