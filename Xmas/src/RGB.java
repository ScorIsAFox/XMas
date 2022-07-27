import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RGB extends JPanel implements ActionListener{
	final int[] defaultColor = new int[3];
	int[] rgb = new int[3];
	final JLabel label = new JLabel("        ");
	JButton cc = new JButton("选择颜色");
	JRadioButton customize = new JRadioButton("默认色", false);
	
	public RGB(int r, int g, int b) {
		/*Set the area between components*/
		FlowLayout f = (FlowLayout)this.getLayout();
		f.setHgap(15);//水平间距
		//f.setVgap(0);//组件垂直间距
		
		/*Save the RGB value of default colour*/
		defaultColor[0] = r;
		defaultColor[1] = g;
		defaultColor[2] = b;
		
		/*Set the colour as default colour*/
		rgb[0] = defaultColor[0];
		rgb[1] = defaultColor[1];
		rgb[2] = defaultColor[2];
		
		/*Make the colour chooser's button*/
		cc.addActionListener(this);
		cc.setSize(70, 35);
		
		/*Make the colour block*/
        label.setOpaque(true);        
		label.setSize(35, 35);
		label.setBackground(new Color(r, g, b));

		/*Make the default colour choosing button*/
		customize.setSize(30, 35);
		customize.setOpaque(true);
		customize.setBorder(null);
		customize.setContentAreaFilled(false);
		customize.addActionListener(this);
		
		this.add(label);
		this.add(cc);
		this.add(customize);
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == customize) {
			cc.setEnabled(!customize.isSelected());
			rgb[0] = defaultColor[0];
			rgb[1] = defaultColor[1];
			rgb[2] = defaultColor[2];
			label.setBackground(new Color(rgb[0], rgb[1], rgb[2]));
			
		}
		
		if (e.getSource() == cc && (!customize.isSelected())) {
			// 显示颜色选取器对话框, 返回选取的颜色（线程将被阻塞, 直到对话框被关闭）
	        Color color = JColorChooser.showDialog(this, "选取颜色", null);

	        // 如果用户取消或关闭窗口, 则返回的 color 为 null
	        if (color == null) {
	            return;
	        }

	        // 把选取的颜色设置为标签的背景
	        label.setBackground(color);

	        // 获取颜色的 ARGB 各个分量值
	        rgb[0] = color.getRed();
	        rgb[1] = color.getGreen();
	        rgb[2] = color.getBlue();
		}
    }
		
	public int getRedValue() {
		return rgb[0];
	}
	
	public int getGreenValue() {
		return rgb[1];
	}
	
	public int getBlueValue() {
		return rgb[2];
	}
}
