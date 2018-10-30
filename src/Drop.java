public class Drop implements Runnable {
    private Point2D highPoint;
    private Point2D lowPoint;
    private Point2D lowCriticalPoint;
    private Thread thread;


    public Drop(Point2D highPoint, Point2D lowPoint, Point2D lowCriticalPoint) {
        thread = new Thread(this);
        this.highPoint = highPoint;
        this.lowPoint = lowPoint;
        this.lowCriticalPoint = lowCriticalPoint;
        thread.start();
    }

    public Drop(Point2D highPoint, Point2D lowPoint) {
        synchronized (this) {
            thread = new Thread(this);
            this.highPoint = highPoint;
            this.lowPoint = lowPoint;
            this.lowCriticalPoint = new Point2D(0, 500);
            thread.start();
        }
    }

    @Override
    public void run() {
        synchronized (this) {
            while (highPoint.getY() < lowCriticalPoint.getY()) {
                highPoint.setY(highPoint.getY() + 1);
                lowPoint.setY(lowPoint.getY() + 1);
                try {
                    thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public Point2D getHighPoint() {
        return highPoint;
    }

    public void setHighPoint(Point2D highPoint) {
        this.highPoint = highPoint;
    }

    public Point2D getLowPoint() {
        return lowPoint;
    }

    public void setLowPoint(Point2D lowPoint) {
        this.lowPoint = lowPoint;
    }

    public Point2D getLowCriticalPoint() {
        return lowCriticalPoint;
    }

    public void setLowCriticalPoint(Point2D lowCriticalPoint) {
        this.lowCriticalPoint = lowCriticalPoint;
    }
}
