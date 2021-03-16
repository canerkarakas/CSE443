package MidTermPack;

/**
 * Turkey Factory class
 * 32 bit display
 * lithium bor battery
 * 8 cores cpu
 * 128 gb storage
 * 4x zoom camera
 * 2 meter water proof case
 */
public class TurkeyFactory implements MobilePhoneFactory{

    @Override
    public Display attachDisplay() {
        return new Bit32Display();
    }

    @Override
    public Battery attachBattery() {
        return new LitBorBattery();
    }

    @Override
    public CPURAM attachCentralProcessUnitAndRandomMemoryAccess() {
        return new Cores8CPURAM();
    }

    @Override
    public Storage attachStorage() {
        return new GB128Storage();
    }

    @Override
    public Camera attachCamera() {
        return new Zoom4XCamera();
    }

    @Override
    public Case attachCase() {
        return new Waterproof2MetersCase();
    }
}
