package sample;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ImagePreviewLabel {
    private final Label imageLabeled = new Label();

    ImagePreviewLabel(String imagePath){
        MyPane.imagePane.getChildren().clear();

        imageLabeled.setPrefSize(300,300);
        imageLabeled.setWrapText(true);
        imageLabeled.setStyle("-fx-border-color: black");
        imageLabeled.setAlignment(Pos.BASELINE_CENTER);
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);

        imageView.setPreserveRatio(true);//保持缩放比例

        imageLabeled.setGraphic(imageView);
    }

    public Label getImageLabeled() {
        return imageLabeled;
    }

    public void addLabelOnPane(Label label){
        MyPane.imagePane.getChildren().add(label);
    }
}
