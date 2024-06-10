package mvctextview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {
    @Override
    public void start(Stage primaryStage) {
        RightTriangle tri = new RightTriangle(0.0, 0.0);
        TextView textView = new TextView(tri);
        GraphicalView graphicalView = new GraphicalView(tri);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(textView, graphicalView);

        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Triangle View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//some code was given for example from Professor via github link: https://github.com/hanbyul1/CSI-3370/tree/main/MVCTextView