package MidTermPack;

/**
 * Europe Factory class
 * 24 bit display
 * lithium ion battery
 * 4 cores cpu
 * 64 gb storage
 * 3x zoom camera
 * 1 meter water proof case
 */
public class EUFactory implements MobilePhoneFactory{


    @Override
    public Display attachDisplay() {
        return new Bit24Display();
    }

    @Override
    public Battery attachBattery() {
        return new LitIonBattery();
    }

    @Override
    public CPURAM attachCentralProcessUnitAndRandomMemoryAccess() {
        return new Cores4CPURAM();
    }

    @Override
    public Storage attachStorage() {
        return new GB64Storage();
    }

    @Override
    public Camera attachCamera() {
        return new Zoom3XCamera();
    }

    @Override
    public Case attachCase() {
        return new Waterproof1MeterCase();
    }
}
