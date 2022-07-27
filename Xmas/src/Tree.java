import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Tree extends JPanel implements ActionListener{
	
	private int x;
	private int y;
	private int[] range;
	private int endY;
	private final int layer;
	private boolean change = false;
	Timer time;
	private ArrayList<Integer> colours = new ArrayList<Integer>();
	
	public Tree(int layer, ArrayList<Integer> cs) {
		this.layer = layer; //the number of layer should be between 5 and 10 is better.
		this.colours.addAll(cs);
		this.setLayout(null);
		range = new int[layer *8];
		time = new Timer(300, this);
		time.start();
	}
	
	public void paintComponent(Graphics g) {
		//super.paint(g);
		this.drawLeafs(g);
		this.drawRoot(g);
		if (change) {
			this.drawBalls(g, 0);
		} else {
			this.drawBalls(g, 1);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		change = !change;
	}
	
	private void drawLeafs(Graphics g) {
		x = 50;
		y = 50;
		int maxLeafs = layer*4 + 3;
		int leaf = 1;
		int pos = maxLeafs/2 + 1;
		int index = 0;
		
		for (int i = 0; i < layer; i++) {
			for (int j = 0; j < 4; j++) {
				x = x + 17 * pos; //Find the start position
				range[index] = x; //Record the start position of this line
				index++;

				for (int k = 0; k < leaf; k++) {
					g.setColor(new Color(colours.get(3), colours.get(4), colours.get(5))); //Draw the leafs
					g.fillRect(x, y, 15, 15);
					g.setColor(new Color(colours.get(0), colours.get(1), colours.get(2))); //Fill the space
					g.fillRect(x+15, y, 2, 15);
					g.fillRect(x, y+15, 17, 2);
					x += 17;
				}
				
				range[index] = x; //Record the end position of this line
				index++;
				leaf += 2; //The number of leafs will increase by 2 for each line
				pos --;
				x = 50;
				y += 17;
			}
			leaf -= 4;
			pos += 2;
		}
		endY = y;
	}

	private void drawRoot(Graphics g) {
		x = 50;
		y = endY;
		
		for (int i = 0; i < 3; i++) {
			x = x + 17*(layer + 2);
			g.setColor(new Color(colours.get(6), colours.get(7), colours.get(8)));
			for (int j = 0; j < (2*layer+1); j++) {
				g.fillRect(x, y, 15, 15);
				x += 17;
			}
			
			x = 50;
			y += 17;
		}
	}
	
	private void drawBalls(Graphics g, int init) { //Set the first ball's colour
		Color[] colors = {new Color(0, 0, 0, 0), new Color(colours.get(9), colours.get(10), colours.get(11))};
		int lights = 3;
		int winding = 15;
		for (int i = 0; i < layer-2; i++) {
			/* Calculate the corresponding x range*/
			int line = i*4 + 6;
			int xStart = range[line * 2];
			int xEnd = range[line*2 + 1];
			int range = (xEnd - xStart) / lights;
			int xpos = xStart + 10;
			int ypos = 50 + line * 17;
			
			/*Start to draw the lights*/
			for (int j = 0; j < lights/2 + 1; j++) {
				g.setColor(colors[init % 2]);
				g.fillOval(xpos, ypos, 23, 23);
				init++;
				xpos += range;
				ypos += winding;
			}
			ypos -= 2*winding;
			for (int j = lights/2 + 1; j < lights; j++) {
				g.setColor(colors[init % 2]);
				g.fillOval(xpos, ypos, 23, 23);
				init++;
				xpos += range;
				ypos -= winding;
			}
			lights+=2;
			winding--;
		}
	}
	/*
	private void present(Graphics g,int xpos, int ypos, int size) { //decoration for the Xmas Tree can be around 20
		//Draw the box
		g.setColor(Color.blue);
		g.fillRect(xpos, ypos, size, size);
		// Draw the ribbon
		g.setColor(Color.red);
		g.fillRect(xpos, ypos+(size-size/4)/2, size, size/4);
		g.fillRect(xpos+(size-size/4)/2, ypos, size/4, size);
		// Draw the bowknot
		int[] xpoints = {xpos, xpos+size/10, xpos+size, xpos+size-size/10};
		int[] ypoints = {ypos-ypos/20, ypos+ypos/50, ypos-ypos/20, ypos+ypos/50};
		g.fillPolygon(xpoints, ypoints, 4);
	}
	*/
}
