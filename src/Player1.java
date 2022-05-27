import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.net.URL;

public class Player1 
{
	public static int x;
	public static int y;
	public static boolean shotInPlace = false;
	public static boolean shot = false;
	private Image img;
	private AffineTransform tx;
	
	public Player1(int newX, int newY)
	{
		img = getImage("/imgs/player1.gif");
		x = newX;
		y = newY;
		tx = AffineTransform.getTranslateInstance(x,y);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		init(x,y);
	}
	
	public void changePicture(String newFileName) 
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
		
		tx.scale(5, 5);
		
		if(x <= 10 || x >= 1600)
		{
			x = 1000;
		}
	}
	
	private void init(double a, double b) 
	{
		tx.setToTranslation(a, b);
		tx.scale(.5, 1);
	}
	
	public static void shoot()  
	{	
		if(Player1.hasBall() == true)
		{
			while(Basketball.getX()+67 >= 225)
			{
				shot = true;
			}
			
			HoopLeft.changePicture("/imgs/hoopleft_score.gif");
			Basketball.score++;		
		}
		shot=false;
	}
	
	public static void moveRight()
	{
		x+=8;
	}
	
	public static void moveLeft()
	{
		x-=8
				;
	}
	
	public static boolean hasBall()
	{
		if(Basketball.getX()+105 >= x+160)
		{
			return true;
		}
		return false;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int n)
	{
		x = n;
	}
	
	public void setY(int n)
	{
		y = n;
	}

	private Image getImage(String path)
	{
		Image tempImage = null;
		try {
			URL imageURL = Player1.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
