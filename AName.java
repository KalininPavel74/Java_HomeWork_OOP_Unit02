package unit2;

public class AName implements IName {
    protected String name;
    protected String symbol;
    @Override public String getName() { return name; }
    @Override public String getSymbol() { return symbol; }
}
