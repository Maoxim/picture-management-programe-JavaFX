package sample;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;


public class MyPane extends Pane {
    public static FlowPane imagePane = new FlowPane();

    MyPane(){
        super();
        setPrefSize(400,718);
        setStyle("-fx-background-color:lightblue");
        //  setStyle("-fx-background-color:rgb(249,248,248)");


        imagePane.setPadding(new Insets(12,13,14,15));
        imagePane.setOrientation(Orientation.VERTICAL);
        imagePane.setHgap(8);
        imagePane.setVgap(5);

        imagePane.setPrefSize(400,718);
        getChildren().add(imagePane);
    }



}
