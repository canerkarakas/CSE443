package MidTermPack;

/**
 * Model abstract class
 */
public abstract class Model {
    protected Battery _battery;
    protected Camera _camera;
    protected Case _case;
    protected CPURAM _cpu_ram;
    protected Display _display;
    protected Storage _storage;
    protected String _model_name = null;
    protected abstract void set_batteryName(Battery battery);
    protected abstract void set_cameraName(Camera camera);
    protected abstract void set_caseName(Case case_);
    protected abstract void set_cpu_ramName(CPURAM cpuram);
    protected abstract void set_displayName(Display display);
    protected abstract void set_storageName(Storage storage);
    protected abstract void set_modelName(String _modelName);


    public String get_batteryName() {
        return this._battery.get_batteryName();
    }

    public String get_cameraName() {
        return this._camera.get_cameraName();
    }

    public String get_caseName() {
        return this._case.get_caseName();
    }

    public String get_cpu_ramName() {
        return this._cpu_ram.get_cpuramName();
    }


    public String get_displayName() {
        return this._display.get_displayName();
    }


    public String get_storageName() {
        return this._storage.get_storageName();
    }

    public String get_model_name() {return this._model_name;}

    @Override
    public String toString() {
        return "MobilePhone{ " +
                "battery=" + _battery.get_batteryName() +
                ", camera=" + _camera.get_cameraName() +
                ", case=" + _case.get_caseName() +
                ", cpu_ram=" + _cpu_ram.get_cpuramName() +
                ", display=" + _display.get_displayName() +
                ", storage=" + _storage.get_storageName() +
                ", model_name='" + _model_name + '\'' +
                '}';
    }
}
