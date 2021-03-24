package sample;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class MouseDraggedController {
    private double width,height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private double setX,setY;
    public static final Rectangle rectangle = new Rectangle();
    public static Pane pane = new Pane();

    MouseDraggedController(){
        rectangle.setArcHeight(6);
        rectangle.setArcWidth(10);
        rectangle.setFill(Color.rgb(200,200,200,0.3));
        pane.getChildren().add(rectangle);
        MouseDraggedOnFlowPane();
    }
    public void MouseDraggedOnFlowPane(){
        pane.setOnMousePressed(this::handleMousePressed);
        pane.setOnMouseDragged(this::draggedMousePressed);
        pane.setOnMouseReleased(this::releasedMouse);
    }

    private void releasedMouse(MouseEvent mouseEvent) {
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setHeight(0);
        rectangle.setWidth(0);

    }

    private void handleMousePressed(MouseEvent mouseEvent) {
        setX = mouseEvent.getX() ;
        setY = mouseEvent.getY()  ;
        System.out.println(setX+" "+setY);

    }

    private void draggedMousePressed(MouseEvent mouseEvent) {
        width = mouseEvent.getX() -setX;
        height = mouseEvent.getY() - setY;
        rectangle.setX(setX);
        rectangle.setY(setY);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
       // System.out.println(setX+"   "+setY+"  "+width+"   "+height);
    }
}
