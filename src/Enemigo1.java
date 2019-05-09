import processing.core.PApplet;

public class Enemigo1 extends Obstaculo {

	public Enemigo1(PApplet app,int x, int y) {
		super(app, x, y);
		imagen = app.loadImage("profe1.png");
	}

	@Override
	public void pintar() {
		app.fill(255, 0, 0);
		app.ellipse(x, y, 50, 50);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
