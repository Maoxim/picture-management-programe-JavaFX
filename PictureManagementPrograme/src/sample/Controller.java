package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import java.util.Stack;

public class Controller {

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




}
