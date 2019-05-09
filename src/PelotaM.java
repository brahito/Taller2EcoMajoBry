import processing.core.PApplet;

public class PelotaM extends Pelota {

	public PelotaM(PApplet app, float x, float y) {
		super(app, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {
		app.stroke(0);
		app.strokeWeight(2);
		app.pushMatrix();
		app.translate(posicion.x, posicion.y);
		app.fill(200, 200, 200);
		app.ellipse(0, 0, r * 2, r * 2);
		app.popMatrix();
	}

}
