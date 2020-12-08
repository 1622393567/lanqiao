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
# 11-24


## 使用方法改造项目


1、创建一个方法，时向四个方向转换的代码更加简洁。

```java

void heroChangeimg(int i){
    if(counnt == 0){
        counnt = 1;
        currentImg = heroImg[i][0];
    }
    else if(counnt == 1){
        counnt = 0;
        currentImg = heroImg[i][2];
    }

}
```
2、在转换方向的方法体里使用heroChangeimg()方法

```java

if(action == LEFT){
    changeImg(2);
    System.out.println("向左转");
    heroX-=1;
}
else if(action ==UP){
    changeImg(0);
    System.out.println("向上转");
    heroY-=1;
}
else if(action == DOWN){
    changeImg(1);
    System.out.println("向下转");
    heroY+=1;
}
else if(action ==RIGHT){
    changeImg(3);
    System.out.println("向右转");
    heroX+=1;
}
```


## 实现boss有二分之一的几率追hero


1、在之间创建好的死循环中定义一个0-10（不包括10）随机变量。

```java

int a = random.nextInt(10);

```

2、用一个if语句判断boss是否可追hero

```java
if(a%2==0){
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
}
repaint();
		


```
