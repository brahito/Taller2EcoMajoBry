import processing.core.PApplet;

public class Enemigo2 extends Obstaculo {

	public Enemigo2(PApplet app,int x, int y) {
		super(app,  x, y);
		imagen = app.loadImage("profe2.png");
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
