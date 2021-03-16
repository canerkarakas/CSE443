package MidTermPack;

/**
 * 50 cm water proof case
 */
public class Waterproof50CMCase implements Case{
    private String _caseName = "Waterproof up to 50cm";
    @Override
    public String get_caseName() {
        return _caseName;
    }

    @Override
    public void set_caseName(String caseName) {
        this._caseName = caseName;
    }

}
