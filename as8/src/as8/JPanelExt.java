package as8;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class JPanelExt extends JPanel implements Runnable {

	private int xCoor=0;
	private int yCoor=50;
	private boolean moving = false;
	public JPanelExt() {
		setBackground(Color.CYAN);
		Thread t1 = new Thread (this);
		t1.start();

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Hello", xCoor, yCoor);
	}
	public void setMoving (boolean m) {
		moving = m;
	}
	@Override
	public void run() {
		
		while(true) {
			if (moving) {
				xCoor=xCoor+20+10; 
				if (xCoor >= this.getWidth()) {
					xCoor=0;
				}
			}
		repaint();
			
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
}