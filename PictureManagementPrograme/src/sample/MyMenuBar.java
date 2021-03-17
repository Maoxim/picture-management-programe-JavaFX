package sample;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;

public class MyMenuBar extends MenuBar {

    MyMenuBar(){
        super();
        Menu menuFile = new Menu("文件");
        Menu menuHelp = new Menu("帮助");
        getMenus().addAll(menuFile,menuHelp);
//        setStyle("-fx-background-color: rgb(235,235,235)");
        setStyle("-fx-background-color: lightgreen");

    }
}
