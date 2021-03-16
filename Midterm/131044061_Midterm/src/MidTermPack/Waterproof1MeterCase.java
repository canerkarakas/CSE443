package MidTermPack;

/**
 * 1 meter water proof case
 */
public class Waterproof1MeterCase implements Case{
    private String _caseName = "Waterproof up to 1m";
    @Override
    public String get_caseName() {
        return _caseName;
    }

    @Override
    public void set_caseName(String caseName) {
        this._caseName = caseName;
    }
}
