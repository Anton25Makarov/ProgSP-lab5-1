public class RandomGenerator {
    public int generateInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public Point2D generatePoint2D(int min, int max) {
        int x = generateInt(min, max);
        int y = generateInt(min, max);

        return new Point2D(x, y);
    }

}