package MidTermPack;

/**
 * 2 meter water proof case
 */
public class Waterproof2MetersCase implements Case{
    private String _caseName = "Waterproof up to 2m";
    @Override
    public String get_caseName() {
        return _caseName;
    }
    @Override
    public void set_caseName(String caseName) {
        this._caseName = caseName;
    }
}
