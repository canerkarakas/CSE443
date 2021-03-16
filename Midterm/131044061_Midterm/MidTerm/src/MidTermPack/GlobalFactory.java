package MidTermPack;

/**
 * Global Factory class
 * 24 bit display
 * lithium cobalt battery
 * 2 cores cpu
 * 32 gb storage
 * 2x zoom camera
 * 50 cm water proof case
 */
public class GlobalFactory implements MobilePhoneFactory {

    @Override
    public Display attachDisplay() {
        return new Bit24Display();
    }

    @Override
    public Battery attachBattery() {
        return new LitCobBattery();
    }

    @Override
    public CPURAM attachCentralProcessUnitAndRandomMemoryAccess() {
        return new Cores2CPURAM();
    }

    @Override
    public Storage attachStorage() {
        return new GB32Storage();
    }

    @Override
    public Camera attachCamera() {
        return new Zoom2XCamera();
    }

    @Override
    public Case attachCase() {
        return new Waterproof50CMCase();
    }
}
