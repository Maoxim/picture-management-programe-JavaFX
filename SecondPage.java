package sample;


import javafx.scene.layout.BorderPane;

import java.awt.*;

public class SecondPage {
    private static double width;
    private static double height;

    SecondPage(){
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        width = gd.getDisplayMode().getWidth()*0.78;
        height = gd.getDisplayMode().getHeight()*0.9;



    }


    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}
