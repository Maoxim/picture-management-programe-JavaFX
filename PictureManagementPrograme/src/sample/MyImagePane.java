package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MyImagePane {
    private BorderPane borderPane = new BorderPane();
    private ScrollPane scrollPane = new ScrollPane();
    private String imagePath;
    private String imageName;
    private Label imageLabel = new Label();

    MyImagePane(String imagePath,String imageName){
        this.imagePath = imagePath;
        this.imageName = imageName;

        Stage imageStage = new Stage();
        imageStage.setTitle(imageName);
        SecondPage secondPage = new SecondPage();

        addImageOnPane();

        scrollPane.setStyle("-fx-background-color: yellow");
        imageStage.setScene(new Scene(scrollPane,secondPage.getWidth(),secondPage.getHeight()));
        imageStage.show();
    }

    public void addImageOnPane(){
        SecondPage secondPage = new SecondPage();

        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(secondPage.getWidth()-100);
        imageView.setFitHeight(secondPage.getHeight()-100);
        imageView.setPreserveRatio(true);//保持缩放比例

        imageLabel.setStyle("-fx-border-color: black");
        imageLabel.setPrefSize(secondPage.getWidth()-100,secondPage.getHeight()-100);
        imageLabel.setAlignment(Pos.BASELINE_CENTER);

        imageLabel.setGraphic(imageView);
        scrollPane.setContent(imageLabel);
        scrollPane.setPadding(new Insets(0,50,0,50));


    }
}
