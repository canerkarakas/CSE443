package MidTermPack;

/**
 * Mobile Phone Factory interface
 */
public interface MobilePhoneFactory {

    /**
     * attaching display
     * @return Display
     */
    Display attachDisplay();
    /**
     * attaching battery
     * @return Battery
     */
    Battery attachBattery();
    /**
     * attaching cpu and ram
     * @return CPURAM
     */
    CPURAM attachCentralProcessUnitAndRandomMemoryAccess();
    /**
     * attaching storage
     * @return Storage
     */
    Storage attachStorage();
    /**
     * attaching camera
     * @return Camera
     */
    Camera attachCamera();
    /**
     * attaching case
     * @return Case
     */
    Case attachCase();

}
