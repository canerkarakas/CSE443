package MidTermPack;

/**
 * 3x zoom camera class
 */
public class Zoom3XCamera implements Camera{
    private String _cameraName = "Opt. zoom x3";
    @Override
    public String get_cameraName() {
        return this._cameraName;
    }

    @Override
    public void set_cameraName(String cameraName) {
        this._cameraName = cameraName;
    }
}
