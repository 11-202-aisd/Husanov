import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();

        screen.init(500, 500, 0.05);

        while(!StdDraw.isKeyPressed(32)) {
            screen.update();
        }
    }
}
