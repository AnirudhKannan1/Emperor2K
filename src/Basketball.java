import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Basketball 
{
	public static int x; 
	public static int y;
	public static int score;
	private static Image img;
	private static AffineTransform tx;
	public static int p1Score = 0;
	public static int p2Score = 0;
	
	public Basketball(int newX, int newY)
	{
		img = getImage("/imgs/basketball.gif");
		x = newX;
		y = newY;
		tx = AffineTransform.getTranslateInstance(x,y);
		init(x,y);
	}
	
	public static void changePicture(String newFileName) 
	{
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g)
	{
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		g2.drawImage(img, tx, null);
		
		

	}
	/* update the picture variable location */
	private void update()
	{
		tx.setToTranslation(x, y);
		
		if(Player1.shot==true)
		{
			x-=5;
			y-=5;
		}
		tx.scale(2, 2);
	}
	
	private static void init(double a, double b) 
	{
		tx.setToTranslation(a, b);
		tx.scale(.5, 1);
	}
	
	public static void p1Score()
	{
		p1Score++;
	}
	
	public static void p2Score()
	{
		p2Score++;
	}
	
	public int moveRight()
	{
		return 1;
	}
	
	public int moveLeft()
	{
		return -1;
	}
	
	public static int getX()
	{
		return x;
	}
	
	public static int getY()
	{
		return y;
	}
	
	public static void setX(int n)
	{
		x = n;
	}
	public static void setY(int n)
	{
		y = n;
	}
	

	private static Image getImage(String path)
	{
		Image tempImage = null;
		try {
			URL imageURL = Basketball.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
