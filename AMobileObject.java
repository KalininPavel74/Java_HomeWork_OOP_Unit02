package unit2;

abstract public class AMobileObject extends AName implements IMobileObject {
    protected int speed;
    protected int height;
    @Override public int getSpeed() {
        return speed;
    }
    @Override public int getHeight() {
        return height;
    }

}
