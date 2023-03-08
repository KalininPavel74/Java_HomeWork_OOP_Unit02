package unit2;

abstract public class AObstacle extends AName implements IName {
    static private final String LUCK = "Справился.";
    static private final String FALL = "Упал.";
    protected String luckMessage = LUCK;
    protected String fallMessage = FALL;
    public String getLuckMessage() { return luckMessage; }
    public String getFallMessage() { return fallMessage; }
    boolean overcome(IMobileObject mobileObject) throws Exception {
        if(this instanceof IRun)
            return mobileObject.getSpeed() >= ((IRun) this).getSpeed();
        else if(this instanceof IJump)
            return mobileObject.getHeight() >= ((IJump) this).getHeight();
        throw new Exception("Препятствие неизвестного типа - "+name);
    }
}
