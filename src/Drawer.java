import java.awt.*;

public class Drawer {

    public void drawCloud(Cloud cloud, Graphics graphics) {
        graphics.setColor(cloud.getColor());
        graphics.fillOval(cloud.getStartPoint().getX(), cloud.getStartPoint().getY(),
                cloud.getWidth(), cloud.getHeight());

    }

    public void drawDrop(Drop drop, Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.drawLine(drop.getHighPoint().getX(), drop.getHighPoint().getY(),
                drop.getLowPoint().getX(), drop.getLowPoint().getY());
    }
}
