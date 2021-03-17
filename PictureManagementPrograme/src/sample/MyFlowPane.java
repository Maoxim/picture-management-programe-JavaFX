package sample;


import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyFlowPane extends FlowPane {
   private static final FlowPane flowPane = new FlowPane();

    MyFlowPane() throws IOException {
        super();
        setPrefSize(691,718);
        setStyle("-fx-background-color: pink");
        flowPane.setPadding(new Insets(12,13,14,15));
        flowPane.setOrientation(Orientation.HORIZONTAL);
        flowPane.setHgap(8);
        flowPane.setVgap(5);
        this.getChildren().add(flowPane);
        flowPane.setStyle("-fx-background-color: gray");
        flowPane.setPrefSize(600,600);



//
//        Button button = new Button();
//        flowPane.getChildren().add(button);
        //listView.setPrefSize(800,800);
        //listView.setStyle("-fx-background-color: red");
    }

    public void getPicture(TreeItem<File> file){
        flowPane.getChildren().clear();

        File[] fileList = file.getValue().listFiles();
        if(fileList.length>0) {
            for (File value : fileList) {
                if (!value.isDirectory()) {
                    String fileName = value.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    //支持图片的格式
                    if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")) {
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
    public void setPictureOnFlowPane(String picturePath,String fileName){

            //图片缩略图加载进去
            ImageBoxLabel imageBoxLabel = new ImageBoxLabel(picturePath,fileName);
            flowPane.getChildren().add(imageBoxLabel.getImageLabel());


    }


}
