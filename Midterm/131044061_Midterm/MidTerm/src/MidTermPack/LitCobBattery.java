package MidTermPack;

/**
 * Lithium Cobalt battery class
 */
public class LitCobBattery implements Battery{
    private String _batteryName = "Lithium-Cobalt";

    @Override
    public String get_batteryName() {
        return _batteryName;
    }

    @Override
    public void set_batteryName(String batteryName) {
        this._batteryName = batteryName;
    }
}
