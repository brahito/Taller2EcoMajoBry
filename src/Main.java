import processing.core.PApplet;

public class Main extends PApplet {
	
	private Logica log;
	public static void main(String[] args) {
		PApplet.main("Main");
	}
	
	public void settings() {
		size(1200,700);
	}
	
	public void setup() {
		log = new Logica(this);	
	}
	
	public void draw() {
		background(255);
		log.ejecutar();
		smooth();
	}
	public void keyPressed() {
		log.lanzar();
		log.tecla();
	}

}
