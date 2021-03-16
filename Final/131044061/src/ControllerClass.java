public class ControllerClass implements ControllerInterFace{
    private GUI gui;
    private ModelInterface modelInterface;

    public ControllerClass(ModelInterface modelInterface){
        this.modelInterface = modelInterface;
        gui = new GUI(this, this.modelInterface);
        gui.createView();
        gui.createControls();
        gui.createView2();
    }

    @Override
    public void start() {
        modelInterface.initialize(gui.getMemento());
    }

    @Override
    public void stop() {
        modelInterface.stop(gui.getMemento());
    }

    @Override
    public void resume() {
        modelInterface.resume(gui.getMemento());
    }

    @Override
    public void increaseNOP() {
        modelInterface.increaseNOP(gui.getMemento());
    }

    @Override
    public void addBulk(int NOP) {
        modelInterface.addBulk(NOP, gui.getMemento());
    }

    @Override
    public void undo() {
        modelInterface.undo(gui.getMemento());
    }
}
