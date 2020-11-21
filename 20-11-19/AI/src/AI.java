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
	int runLeft,runUp,runRight,runDown;
	Image [][] img=new Image[6][3];
	
	Image currentimg;
	public MainCanvas(){
		try
		{   
			for(int i=0;i<6;i++){
               for(int j=0;j<3;j++){
                  img[i][j]=Image.createImage("/sayo"+i+j+".png") 
			   }
			}


			currentimg=img[1][0];
			X=120;
			Y=100;
			runLeft=0;
			runDown=0;
			runRight=0;
			runUp=0;

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
			   if(runLeft==0){
				  currentimg=img[0][2];
				  runLeft++;
			   }else if(runLeft==1){
				   currentimg=img[2][2];
				   runLeft--;
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
			  if(runRight==0){
				  currentimg=img[0][6];
				  runRight++;
			   }else if(runRight==1){
				   currentimg=img[2][6];
				   runRight--;
			   }
			   System.out.print("向右转");
			    if(X>200){
				   X=X+0;
			   }else{
				   X=X+10;
			   }
			 
			   repaint();
		   }
		   if(action==UP){
			    if(runUp==0){
				  currentimg=img[0][4];
				  runUp++;
			   }else if(runUp==1){
				   currentimg=img[2][4];
				   runUp--;
			   }
			   System.out.print("向上转");
			    if(Y<10){
				   Y=Y-0;
			   }else{
				   Y=Y-10;
			   }
			   repaint();
			  
		   }
			if(action==DOWN){
			    if(runDown==0){
				  currentimg=img[0][0];
				  runDown++;
			   }else if(runDown==1){
				   currentimg=img[2][0];
				   runDown--;
			   }
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