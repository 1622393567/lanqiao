import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
import java.util.*;
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
class MainCanvas extends Canvas implements Runnable
{  
    int X,Y;
	int bossX,bossY;
	int flag;
	Image [][] img=new Image[3][8];
	Image bossImg;
	Image currentimg;
	Thread thread;
	Random rd=new Random();
	public MainCanvas(){
		try
		{   
			for(int i=0;i<img.length;i++){
               for(int j=0;j<img[i].length;j++){
                  img[i][j]=Image.createImage("/sayo"+i+j+".png");
			   }
			}

            bossImg=Image.createImage("/zuzu000.png");
			bossX=0;
			bossY=0;
			currentimg=img[1][0];
			X=120;
			Y=100;
			flag=0;
			thread=new Thread(this);
			thread.start();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public void run(){
	
		while(true){
			int i=rd.nextInt(10);
			try{
				thread.sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(i%3==0){
				if(bossX<X){
						bossX++;
					}else{
						bossX--;
					}
					if(bossY<Y){
						bossY++;
					}else{
						bossY--;
					}
					repaint();
			}
		}

	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentimg,X,Y,0);
        g.drawImage(bossImg,bossX,bossY,0);
		
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		System.out.println(action);
		   if(action==LEFT){
			   changePicAndDirection(2);
			   System.out.print("向左走");
			   if(X<10){
				   X=X-0;
			   }else{
				   X=X-1;
			   }
			   
		   }
		
		   //左下走
		   if(action==11){
			    changePicAndDirection(1);
			   System.out.print("左下走");
			       Y=Y+5;
				   X=X-5;
			   
		   }
		   //左上走
		   if(action==9){
			    changePicAndDirection(3);
			       Y=Y-5;
				   X=X-5;
		   }
		   //右上走
		   if(action==10){
			    changePicAndDirection(5);
			       Y=Y-5;
				   X=X+5;
		   }
		   //右下走
		   if(action==12){
			    changePicAndDirection(7);
			    Y=Y+5;
				X=X+5;
		   }
		   if(action==RIGHT){
			  changePicAndDirection(6);
			   System.out.print("向右转");
			    if(X>200){
				   X=X+0;
			   }else{
				   X=X+10;
			   }
		   }
		   if(action==UP){
			   changePicAndDirection(4);
			   System.out.print("向上转");
			    if(Y<10){
				   Y=Y-0;
			   }else{
				   Y=Y-10;
			   }
		   }
			if(action==DOWN){
			   changePicAndDirection(0);
			   System.out.print("向下转");
			   if(Y>250){
				   Y=Y+0;
			   }else{
				   Y=Y+10;
			   }
		   }
		   
    }
	public void changePicAndDirection(int direction){
		if(flag==0){
           currentimg=img[0][direction];
				  flag++;
		}else if(flag==1){
			currentimg=img[2][direction];
				  flag--;
		}
	}


}