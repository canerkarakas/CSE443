package MidTermPack;

/**
 * Lithium Ion battery class
 */
public class LitIonBattery implements Battery{
    private String _batteryName = "Lithium-Ion";

    @Override
    public String get_batteryName() {
        return _batteryName;
    }

    @Override
    public void set_batteryName(String batteryName) {
        this._batteryName = batteryName;
    }
}
