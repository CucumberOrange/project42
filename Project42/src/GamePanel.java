import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener{
	
	Image background;
	Timer t = new Timer(7, this);
	
	int width = 626;
	int height = 417;
	int xCoord = 0;
	
	int moveSpeed = -1;
	
	public GamePanel() {
		ImageIcon i = new ImageIcon("bin/pics/woods.jpg");
		background = i.getImage();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, xCoord, 0,null);
		
		if(moveSpeed == -1) {
			g.drawImage(background, xCoord + width, 0,null);
		}else {
			g.drawImage(background, xCoord - width, 0,null);
		}
		
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(Math.abs(xCoord) == width) {
			xCoord = 0;
		}else {
			xCoord += moveSpeed;
			repaint();
		}
	
		
	}
	
	public static void main(String [] args) {
		GamePanel b = new GamePanel();
		JFrame container = new JFrame("container");
		container.setSize(645, 420);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.add(b);
		container.setLocationRelativeTo(null);
		container.setVisible(true);
	}
  
} // classImagePanel


