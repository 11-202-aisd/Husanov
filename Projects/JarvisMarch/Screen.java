import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

public class Screen {
    private ArrayList<Dot> verticles;
    private ArrayList<Dot> verticlesJarvis;
    private Dot choosedVerticle;

    private double radius;

    private static final double staticDeltaTime = 0.1;
    private double deltaTime = 0.1;
    private long time;
    private boolean isInit;
    private boolean jarvisUsed;
    JarvisMarch jarvis;

    public Screen() {
        verticles = new ArrayList<>();
        verticlesJarvis = new ArrayList<>();
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

        time = System.nanoTime();
    }

    public void update() {
        deltaTime = time - System.currentTimeMillis();
        time = System.currentTimeMillis();

        if(deltaTime > staticDeltaTime) {
            deltaTime = 0;
        }

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
            }
        }

        if(StdDraw.isMousePressed() && choosedVerticle != null) {
            choosedVerticle.setLocation(mouse.getX(), mouse.getY());
            jarvisUsed = false;
        }

        if(!StdDraw.isMousePressed() && choosedVerticle != null && deltaTime <= 0) {
            choosedVerticle.setColor(StdDraw.RED);

            choosedVerticle = null;
        }

        if(choosedVerticle == null && !StdDraw.isMousePressed() && !verticles.isEmpty() && c =='q') {
            jarvisUsed = true;

            verticlesJarvis = jarvis.JarvisMarchAlgorithm(verticles);
        }



        for(int i = 0; i < verticles.size(); i++) {
            Dot dot = verticles.get(i);

            StdDraw.setPenColor(dot.getColor());
            StdDraw.filledCircle(dot.getX(), dot.getY(), radius);

        }

        for (int i = 0; i < verticlesJarvis.size(); i++) {
            Dot dot = verticlesJarvis.get(i);

            StdDraw.setPenColor(StdDraw.BLUE);

            if(i < verticlesJarvis.size() - 1) {
                Dot preDot = verticlesJarvis.get(i + 1);
                StdDraw.line(dot.getX(), dot.getY(), preDot.getX(), preDot.getY());
            } else {
                Dot preDot = verticlesJarvis.get(0);
                StdDraw.line(dot.getX(), dot.getY(), preDot.getX(), preDot.getY());
            }
        }

        StdDraw.show();
    }

    private Dot findAnyVert(Dot mouse) {
        Dot ans = null;
        for(Dot i : verticles) {
            if(i.getDistance(mouse) <= radius * radius * 2) {
                ans = i;
            }
        }

        return ans;
    }
}
