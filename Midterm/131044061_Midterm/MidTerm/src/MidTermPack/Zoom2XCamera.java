package MidTermPack;

/**
 * 2x zoom camera class
 */
public class Zoom2XCamera implements Camera{
    private String _cameraName = "Opt. zoom x2";
    @Override
    public String get_cameraName() {
        return this._cameraName;
    }

    @Override
    public void set_cameraName(String cameraName) {
        this._cameraName = cameraName;
    }
}
