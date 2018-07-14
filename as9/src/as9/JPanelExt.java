package as9;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelExt extends JPanel implements Runnable {
	private boolean moving=false;
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public int getxCoor() {
		return xCoor;
	}
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}
	public int getxInc() {
		return xInc;
	}
	public long getSlpTime() {
		return slpTime;
	}
	public void setSlpTime(long slpTime) {
		this.slpTime = slpTime;
	}
	public boolean isDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public void setxInc(int xInc) {
		this.xInc = xInc;
	}
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	private int xCoor=0;
	private int xInc=10;
	private long slpTime=10;
	private boolean direction=true;
	private String ticker="AAFLA";
	private double price=0;
	public JPanelExt() {
		Thread t = new Thread (this);
		t.start();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int hite = this.getHeight()/2;
		g.drawString(ticker+""+price,xCoor,hite);
	}
	@Override
	public void run() {
		while (true) {
			if (moving) {
				if (direction) {
					xCoor=xCoor+xInc;
					if (xCoor >= this.getWidth())
						xCoor=0;
				}
				else {
					xCoor=xCoor-xInc;
					if (xCoor <= 0)
						xCoor=this.getWidth();
				}
				this.repaint();
			}
			try {
				Thread.sleep(50);
		} catch (InterruptedException e)	{
			e.printStackTrace();
		}
		}
	}
	
}
