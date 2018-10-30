import java.applet.Applet;
import java.awt.*;

public class MultiThreadApplet extends Applet implements Runnable {
    private static final int DROP_COUNT = 10;
    private Thread mainThread;
    private Drop[] drops;
    //    private Drop drop;
    private Cloud cloud;

    @Override
    public void run() {

        while (true) { //бесконечный цикл
            repaint(); //перерисовка апплета или вызов метода paint
            try {
                mainThread.sleep(10); //приостановка апплета на 10 миллисекунл
            } catch (InterruptedException e) {
            }
        }

    }

    @Override
    public void paint(Graphics graphics) {
        Drawer drawer = new Drawer();

        drawer.drawCloud(cloud, graphics);

        for (Drop drop : drops) {
            drawer.drawDrop(drop, graphics);
        }
    }

    @Override
    public void init() {
        this.setSize(900, 500);
        mainThread = new Thread(this);
        mainThread.start();

        Point2D cloudStartPoint = new Point2D(50, 50);
        cloud = new Cloud(cloudStartPoint, 100, 200);


        int highDropY = cloudStartPoint.getY() + cloud.getHeight() / 2;


        RandomGenerator generator = new RandomGenerator();
        drops = new Drop[DROP_COUNT];
        for (int i = 0; i < drops.length; i++) {
            int DropX = generator.generateInt(cloudStartPoint.getX(),
                    cloudStartPoint.getX() + cloud.getWidth());


            Point2D highDropPoint = new Point2D(DropX, highDropY);
            Point2D lowDropPoint = new Point2D(DropX, highDropY + 7);

            drops[i] = new Drop(highDropPoint, lowDropPoint);


        }


//        drop = new Drop(new Point2D(50, 50), new Point2D(50, 60));

//        drops = new Drop[DROP_COUNT];
//        for (int i = 0; i < drops.length; i++) {
//            drops[i] = new Drop(cloud.getStartPoint(),
//                    new Point2D(cloud.getStartPoint().getX(), cloud.getStartPoint().getY()),
//                    new Point2D(500, 500));
//
//        }


    }
}
