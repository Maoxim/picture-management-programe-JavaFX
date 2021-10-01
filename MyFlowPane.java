package sample;


import javafx.beans.InvalidationListener;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyFlowPane extends StackPane {
   public static final FlowPane flowPane = new FlowPane();
   public static TreeItem<File> file = new TreeItem<>();
   public static StackPane stackPane = new StackPane();
   public ScrollPane scrollPane = new ScrollPane();
   public static int a=0;

    public void setFile(TreeItem<File> file) {
        MyFlowPane.file = file;
    }

    MyFlowPane() throws IOException {
        super();
        //setPrefSize(569.8,718);
        flowPane.setPadding(new Insets(10,20,20,20));
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setHgap(20);
        flowPane.setVgap(25);
        //this.getChildren().addAll(flowPane,MouseDraggedController.pane);

        flowPane.setStyle("-fx-background-color: rgb(255,255,255)");
        flowPane.setPrefSize(579.8,600);


        this.getChildren().add(flowPane);

    }

    public void getPicture(TreeItem<File> file){
        setFile(file);

        flowPane.getChildren().clear();

        File[] fileList = file.getValue().listFiles();
        if(fileList.length>0) {
            for (File value : fileList) {
                if (!value.isDirectory()) {
                    String fileName = value.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    //支持图片的格式
                   // 程序能够显示的图片格式包括:.JPG、.JPEG、.GIF、.PNG、和.BMP。
                    if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                            ||suffix.equals("GIF")||suffix.equals("JPEG")||suffix.equals("gif")) {
                        setPictureOnFlowPane("File:"+value.getAbsolutePath(),fileName);
                    }
                }
            }
        }

    }
    public static void reGetPicture(TreeItem<File> file){
        File[] fileList = file.getValue().listFiles();
        if(fileList.length>0) {
            for (File value : fileList) {
                if (!value.isDirectory()) {
                    String fileName = value.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    //支持图片的格式
                    if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                            ||suffix.equals("GIF")||suffix.equals("JPEG")||suffix.equals("gif")) {
                        setPictureOnFlowPane("File:"+value.getAbsolutePath(),fileName);
                    }
                }
            }
        }

    }
    //放在本地文件系统里的图片文件
    //要在文件路径前面加上 “file:" 字样
    //注：和网络图片比较
    //一个是http: 开头，一个是 file: 开头
    public static void setPictureOnFlowPane(String picturePath, String fileName){

            //图片缩略图加载进去
            ImageBoxLabel imageBoxLabel = new ImageBoxLabel(picturePath,fileName);
            flowPane.getChildren().add(imageBoxLabel.getImageLabel());


    }



}
