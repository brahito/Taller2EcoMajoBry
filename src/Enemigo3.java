import processing.core.PApplet;

public class Enemigo3 extends Obstaculo {

	public Enemigo3(PApplet app,int x, int y) {
		super(app,  x, y);
		imagen = app.loadImage("profe3.png");
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
