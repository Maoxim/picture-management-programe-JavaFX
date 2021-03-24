package sample;


import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ImageBoxLabel {
    private final String imageName;
    private final String imagePath;
    private final Labeled imageLabel = new Label();
    private final VBox vBox = new VBox();

    ImageBoxLabel(String imagePath,String imageName){
        this.imagePath = imagePath;
        this.imageName = imageName;

        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(120);
        imageView.setPreserveRatio(true);//保持缩放比例
    imageLabel.setGraphic(imageView);
        Label nameOfImage = new Label();
        nameOfImage.setText(imageName);
     imageLabel.setAlignment(Pos.BASELINE_CENTER);
    imageLabel.setPrefSize(100,100);

    vBox.getChildren().addAll(imageLabel, nameOfImage);

    //点击图片事件
    setOnMouseClickedOnImage();


    //右击图片事件
    ImageMenuItem item = new ImageMenuItem(imagePath);
    imageLabel.setContextMenu(item.getContextMenu());


    }

    public void setOnMouseClickedOnImage(){

        imageLabel.setOnMouseClicked(mouseEvent -> {
            System.out.println("2");

            if(Controller.temptVBox!=null){
                Controller.temptVBox.setStyle("-fx-background-color: gray");
                Controller.temptVBox = vBox;
                vBox.setStyle("-fx-background-color: lightgray");
            }
            else {
                Controller.temptVBox = vBox;
                vBox.setStyle("-fx-background-color: lightgray");
            }

            //创建一个舞台
            if (mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 2) {
                //System.out.println("点击了两下");
                new MyImagePane(imagePath,imageName);


            }
            else if(mouseEvent.getButton() == MouseButton.PRIMARY && mouseEvent.getClickCount() == 1){

                ImagePreviewLabel imagePreviewLabel = new ImagePreviewLabel(imagePath,300,300);
                imagePreviewLabel.addLabelOnPane(imagePreviewLabel.getImageLabeled());

                ImagePreviewInformation imagePreviewInformation = new ImagePreviewInformation(imagePath,imageName);
                imagePreviewInformation.addInformationOfImageOnPane(imagePreviewInformation.getImageInformationLabel());
            }
        });
    }

    public Node getImageLabel() {
        return vBox;
    }
}
