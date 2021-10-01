package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.TimerTask;


public class MyImagePane {
    private BorderPane borderPane = new BorderPane();
    private ScrollPane scrollPane = new ScrollPane();
    private String imagePath;
    private String imageName;
    private Label imageLabel = new Label();
    private HBox hBox = new HBox();
    private SecondPage secondPage = new SecondPage();
    private double times =1;
    private Image image ;
    private static boolean autoPlay = false;
    ImageView imageView;
    Stage imageStage;

    MyImagePane(String imagePath,String imageName){
        this.imagePath = imagePath;
        this.imageName = imageName;

        imageStage = new Stage();
        imageStage.setTitle(imageName);
        SecondPage secondPage = new SecondPage();

        initImage(imagePath);

        addMenuOnPane();

        
        borderPane.setPrefSize(secondPage.getWidth(),secondPage.getHeight());

        imageStage.setScene(new Scene(borderPane,secondPage.getWidth(),secondPage.getHeight()));
        imageStage.show();
    }

    private void initImage(String imagePath){
        image = new Image(imagePath);
        imageView = new ImageView(image);

        imageView.setFitWidth(secondPage.getWidth()-100);
        imageView.setFitHeight(secondPage.getHeight()-150);
        imageView.setPreserveRatio(true);//保持缩放比例

        borderPane.setCenter(scrollPane);


        addImageOnPane(imageView);
    }

    public void addImageOnPane(ImageView imageView){



        imageLabel.setPrefSize(secondPage.getWidth()-100,secondPage.getHeight()-150);
        imageLabel.setAlignment(Pos.BASELINE_CENTER);

        imageLabel.setGraphic(imageView);

        scrollPane.setContent(imageLabel);
        scrollPane.setPadding(new Insets(0,50,0,50));
        scrollPane.setHvalue(0.5);
        scrollPane.setVvalue(0.5);


    }

