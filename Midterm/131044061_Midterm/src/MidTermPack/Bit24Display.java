package MidTermPack;

/**
 * 24 bit display class
 */
public class Bit24Display implements Display{

    private String _displayName = "24 bit";

    /**
     * @return display name
     */
    @Override
    public String get_displayName() {
        return _displayName;
    }

    /**
     * @param displayName updating display name
     */
    @Override
    public void set_diplayName(String displayName) {
        this._displayName = displayName;
    }
}
