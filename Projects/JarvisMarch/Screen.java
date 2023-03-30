import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Screen {
    private ArrayList<Dot> verticles;
    private Dot choosedVerticle;

    private double radius;
    private boolean isInit;
    private boolean jarvisUsed;
    JarvisMarch jarvis;

    public Screen() {
        verticles = new ArrayList<>();

        isInit = false;

        jarvis = new JarvisMarch();

        StdDraw.setPenColor(StdDraw.RED);
    }

    public void init(int width, int height, double radius) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.enableDoubleBuffering();

        if(verticles.size() != 0) {
            verticles.clear();
        }

        this.radius = radius;
        isInit = true;

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(radius);
    }

    public void update() {
        StdDraw.clear();
        char c = ' ';
        if (StdDraw.hasNextKeyTyped()) {
            c = StdDraw.nextKeyTyped();
        }

        if(!isInit) {
            throw new RuntimeException("Screen is not initialized");
        }
        Dot mouse = new Dot(StdDraw.mouseX(), StdDraw.mouseY());
        if(StdDraw.isMousePressed() && choosedVerticle == null) {
            choosedVerticle = findAnyVert(mouse);

            if(choosedVerticle == null) {
                verticles.add(new Dot(mouse.getX(), mouse.getY()));
            } else if (choosedVerticle != null) {
                choosedVerticle.setColor(StdDraw.GREEN);
            }
        }

        if(StdDraw.isMousePressed() && choosedVerticle != null) {
            choosedVerticle.setLocation(mouse.getX(), mouse.getY());
            jarvisUsed = false;
        }

        if(!StdDraw.isMousePressed() && choosedVerticle != null) {
            choosedVerticle.setColor(StdDraw.RED);

            choosedVerticle = null;
        }

        if(choosedVerticle == null && !StdDraw.isMousePressed() && !verticles.isEmpty() && c =='q') {
            jarvisUsed = true;

            verticles = jarvis.JarvisMarchAlgorithm(verticles);
        }

        for (int i = 0; i < verticles.size(); i++) {
            for (int j = i + 1; j < verticles.size(); j++) {
                if(verticles.get(i).equals(verticles.get(j))) {
                    verticles.remove(j);
                }
            }
        }



        for(int i = 0; i < verticles.size(); i++) {
            Dot dot = verticles.get(i);

            StdDraw.setPenColor(dot.getColor());
            StdDraw.filledCircle(dot.getX(), dot.getY(), radius);
            StdDraw.setPenColor(StdDraw.BLUE);

            if(i < verticles.size() - 1) {
                Dot preDot = verticles.get(i + 1);
                StdDraw.line(dot.getX(), dot.getY(), preDot.getX(), preDot.getY());
            } else {
                Dot preDot = verticles.get(0);
                StdDraw.line(dot.getX(), dot.getY(), preDot.getX(), preDot.getY());
            }
        }

        StdDraw.show();
    }

    private Dot findAnyVert(Dot mouse) {
        for(Dot i : verticles) {
            if(i.getDistance(mouse) <= radius * radius) {
                return i;
            }
        }

        return null;
    }
}
