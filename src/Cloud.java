import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cloud implements Runnable {
    private Point2D startPoint;
    private int height;
    private int width;
    private Color color;
    private Thread thread;
    private List<Drop> dropList = new ArrayList<>();


    public Cloud(Point2D startPoint, int height, int width, Color color) {
        thread = new Thread(this);
        this.startPoint = startPoint;
        this.height = height;
        this.width = width;
        this.color = color;
        thread.start();
    }

    public Cloud(Point2D startPoint, int height, int width) {
        thread = new Thread(this);
        this.startPoint = startPoint;
        this.height = height;
        this.width = width;
        this.color = Color.cyan;
        thread.start();
    }

    public Cloud(Point2D startPoint, int height, int width, List<Drop> drops) {
        thread = new Thread(this);
        this.startPoint = startPoint;
        this.height = height;
        this.width = width;
        this.color = Color.cyan;
        this.dropList = drops;
        thread.start();
    }

    @Override
    public void run() {
        RandomGenerator generator = new RandomGenerator();
        for (int i = 0; i < 200; i++) {

            if (height < 0 || width < 0) {
                break;
            }

            if (i % 10 == 0) {

                int highDropY = startPoint.getY() + getHeight() / 2;
                int DropX = generator.generateInt(startPoint.getX(),
                        startPoint.getX() + getWidth());

                Point2D highDropPoint = new Point2D(DropX, highDropY);
                Point2D lowDropPoint = new Point2D(DropX, highDropY + 7);
                Drop drop = new Drop(highDropPoint, lowDropPoint);

                dropList.add(drop);
            }

            startPoint.setX(startPoint.getX() + 5);
            height--;
            width -= 2;

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}