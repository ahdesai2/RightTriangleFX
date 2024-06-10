package mvctextview;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

public class TextView extends GridPane {
    private RightTriangle target;

    private TextField base;
    private TextField height;
    private TextField hypotenuse;
    private Text txtBase;
    private Text txtHeight;
    private Text txtHypotenuse;

    public TextView(RightTriangle realTri) {
        base = new TextField("0");
        base.setId("Base");
        height = new TextField("0");
        height.setId("Height");
        hypotenuse = new TextField("0");
        hypotenuse.setEditable(false);
        txtBase = new Text("Base");
        txtHeight = new Text("Height");
        txtHypotenuse = new Text("Hypotenuse");

        this.add(txtBase, 0, 0);
        this.add(base, 1, 0);
        this.add(txtHeight, 0, 1);
        this.add(height, 1, 1);
        this.add(txtHypotenuse, 0, 2);
        this.add(hypotenuse, 1, 2);

        this.target = realTri;
        new TVController(this.target);

        // Bind the text fields to the properties of the target
        base.textProperty().bindBidirectional(target.baseProperty(), new NumberStringConverter());
        height.textProperty().bindBidirectional(target.heightProperty(), new NumberStringConverter());
        hypotenuse.textProperty().bind(target.hypotenuseProperty().asString());
    }

    public class TVController implements EventHandler<ActionEvent> {
        private RightTriangle model;

        public TVController(RightTriangle model) {
            this.model = model;
            TextView.this.base.setOnAction(this);
            TextView.this.height.setOnAction(this);
        }

        @Override
        public void handle(ActionEvent event) {
            TextField tf = (TextField) event.getSource();
            try {
                double number = Double.parseDouble(tf.getText());

                if (number < 0) throw new NumberFormatException();
                String which = tf.getId();
                if (which.equals("Base")) {
                    model.setBase(number);
                } else {
                    model.setHeight(number);
                }
            } catch (NumberFormatException e) {
                // Reset the text fields to the current values in the model if there's an error
                base.setText(String.valueOf(model.getBase()));
                height.setText(String.valueOf(model.getHeight()));
            }
        }
    }
}
