# 11-19



## 用for循环和一维数组改造项目



1、声明好各个方向的一维数组，用于存放各个方向的图片。


```java
Image[] heroUpimg = new Image[3];
Image[] heroDownimg = new Image[3];
Image[] heroLeftimg = new Image[3];
Image[] heroRightimg = new Image[3];
```

2、利用for循环使各个方向的图片存放在一维数组中

```java

for(int i = 0 ;i < 3 ; i++){
heroLeftimg[i] = Image.createImage("/sayo"+ i +"2.png");
    }
for(int i = 0 ;i < 3 ; i++){
heroUpimg[i] = Image.createImage("/sayo"+ i +"4.png");
    }
for(int i = 0 ;i < 3 ; i++){
heroRightimg[i] = Image.createImage("/sayo"+ i +"6.png");
    }
for(int i = 0 ;i < 3 ; i++){
heroDownimg[i] = Image.createImage("/sayo"+ i +"0.png");
    }

    ## 用二维数组改造项目

1、声明一个二维数组，用于存放所有图片。

```java

Image[][] heroImg = new Image[4][3];

```

2、在用嵌套循环遍历二维数组，使所有图片存放在二维数组中。
```java


for(int i=0 ; i<4 ; i++){
    for (int j=0 ; j<3 ; j++)
    {
        heroImg[i][j] = Image.createImage("/sayo"+ i + j +".png");//0为上，1为下，2为左，3为右
    }
}
```

## 添加boss，简单实现boss追hero

1、声明boss所用到的各个变量并将boss画在屏幕上

```java
bossX = 0;
bossY = 0;


g.drawImage(bossImg,bossX,bossY,0);
```
2、创建boss的线程，使boss的坐标能随着hero的坐标改变而改变，
```java

thread=new Thread(this);
thread.start();
```

3、新建一个死循环，使boss能一直追着hero


```java
public void run(){
    while(true)
    {
        try
        {
            Thread.sleep(200);//FPS:屏幕刷新率
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        if (bossX<heroX)
        {
            bossX++;
        }
        else{
            bossX--;
        }
        if (bossY<heroY)
        {
            bossY++;
        }
        else{
            bossY--;
        }
        repaint();
    }
}

```