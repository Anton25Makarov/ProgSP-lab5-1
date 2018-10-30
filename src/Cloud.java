import java.awt.*;

public class Cloud implements Runnable {
    private Point2D startPoint;
    private int height;
    private int width;
    private Color color;
    private Thread thread;


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

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            startPoint.setX(startPoint.getX() + 5);
            height--;
            width--;
            try {
                thread.sleep(30);
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