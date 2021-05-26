# - SCAU JAVA课设 电子图片管理程序 （JavaFX）

只用了JavaFX，没有用SceneBuilder，最终版在分支2.0，不要下载错了，Java主程序的文件夹包叫做sample，要不然会报错。

主界面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210526163941954.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L01hb3hpbQ==,size_16,color_FFFFFF,t_70)



查看大图
![<img width="1128" alt="3" src="https://user-images.githubusercontent.com/76590045/112329275-06dc3080-8cf2-11eb-9475-614fd621b17b.png">](https://img-blog.csdnimg.cn/20210526164004231.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L01hb3hpbQ==,size_16,color_FFFFFF,t_70)
说明：
该系统一共有15个类，分别是Controller，HomePage,ImageBoxLabel,ImageMenuLabel,ImagePreviewInnformation,ImagePreviewLabel,Main,MyFlowPane,MyImagePane,MyPane,MytreeView,MyTreeViewController,SecondPane,Support

Controller类：负责对FlowPane的控制（刷新）
HomePage类：负责获取用户的电脑屏幕大小，以便于控制软件的窗口大小
ImageBoxLabel类：针对的是在FlowPane中的缩略图的一个对象，包括实现双击后弹出新窗口，单击显示图片详细信息的操作
ImageMenuItem类：针对的是当用户右击图片时的删除，重命名和复制的操作
ImageMenuLabel类：是当用户单击缩略图的时候，最右方Pane中放大图的对象，并将图片放在Label中
ImagePreviewInformation类：负责保存图片的详细信息，出现在ImageMenuLabel的下方，信息包括，图片名，位置，图片大小，图片宽度，图片高度，最后访问时间，最后修改时间，文件所有者。
Main类：负责的是将各个Pane加入到Sence中。
MyPlowPane类：则是放缩略图的Pane。
MyFolderPane类：是放在BorderPane的bottom的一个Pane，里面存放该文件夹一共有多少个图片，以及图片的总大小。
MyImagePane类：是当用户双击后，弹出新窗口的Pane，里面实现了图片的放大，缩小， 左移和右移的操作
MyPane类：是最右边的Pane，负责存放ImageMenuLabel和ImagePreviewInformation
MyTreeView类：是最左边的目录树，当用户点击不同的文件夹的时候，会将文件夹的图片添加到FlowPane中
MyTreeVIew类：是负责控制目录树的类，里面负责保存用户对目录树的点击操作
SecondPane类：负责获取用户的电脑屏幕大小，以便于控制软件第二个弹出的窗口的大小
Support类：负责保存该系统支持图片的类型，方便后期的维护和修改

2021.5.26
