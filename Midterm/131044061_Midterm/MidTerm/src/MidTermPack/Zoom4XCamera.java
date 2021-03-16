package MidTermPack;

/**
 * 4x zoom camera class
 */
public class Zoom4XCamera implements Camera{
    private String _cameraName = "Opt. zoom x4";
    @Override
    public String get_cameraName() {
        return this._cameraName;
    }

    @Override
    public void set_cameraName(String cameraName) {
        this._cameraName = cameraName;
    }


}
