package sample;


import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class ImageBoxLabel {
    private final String imageName;
    private final String imagePath;
    private final Labeled imageLabel = new Label();

    ImageBoxLabel(String imagePath,String imageName){
        this.imagePath = imagePath;
        this.imageName = imageName;

        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(120);
    imageLabel.setGraphic(imageView);
    imageLabel.setText(imageName);
    imageLabel.setContentDisplay(ContentDisplay.TOP);

    //点击图片事件
    setOnMouseClickedOnImage();


    }
    public void setOnMouseClickedOnImage(){
        imageLabel.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2) {
                System.out.println("点击了两下");
                MyImagePane myImagePane = new MyImagePane(imagePath,imageName);


            }
            else if(mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 1){
                ImagePreviewLabel imagePreviewLabel = new ImagePreviewLabel(imagePath);
                imagePreviewLabel.addLabelOnPane(imagePreviewLabel.getImageLabeled());

                ImagePreviewInformation imagePreviewInformation = new ImagePreviewInformation(imagePath,imageName);
                imagePreviewInformation.addInformationOfImageOnPane(imagePreviewInformation.getImageInformationLabel());
            }
        });
    }

    public Labeled getImageLabel() {
        return imageLabel;
    }
}
