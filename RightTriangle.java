package mvctextview;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class RightTriangle {
    private DoubleProperty base;
    private DoubleProperty height;
    private DoubleProperty hypotenuse;

    public RightTriangle(double base, double height) {
        this.base = new SimpleDoubleProperty(base);
        this.height = new SimpleDoubleProperty(height);
        this.hypotenuse = new SimpleDoubleProperty();
        setHypotenuse();
        this.base.addListener((obs, oldVal, newVal) -> setHypotenuse());
        this.height.addListener((obs, oldVal, newVal) -> setHypotenuse());
    }

    public double getBase() {
        return base.get();
    }

    public void setBase(double base) {
        this.base.set(base);
    }

    public DoubleProperty baseProperty() {
        return base;
    }

    public double getHeight() {
        return height.get();
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public double getHypotenuse() {
        return hypotenuse.get();
    }

    private void setHypotenuse() {
        this.hypotenuse.set(Math.sqrt((base.get() * base.get()) + (height.get() * height.get())));
    }

    public DoubleProperty hypotenuseProperty() {
        return hypotenuse;
    }
}
