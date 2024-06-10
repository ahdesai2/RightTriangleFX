package mvctextview;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GraphicalView extends Pane {
    private RightTriangle triangle;
    private Canvas canvas;

    public GraphicalView(RightTriangle triangle) {
        this.triangle = triangle;
        canvas = new Canvas(400, 400);
        getChildren().add(canvas);

        triangle.baseProperty().addListener((obs, oldVal, newVal) -> update());
        triangle.heightProperty().addListener((obs, oldVal, newVal) -> update());
        triangle.hypotenuseProperty().addListener((obs, oldVal, newVal) -> update());
        update();
    }

    private void update() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double base = triangle.getBase();
        double height = triangle.getHeight();

        gc.setStroke(Color.BLACK);
        gc.strokeLine(50, 350, 50 + base, 350); // base
        gc.strokeLine(50, 350, 50, 350 - height); // height
        gc.strokeLine(50, 350 - height, 50 + base, 350); // hypotenuse
    }
}