    public void addMenuOnPane(){
        hBox.setPrefSize(secondPage.getWidth()-100,100);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().clear();


        Button enlargeButton = new Button("放大");
        Button narrowButton = new Button("缩小");
        Button moveLeftButton = new Button("<--");
        Button moveRightButton = new Button("-->");
        Button auto = new Button("自动播放");

        auto.setStyle("-fx-min-height: 30; -fx-min-width: 80;-fx-background-color: rgb(210,210,210);");
        enlargeButton.setStyle("-fx-min-height: 30; -fx-min-width: 80;-fx-background-color: rgb(210,210,210);");
        narrowButton.setStyle("-fx-min-height: 30; -fx-min-width: 80;-fx-background-color: rgb(210,210,210);");
        moveLeftButton.setStyle("-fx-min-height: 30; -fx-min-width: 80;-fx-background-color: rgb(210,210,210);");
        moveRightButton.setStyle("-fx-min-height: 30; -fx-min-width: 80;-fx-background-color: rgb(210,210,210);");

        auto.setPrefSize(60,60);
        enlargeButton.setPrefSize(60,60);
        narrowButton.setPrefSize(60,60);
        moveLeftButton.setPrefSize(60,60);
        moveRightButton.setPrefSize(60,60);

        hBox.getChildren().addAll(moveLeftButton,enlargeButton,narrowButton,moveRightButton,auto);

        auto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(autoPlay){
                    autoPlay = false;
                    auto.setText("自动播放");
                }
                else {
                    autoPlay = true;
                    auto.setText("停止播放");
                }

                AsyncWhile asyncWhile = new AsyncWhile(i -> {
                    try {
                        moveRight();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return autoPlay;
                    // return false when you're done
                    //     or true if you want to be called again
                });

// can asyncWhile.kill() should we need to

            }
        });

        enlargeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                enlargeImage();
            }
        });

        narrowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                narrowImage();
            }
        });

        moveLeftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                moveLeft();
            }
        });

        moveRightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                moveRight();
            }
        });

        borderPane.setBottom(hBox);
    }



    private void enlargeImage(){
            times += 0.15;
        setChangedSize();
    }

    private void narrowImage(){
        times -= 0.15;
        if(times<=0){
            times +=0.15;
        }
        setChangedSize();
    }

    private void setChangedSize() {
        imageLabel.setPrefSize((secondPage.getWidth()-100)*times,(secondPage.getHeight()-150)*times);
        imageView.setFitWidth((secondPage.getWidth()-100)*times);
        imageView.setFitHeight((secondPage.getHeight()-150)*times);
        scrollPane.setHvalue(0.5);
        scrollPane.setVvalue(0.5);
    }

    private void moveLeft(){

        File file = new File(imagePath.substring(5));
        File fileParent = new File(file.getParent());
        File[] fileList = fileParent.listFiles();
        int last = 0;
        for(int i =0;i<fileList.length;i++){
            if (!fileList[i].isDirectory()) {
                String fileName = fileList[i].getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                //支持图片的格式
                if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                        ||suffix.equals("GIF")||suffix.equals("JPEG")) {
                        last = i;


                }
            }
        }
        
        int t1=-1;
        int t2=-1;

        for(int i =0;i<fileList.length;i++){
            if (!fileList[i].isDirectory()) {
                String fileName = fileList[i].getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                //支持图片的格式
                if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                        ||suffix.equals("GIF")||suffix.equals("JPEG")||suffix.equals("gif")) {
                    t1=t2;
                    t2=i;
                    if(fileList[i].getAbsolutePath().equals(imagePath.substring(5))){
                            if(t1==-1){
                                t1 = last;
                            }
                            break;
                    }

                }
            }
        }

        imageView = new ImageView(new Image("File:"+fileList[t1].getAbsolutePath()));

        imageView.setFitWidth(secondPage.getWidth()-100);
        imageView.setFitHeight(secondPage.getHeight()-150);
        imageView.setPreserveRatio(true);//保持缩放比例

        imagePath = "File:"+fileList[t1].getAbsolutePath();
        fileList[t1].getName();
        //System.out.println(imagePath);
        addImageOnPane(imageView);
        //System.out.println("t2:"+t2);
        times =1;

    }

    private void moveRight(){
        File file = new File(imagePath.substring(5));
        File fileParent = new File(file.getParent());
        File[] fileList = fileParent.listFiles();

        int t = 0;
        int t1 =0;
        int t2 =0;

        label:for(int i =0;i<fileList.length;i++){
            if (!fileList[i].isDirectory()) {
                String fileName = fileList[i].getName();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                //支持图片的格式
                if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                        ||suffix.equals("GIF")||suffix.equals("JPEG")||suffix.equals("gif")) {
                    if(t1==0){
                        t2=i;
                        t1++;
                    }
                    if(fileList[i].getAbsolutePath().equals(imagePath.substring(5))){

                        for(int j =i+1;j<fileList.length;j++){
                            if (!fileList[j].isDirectory()) {
                               fileName = fileList[j].getName();
                               suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                                //支持图片的格式
                                if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                                        ||suffix.equals("GIF")||suffix.equals("JPEG")||suffix.equals("gif")) {
                                    t=j;
                                    System.out.println(t);
                                    break label;
                                }
                            }

                        }
                        t=t2;
                        break;

                    }

                }
            }
        }

        imageView = new ImageView(new Image("File:"+fileList[t].getAbsolutePath()));

//        imageView.setFitWidth(secondPage.getWidth()-100);
//        imageView.setFitHeight(secondPage.getHeight()-150);
        imageView.setPreserveRatio(true);//保持缩放比例

        imagePath = "File:"+fileList[t].getAbsolutePath();
        //System.out.println(imagePath);
        //
        imageStage.setTitle(fileList[t].getName());
        addImageOnPane(imageView);
        //System.out.println("t2:"+t2);
        times =1;

    }
}
