import processing.core.PApplet;

public class Enemigo2 extends Obstaculo {

	public Enemigo2(int x, int y, PApplet app) {
		super(x, y, app);
	}

	@Override
	public void pintar() {
		app.fill(0, 0, 255);
		app.ellipse(x, y, 50, 50);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
