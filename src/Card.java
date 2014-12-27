import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card extends JButton{
	
	private static final long serialVersionUID = 1L;
	int no,id;
	Image img; 
	boolean selected;
	Icon ic;
	ImageIcon im;
	
	public Card(int no,int id)
	{
		this.no=no;
		this.id=id;
		//im = new ImageIcon(getClass().getResource("bin/"+id+""+no+".gif"));
		setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/"+no+""+id+".gif")));
		//ic = new ImageIcon(no+""+id+".gif");
		//setIcon(ic);
		/*try {
		    img = ImageIO.read(getClass().getResource("resources/"+no+""+id+".gif"));
		    setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }*/
		selected = false;
		setPreferredSize(new Dimension(100,100));
	}
	
	public Image img()
	{
		return img;
	}
	
	public int getNo()
	{
		return no;
	}
	public int getId()
	{
		return id;
	}
	public void setSelected(boolean boo)
	{
		selected = boo;
	}
	public boolean getSelected()
	{
		return selected;
	}
	
}