package unit2;

public class Wall extends AObstacle implements IJump {
    private int height;
    public Wall(String name, String symbol, int height, String luckMessage, String fallMessage) {
        this.name = name;
        this.symbol = symbol;
        this.height = height;
        this.luckMessage = (luckMessage != null) ? luckMessage : "перепрыгнул успешно";
        this.fallMessage = (fallMessage != null) ? fallMessage : "не перелез";
    }
    public Wall(String name, String symbol, int height) { this(name, symbol, height, null, null); }
    public Wall(String name, int height) { this(name, "", height, null, null); }
    @Override public int getHeight() { return height; }
}
