package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;

public class MyFolderPane {
    public static VBox pane = new VBox();
    private static int numOfImage=0;
    private static int sizeOfImage=0;
    public static TreeItem<File> folder = new TreeItem<>();
    public static Label numLabel = new Label();
    public static Label sizeLabel = new Label();


    public MyFolderPane(){
        pane.setPrefSize(50,50);
    }


    public void getInformationOfFolder(){
        pane.getChildren().clear();

        File[] fileList = folder.getValue().listFiles();
        if(fileList.length>0) {
            for (File value : fileList) {
                if (!value.isDirectory()) {
                    String fileName = value.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    //支持图片的格式
                    // 程序能够显示的图片格式包括:.JPG、.JPEG、.GIF、.PNG、和.BMP。
                    if (suffix.equals("jpg")||suffix.equals("JPG")||suffix.equals("png")||suffix.equals("BMP")
                            ||suffix.equals("GIF")||suffix.equals("JPEG")||suffix.equals("gif")) {
                        numOfImage++;

                        File file = new File(value.getAbsolutePath());
                        System.out.println(file);
                        sizeOfImage +=file.length()/1024.0;
                    }
                }
            }
        }
        System.out.println(numOfImage);
        setInformationOfFolder();


    }

    public void setInformationOfFolder(){
        numLabel.setText("图片数量："+numOfImage);
        sizeLabel.setText("图片总大小："+sizeOfImage+"MB");
        //sizeLabel.setStyle("-fx-");

        pane.getChildren().addAll(numLabel,sizeLabel);

        numOfImage=0;
        sizeOfImage=0;

    }


}
