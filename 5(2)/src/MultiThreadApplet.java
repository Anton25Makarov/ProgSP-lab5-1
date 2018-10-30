import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadApplet extends Applet implements Runnable {
    private Thread mainThread;
    private Cloud cloud;
    private List<Drop> dropList = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                mainThread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        Drawer drawer = new Drawer();

        drawer.drawCloud(cloud, graphics);

        for (Drop drop : dropList) {
            drawer.drawDrop(drop, graphics);

        }
    }

    @Override
    public void init() {
        this.setSize(900, 500);
        mainThread = new Thread(this);
        mainThread.start();

        Point2D cloudStartPoint = new Point2D(50, 50);
        cloud = new Cloud(cloudStartPoint, 100, 200, dropList);
    }
}
