
# MrakDown语法初步应用

## 常用语法
- **一级标题** 
  “#” 二级标题“##” 三级标题 “###”。。。。。。。。。
- **分割线**
  “----”
- **圆点**  
  “-，*”
- **代码块标注**
  "~~~java"
- **引用符号**
   “>”
- **链接网址** 
  “ 方框【】+括号（）  ”
  例如 
  [这是一个markDown基本语法的链接](http://www.appinn.com/markdown/#%E6%AE%B5%E8%90%BD%E5%92%8C%E6%8D%A2%E8%A1%8C) 
- **强调**
  四个*包裹起来为粗体  ** 123 **
  两个*包裹起来为斜体   * 123 *

------------
# github的基本应用
## 上传代码的基本步骤
1. git clone https://github.com/你的用户名/你的仓库.git （在本地创建你的仓库）
2. cd 仓库名 （进入你的仓库）
3. 按照日期创建目录 如 11-14
4. git add 你要导入的目录
5. git commit -m "你的程序实现了什么" （引号里面的相当于你的日志）
6. git push (会提示输入用户名密码)

## 导入代码到另外一台电脑的
1. 直接 git clone 

## github常用的指令
* git init 新建一个空的仓库
- git status 查看状态
- git add . 添加文件
- git commit -m '注释' 提交添加的文件并备注说明
- git remote add origin git@github.com:jinzhaogit/git.git 连接远程仓库
- git push -u origin master 将本地仓库文件推送到远程仓库
- git log 查看变更日志
- git reset --hard 版本号前六位 回归到指定版本
- git branch 查看分支
- git branch newname 创建一个叫newname的分支
- git checkout newname 切换到叫newname的分支上
- git merge newname 把newname分支合并到当前分支上
- git pull origin master 将master分支上的内容拉到本地上

[！！！这是一个上述指令的示例演示网址](https://www.cnblogs.com/jinzhaozhao/p/10012504.html)

----------------------------------
# Week one code 学习
## 声明变量
- 具体案例为 让变量去控制英雄的移动 具体来说就是距离 步数
~~~java
 int X,Y;
	int runLeft,runUp,runRight,runDown;
	Image [][] img=new Image[6][3];
	
	Image currentimg;
~~~
## 控制语句
- 与变量相结合 做到控制英雄 移动方向的选择
~~~java
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
~~~
## 循环和数组
- 用循环来简化很多标量的声明 优化代码 提高可读性 
- 例如 声明许多图片对象的时候 可以简化用循环+数组来声明
~~~java
for(int i=0;i<6;i++){
               for(int j=0;j<3;j++){
                  img[i][j]=Image.createImage("/sayo"+i+j+".png") 
			   }
			}
~~~