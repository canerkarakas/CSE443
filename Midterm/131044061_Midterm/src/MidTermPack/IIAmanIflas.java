package MidTermPack;

public class IIAmanIflas extends Model{
    private String _batteryName = "MicroSD support 16GB ";
    private String _cameraName = "8Mp front 5Mp rear ";
    private String _caseName = "143x69x7.3 mm waterproof plastic ";
    private String _cpu_ramName = "2.2GHz 4GB ";
    private String _displayName = "4.5 inches ";
    private String _storageName = "16h 2000mAh ";

    public IIAmanIflas(){
        set_modelName("kralsiin");
    }

    @Override
    protected void set_batteryName(Battery battery) {
        this._battery = battery;
        this._battery.set_batteryName(battery.get_batteryName() + " " + this._batteryName);
    }

    @Override
    protected void set_cameraName(Camera camera) {
        this._camera = camera;
        this._camera.set_cameraName(camera.get_cameraName() + " " + this._cameraName);
    }

    @Override
    protected void set_caseName(Case case_) {
        this._case = case_;
        this._case.set_caseName(case_.get_caseName() + " " + this._caseName);
    }

    @Override
    protected void set_cpu_ramName(CPURAM cpuram) {
        this._cpu_ram = cpuram;
        this._cpu_ram.set_cpuramName(cpuram.get_cpuramName()+ " " + this._cpu_ramName);
    }

    @Override
    protected void set_displayName(Display display) {
        this._display = display;
        this._display.set_diplayName(display.get_displayName() + " " + this._displayName);
    }

    @Override
    protected void set_storageName(Storage storage) {
        this._storage = storage;
        this._storage.set_storageName(storage.get_storageName() + " " + this._storageName);
    }

    @Override
    protected void set_modelName(String _modelName) {
        this._model_name = "IIAmanIflas";
    }

}
