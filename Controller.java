package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Stack;

public class Controller {
    public static VBox temptVBox = null;

    public static void refreshPane(){
        MyFlowPane.flowPane.getChildren().clear();
        MyFlowPane.reGetPicture(MyFlowPane.file);

        MyPane.imagePane.getChildren().clear();
    }




}
