package sample;

import java.awt.*;

public class HomePage {
    private static double width;
    private static double height;

    HomePage(){
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        width = gd.getDisplayMode().getWidth()*0.82;
        height = gd.getDisplayMode().getHeight();
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
