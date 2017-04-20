import javax.swing.*;
import java.util.Timer;
import java.awt.*;

public class SpringApplet extends JApplet {

	private static final long serialVersionUID = 1L;
	//pola do przechowywania obiektow
	private SimEngine engine;
	private SimTask task;
	private Timer time;
	//przeciazona metoda init()
	public void init(){
		//utworzenie obiektow i uruchomienie timera
		engine = new SimEngine(0.7,0.9,0.4,3,0,1,0.2,9.81,0,0);
		task = new SimTask(0.1,engine,this);
		time = new Timer();
		time.scheduleAtFixedRate(task,50,50); 
		}     
	
	//przeciazona metoda paint()
	public void paint (Graphics g){
		//wyczyszczenie appletu
		g.clearRect(0, 0, getWidth(), getHeight());
		//narysowanie lini sprezyny
		g.setColor(Color.BLUE);
		g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight()/2-50+(int)engine.wektor.x);
		//narysowanie owalu dla masy
		g.setColor(Color.BLACK);
		g.drawOval(getWidth()/2-50, getHeight()/2-50+(int)engine.wektor.x, 100, 100);

	}
}
