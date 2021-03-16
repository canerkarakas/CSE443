package MidTermPack;

/**
 * Lithium Bor battery class
 */
public class LitBorBattery implements Battery{
    private String _batteryName = "Lithium-Boron";
    @Override
    public String get_batteryName() {
        return _batteryName;
    }

    @Override
    public void set_batteryName(String batteryName) {
        this._batteryName = batteryName;
    }

}
