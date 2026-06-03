package hust.soict.hedspi.javafx;

import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    public Pane drawingAreaPane;
    public ToggleGroup Tools;
    public RadioButton pen;
    public RadioButton eraser;

    public void drawingAreaMouseDragged(MouseEvent mouseEvent) {
        Color activeCol = eraser.isSelected() ? Color.WHITE : Color.BLACK;
        Circle newCircle = new Circle(mouseEvent.getX(), mouseEvent.getY(), 4, activeCol);
        drawingAreaPane.getChildren().add(newCircle);
    }

    public void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}
