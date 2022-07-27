import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snow extends JPanel implements ActionListener{

	JButton star = new JButton(); //Control the snow
	AudioClip clip = null;
	URL url = null;
	JLabel snowy;
	boolean play = true;
	private final int Width;
	
	public Snow(int layer) {
		/* Play the BGM*/
		url = this.getClass().getResource("/sources/music.wav");
		clip = Applet.newAudioClip(url);
		clip.loop();
		
		/* Calculate the relevant parameters and timer*/
		Width = (layer*4+3) * 17 + 150;
		
		/* Create the snow button*/
		URL imgUrl = this.getClass().getResource("/sources/Star.png");
		ImageIcon icon = new ImageIcon(imgUrl);  //Size: 50*50
		star.setIcon(icon);
		star.setBorder(null);
		star.setContentAreaFilled(false);
		star.setBounds(Width/2-40, 15, 50, 50);
		//star.setBounds(0, 0, 50, 50);
		star.addActionListener(this);
		this.add(star);
		this.snowy();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (play) {
			snowy.setVisible(true);
		} else {
			snowy.setVisible(false);
		}
		
		play = !play;
	}
		
	private void snowy() { //Create the snow
		URL imgUrl = this.getClass().getResource("/sources/Snowy.gif");
		ImageIcon snow = new ImageIcon(imgUrl);
		snowy = new JLabel(snow);
		this.add(snowy);
		snowy.setVisible(false);
	}

}
