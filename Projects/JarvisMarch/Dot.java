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
        return Math.sqrt((to.x - x)*(to.x - x) + (to.y - y)*(to.y - y));
    }

    public double getAngle(Dot first, Dot second) {
        double a = first.getDistance(this);
        double b = second.getDistance(this);
        double c = first.getDistance(second);
        double cos = (b*b + c*c - a*a) / 2*b*c;

        return Math.acos(cos);
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
