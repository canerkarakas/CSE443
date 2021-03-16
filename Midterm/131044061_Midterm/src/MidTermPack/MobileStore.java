package MidTermPack;

/**
 * Mobile Store abstract class
 */
public abstract class MobileStore {
    protected MobilePhoneFactory _mobilePhoneFactory;
    protected Model _model;
    protected Battery _battery;
    protected Camera _camera;
    protected Case _case;
    protected CPURAM _cpu_ram;
    protected Display _display;
    protected Storage _storage;
    protected String _storeName;

    protected void set_storeName(String storeName) {
        this._storeName = storeName;
    }


    public String get_storeName() {
        return _storeName;
    }

    public Model createMobilePhone(String modelName) {
        if (modelName.equals("IflasDeluxe")) {
            _model = new IflasDeluxe();
        }
        if (modelName.equals("IIAmanIflas")){
            _model = new IIAmanIflas();
        }
        if (modelName.equals("MaximumEffort")){
            _model = new MaximumEffort();
        }
        this._cpu_ram = this._mobilePhoneFactory.attachCentralProcessUnitAndRandomMemoryAccess();
        _model.set_cpu_ramName(this._cpu_ram);
        System.out.println(_model.get_cpu_ramName());
        this._display = this._mobilePhoneFactory.attachDisplay();
        _model.set_displayName(this._display);
        System.out.println(_model.get_displayName());
        this._battery = this._mobilePhoneFactory.attachBattery();
        _model.set_batteryName(this._battery);
        System.out.println(_model.get_batteryName());
        this._storage = this._mobilePhoneFactory.attachStorage();
        _model.set_storageName(this._storage);
        System.out.println(_model.get_storageName());
        this. _camera = this._mobilePhoneFactory.attachCamera();
        _model.set_cameraName(this._camera);
        System.out.println(_model.get_cameraName());
        this._case = this._mobilePhoneFactory.attachCase();
        _model.set_caseName(this._case);
        System.out.println(_model.get_caseName());

        System.out.println(_model.get_model_name() + " Phone' s components : " + _model.get_displayName() +
                 ", " + _model.get_batteryName()+ ", " + _model.get_cpu_ramName() + ", "+ _model.get_storageName() +
                ", " + _model.get_cameraName() + ", " + _model.get_caseName());

        return _model;
    }
}
