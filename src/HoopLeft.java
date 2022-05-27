import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class HoopLeft 
{
	private static int x;
	private static int y;
	private static Image img;
	private static AffineTransform tx;
	
	public HoopLeft(int newX, int newY)
	{
		img = getImage("/imgs/hoopleft.png");
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
		
		tx.scale(7, 7);
	}
	
	private static void init(double a, double b) 
	{
		tx.setToTranslation(a, b);
		tx.scale(.5, 1);
	}
	
	public static void shoot()
	{
		
	}

	private static Image getImage(String path)
	{
		Image tempImage = null;
		try {
			URL imageURL = HoopLeft.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
