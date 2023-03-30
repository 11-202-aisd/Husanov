import java.awt.*;

public class Dot {
    private static final double EPS = 0.0000001;

    private double x;
    private double y;

    private Color color;

    Dot(double x, double y) {
        this.x = x;
        this.y = y;

        color = Color.RED;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDistance(Dot to) {
        return ((to.x - x)*(to.x - x) + (to.y - y)*(to.y - y));
    }

    public double getOrientation(Dot first, Dot second) {
        double val = (second.y - first.y) * (this.x - second.x) - (second.x - first.x) * (this.y - second.y);

        if(val < EPS && val > -EPS) {
            return 0;
        }

        return (val > 0) ? 1 : 2;
    }

    public Color getColor() {
        return color;
    }

    public boolean isEqual(Dot dot) {
        return (x - dot.x < EPS && y - dot.y < EPS);
    }

    public String toString() {
        return x + " " + y;
    }

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
