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
    int X,Y;
	int run;
	
	Image currentimg,imgDown,imgLeft,imgUp,imgRight,imgLeft0,imgLeft1;
	public MainCanvas(){
		try
		{
			imgDown=Image.createImage("/sayo10.png");
			imgUp=Image.createImage("/sayo14.png");
			imgLeft=Image.createImage("/sayo12.png");
			imgRight=Image.createImage("/sayo16.png");
			imgLeft1=Image.createImage("/sayo22.png");
			imgLeft0=Image.createImage("/sayo02.png");

			currentimg=imgDown;
			X=120;
			Y=100;
			run=0;

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentimg,X,Y,0);
		
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		    int runx=120;
		   if(action==LEFT){
			   if(run==0){
				  currentimg=imgLeft0;
				  run++;
			   }else if(run==1){
				   currentimg=imgLeft1;
				   run--;
			   }
			   System.out.print("向左走");
			   if(X<10){
				   X=X-0;
			   }else{
				   X=X-1;
			   }
			   repaint();
			   
		   }
		   if(action==RIGHT){
			   currentimg=imgRight;
			   System.out.print("向右转");
			    if(X>200){
				   X=X+0;
			   }else{
				   X=X+10;
			   }
			 
			   repaint();
		   }
		   if(action==UP){
			   currentimg=imgUp;
			   System.out.print("向上转");
			    if(Y<10){
				   Y=Y-0;
			   }else{
				   Y=Y-10;
			   }
			   repaint();
			  
		   }
			if(action==DOWN){
			   currentimg=imgDown;
			   System.out.print("向下转");
			   if(Y>250){
				   Y=Y+0;
			   }else{
				   Y=Y+10;
			   }
			   repaint();
			   
		   }
    }

}