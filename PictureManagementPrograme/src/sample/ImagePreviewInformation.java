package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.io.File;

public class ImagePreviewInformation {
    private final String imagePath;
    private final String imageName;
    private final double sizeOfImage;
    private final Label imageInformationLabel = new Label();
    public String getImagePath() {
        return imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public Label getImageInformationLabel() {
        return imageInformationLabel;
    }

    public double getSizeOfImage() {
        return sizeOfImage;
    }


    ImagePreviewInformation(String imagePath,String imageName){


        this.imagePath = imagePath;
        Image image = new Image(imagePath);
        this.imageName = imageName;

        File file = new File(imagePath);
        this.sizeOfImage = file.length();

        setInformationOfImageOnLabel();

    }

    private void setInformationOfImageOnLabel(){
        imageInformationLabel.setText("图片名："+imageName+"\n"+"位置："+imagePath+"\n"+"图片大小："+sizeOfImage);
    }

    public void addInformationOfImageOnPane(Label label){
        MyPane.imagePane.getChildren().add(label);
    }



}
