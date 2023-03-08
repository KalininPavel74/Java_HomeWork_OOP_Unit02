package unit2;

public class Treadmill extends AObstacle implements IRun {
    private int speed;
    public Treadmill(String name, String symbol, int speed, String luckMessage, String fallMessage) {
        this.name = name;
        this.symbol = symbol;
        this.speed = speed;
        this.luckMessage = (luckMessage != null) ? luckMessage : "пробежал успешно!";
        this.fallMessage = (fallMessage != null) ? fallMessage : "не выдержал темпа.";
    }
    public Treadmill(String name, String symbol, int speed) {
        this(name, symbol, speed, null, null);
    }
    public Treadmill(String name, int speed) {
        this(name, "", speed, null, null);
    }
    @Override public int getSpeed() { return speed; }
}
