import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentimg,imgDown,imgLeft,imgUp,imgRight;
	public MainCanvas(){
		try
		{
			imgDown=Image.createImage("/sayo10.png");
			imgUp=Image.createImage("/sayo14.png");
			imgLeft=Image.createImage("/sayo12.png");
			imgRight=Image.createImage("/sayo16.png");
			currentimg=imgDown;

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentimg,120,100,0);
		System.out.println("yunxinxxx");
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		   if(action==LEFT){
			   currentimg=imgLeft;
			   System.out.print("向左转");
			   repaint();
		   }
		   if(action==RIGHT){
			   currentimg=imgRight;
			   System.out.print("向右转");
			   repaint();
		   }
		   if(action==UP){
			   currentimg=imgUp;
			   System.out.print("向上转");
			   repaint();
		   }
			if(action==DOWN){
			   currentimg=imgDown;
			   System.out.print("向下转");
			   repaint();
		   }
    }

}