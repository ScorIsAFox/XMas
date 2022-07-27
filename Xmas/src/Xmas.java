import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Xmas extends JFrame implements ActionListener{
	
	private int Width, Height;
	private boolean submit = false;
	JLayeredPane lp = new JLayeredPane();
	JLabel ct;
	JButton button;
	JComboBox<Integer> layerSelected = new JComboBox<>(new MyComboBox());
	RGB p1, p2, p3, p4;
	ArrayList<Integer> colours = new ArrayList<Integer>();
	
	public Xmas() {
		this.setTitle("ºüÀê×ÓµÄÊ¥µ®Ê÷ÊÛÂôµê");
		URL iconUrl = this.getClass().getResource("/sources/tree.png");
		Image tree = Toolkit.getDefaultToolkit().getImage(iconUrl);
		this.setIconImage(tree);
		this.setLayout(null);
		this.setResizable(false); //Forbid changing the size of the frame
		this.setSize(800, 650);
		this.setLocationRelativeTo(null); //Put the window to the centre of the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*Set the background picture*/
		URL imgUrl = this.getClass().getResource("/sources/Background.jpg");
		ImageIcon background = new ImageIcon(imgUrl);
		JLabel bg = new JLabel(background);
		bg.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		
		/*Set the content*/
		URL contentUrl = this.getClass().getResource("/sources/Content.png");
		ImageIcon content = new ImageIcon(contentUrl);
		ct = new JLabel(content);
		ct.setBounds(30, 50, content.getIconWidth(), content.getIconHeight());
		
		/*Create the start button*/
		button = new JButton("");
		URL url = this.getClass().getResource("/sources/Start.png");
		ImageIcon start = new ImageIcon(url);
		button.setIcon(start);
		button.setBorder(null);
		button.setContentAreaFilled(false);
		button.setBounds(150, 430, 200, 55);
		button.addActionListener(this);

		lp.add(bg, new Integer(100));
		lp.add(ct, new Integer(150));
		lp.add(button, new Integer(200));
		this.setContentPane(lp);
	}
	
	public Xmas(int layer, ArrayList<Integer>c) {
		this.setTitle("µã»÷ÐÇÐÇÓÐ¾ªÏ²ßÏ¨t(*¡ã¨Œ¡ã*)¨s");
		this.setLayout(null);
		this.setBackground(new Color(c.get(0), c.get(1), c.get(2)));
		URL iconUrl = this.getClass().getResource("/sources/tree.png");
		Image treeIcon = Toolkit.getDefaultToolkit().getImage(iconUrl);
		this.setIconImage(treeIcon);
		Width = (layer*4+3) * 17 + 150;
		Height = (layer*4+2) *17 + 150;
		this.setSize(Width, Height);
		this.setResizable(false); //Forbid changing the size of the frame
		this.setLocationRelativeTo(null); //Put the window to the centre of the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Tree tree = new Tree(layer, c);
		this.setContentPane(tree);
		Snow snow = new Snow(layer);
		this.setGlassPane(snow);
		snow.setOpaque(false);
		this.getGlassPane().setVisible(true);
		this.validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!submit) {
			/*Remove the landing page's component*/
			ct.setVisible(false);
			
			/*Change the content*/
			URL imgUrl = this.getClass().getResource("/sources/Data.png");
			ImageIcon customize = new ImageIcon(imgUrl);
			JLabel cm = new JLabel(customize);
			cm.setBounds(30, 50, customize.getIconWidth(), customize.getIconHeight());
			
			/*Change the button*/
			URL url = this.getClass().getResource("/sources/Submit.png");
			ImageIcon submit = new ImageIcon(url);
			button.setIcon(submit);
			button.setBorder(null);
			button.setContentAreaFilled(false);
			button.setBounds(75, 430, submit.getIconWidth(), submit.getIconHeight());
			button.addActionListener(this);
			
			/*Make a combo box*/
			layerSelected.setBounds(215, 65, 75, 35);
			
			/*custom color*/
			p1 = new RGB(166, 27, 41); //Background colour
			p1.setBounds(270, 260, 300, 40);
			p1.setOpaque(false);
			p2 = new RGB(67, 178, 68); //Leafs colour
			p2.setBounds(310, 290, 220, 40);
			p2.setOpaque(false);
			p3 = new RGB(92, 55, 25); //Root colour
			p3.setBounds(310, 320, 220, 40);
			p3.setOpaque(false);
			p4 = new RGB(248, 223, 112); //Light colour
			p4.setBounds(310, 350, 220, 40);
			p4.setOpaque(false);
			
			lp.add(p1, new Integer(260));
			lp.add(p2, new Integer(262));
			lp.add(p3, new Integer(264));
			lp.add(p4, new Integer(268));
			lp.add(cm, new Integer(270));
			lp.add(layerSelected, new Integer(300));
		} else {
			
			colours.add(p1.getRedValue());
			colours.add(p1.getGreenValue());
			colours.add(p1.getBlueValue());
			colours.add(p2.getRedValue());
			colours.add(p2.getGreenValue());
			colours.add(p2.getBlueValue());
			colours.add(p3.getRedValue());
			colours.add(p3.getGreenValue());
			colours.add(p3.getBlueValue());
			colours.add(p4.getRedValue());
			colours.add(p4.getGreenValue());
			colours.add(p4.getBlueValue());
			
			this.dispose();
			int height = (int)layerSelected.getSelectedItem();
			Xmas c = new Xmas(height, colours);
			c.setVisible(true);
		}
		submit = !submit;
	}
}
