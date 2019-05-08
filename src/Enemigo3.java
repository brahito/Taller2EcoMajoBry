import processing.core.PApplet;

public class Enemigo3 extends Obstaculo {

	public Enemigo3(int x, int y, PApplet app) {
		super(x, y, app);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintar() {
		app.fill(0, 255, 0);
		app.ellipse(x, y, 50, 50);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
