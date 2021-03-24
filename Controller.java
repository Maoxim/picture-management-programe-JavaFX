package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Stack;

public class Controller {
    public static VBox temptVBox = null;
    public static int ifClickImage = 0;

    //存储信息的变量
    private String currentPath = "";
    private final Stack<String> pathStack1 = new Stack<>();
    private final Stack<String> pathStack2 = new Stack<>();

    @FXML
    private BorderPane homePage;

    public void initEnterFolder(String path) {
        currentPath = path;
        //入栈以便于后续前进后退
        if (pathStack1.isEmpty() || !pathStack1.peek().equals(path)) {
            pathStack1.push(path);
            pathStack2.clear();
        }
    }

    public static void refreshPane(){
        MyFlowPane.flowPane.getChildren().clear();
        MyFlowPane.reGetPicture(MyFlowPane.file);

        MyPane.imagePane.getChildren().clear();
    }




}
