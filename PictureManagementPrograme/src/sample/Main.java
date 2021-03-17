package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Electronic Picture Management Program");
        primaryStage.setMaximized(true);//能够最大化
        primaryStage.setResizable(true);//能够改变窗口大小

        BorderPane borderPane = new BorderPane();

        //获取桌面大小
        HomePage homePage01 = new HomePage();
        Scene scene = new Scene(borderPane,homePage01.getWidth(), homePage01.getHeight());

        //菜单栏建立
        MyMenuBar myMenuBar = new MyMenuBar();
        borderPane.setTop(myMenuBar);

        //具体信息栏
        MyPane myPane = new MyPane();
        borderPane.setRight(myPane);

        //目录树
        MyTreeView myTreeView = new MyTreeView();
        borderPane.setLeft(myTreeView.rootPane);

        //图片缩放pane
        MyFlowPane myFlowPane = new MyFlowPane();
        borderPane.setCenter(myFlowPane);


        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
