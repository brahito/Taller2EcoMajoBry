import processing.core.PApplet;
import processing.core.PVector;

public class Logica {
	private PApplet app;
	private float gravedad;
	private float x, y, velX, velY;
	private Pelota pelotita;
	private float angulo = -app.PI / 4;
	private PVector posicion;
	private boolean disparar = false;

	public Logica(PApplet app) {
		this.app = app;
		gravedad = 0.163f;
		posicion = new PVector(50, 300);
		pelotita = new PelotaG(app, posicion.x -10, posicion.y);
		x = 100;
		y = 100;
		velY = 5;
		velX = 5;
	}

	public void ejecutar() {
		app.pushMatrix();
		app.translate(posicion.x, posicion.y);
		app.rotate(angulo);
		app.rect(0, -5, 50, 10);
		app.popMatrix();

		if (disparar) {
			PVector gravity = new PVector((float) 0.2, (float) 0.2);
			pelotita.applyForce(gravity);
			pelotita.update();
		}
		pelotita.pintar();

		if (pelotita.posicion.y > app.height) {
			pelotita = new PelotaG(app, posicion.x -10, posicion.y);
			disparar = false;
		}
		angulo += 0.005;
		System.out.println(angulo);
	}

	public void lanzar() {

		if (app.key == app.CODED && app.keyCode == app.RIGHT) {
			angulo += 0.1;
		} else if (app.key == app.CODED && app.keyCode == app.LEFT) {
			angulo -= 0.1;
		} else if (app.key == ' ') {
			disparar = true;
			PVector force = PVector.fromAngle(angulo);
			force.mult(10);
			pelotita.applyForce(force);

		}

	}
}
