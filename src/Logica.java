import java.util.ArrayList;

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
	private boolean moverFlecha, aplicarFuerza;
	private float moverAngulo;
	private int nivel;
	private int intentos;
	private int objetivos;
	private ArrayList<Aro> aros;
	private ArrayList<Obstaculo> obstaculos;
	private boolean cancelarGeneracion;
	private float tamaño, sumarTamaño;

	public Logica(PApplet app) {
		this.app = app;
		gravedad = 0.163f;
		posicion = new PVector(100, 300);
		pelotita = new PelotaG(app, posicion.x - 10, posicion.y);
		x = 100;
		y = 100;
		velY = 5;
		velX = 5;
		moverFlecha = true;
		aplicarFuerza = false;
		moverAngulo = 0.05f;
		nivel = 1;
		intentos = 5;
		aros = new ArrayList<Aro>();
		obstaculos = new ArrayList<Obstaculo>();
		cancelarGeneracion = true;
		tamaño = 0;
		sumarTamaño += 1;
	}

	public void ejecutar() {
		app.pushMatrix();
		app.translate(posicion.x, posicion.y);
		app.rotate(angulo);
		app.strokeWeight(2);
		app.fill(0);
		app.rect(0, -5, 50, 10);
		app.popMatrix();
		System.out.println("objetivos: " + objetivos + " intentos: " + intentos + " nivel: " + nivel);
		if (disparar) {
			PVector gravity = new PVector((float) 0.2, (float) 0.2);
			pelotita.applyForce(gravity);
			pelotita.update();
		}
		pelotita.pintar();

		switch (nivel) {
		case 1:
			if (aros.size() < 1 && cancelarGeneracion == true) {
				aros.add(new Aro(app, app.width / 2, app.height / 2));
			}
			break;
		case 2:
			if (aros.size() < 3 && cancelarGeneracion == true) {
				aros.add(new Aro(app, (app.width / 2) - 100, 450));
				aros.add(new Aro(app, app.width / 2, 300));
				aros.add(new Aro(app, 680, 350));
			}
			break;
		}
		for (int i = 0; i < aros.size(); i++) {
			aros.get(i).pintar();
			if (pelotita.validarAro(aros.get(i)) == true)
				aros.remove(i);
		}
		if (pelotita.posicion.y > app.height) {
			pelotita = new PelotaG(app, posicion.x - 10, posicion.y);
			disparar = false;
			moverFlecha = true;
		}
		objetivos = aros.size();
		if (objetivos == 0) {
			nivel += 1;
			intentos = 5 + aros.size();
			cancelarGeneracion = true;
		}
		if (moverFlecha == true) {
			angulo += moverAngulo;
		}
		if (angulo > 1.3f) {
			moverAngulo *= -1;
		} else if (angulo < -1.3f)
			moverAngulo *= -1;
		if (aplicarFuerza == true) {
			app.fill(0);
			app.rect(pelotita.getX() - 40, pelotita.getY() - 30, tamaño, 15);
			tamaño += sumarTamaño;
		}
		if (tamaño < 0)
			sumarTamaño *= -1;
		if (tamaño > 100)
			sumarTamaño *= -1;
	}

	public void tecla() {
		if (app.key == ' ' && moverFlecha == true && aplicarFuerza == false) {
			moverFlecha = false;
			aplicarFuerza = true;
		} else if (app.key == ' ' && aplicarFuerza == true && moverFlecha == false) {
			aplicarFuerza = false;
			disparar = true;
			intentos -= 1;
			cancelarGeneracion = false;
			PVector force = PVector.fromAngle(angulo);
			force.mult(10);
			pelotita.applyForce(force);
		}
	}
}
