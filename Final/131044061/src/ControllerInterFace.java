public interface ControllerInterFace {
    void start();
    void stop();
    void resume();
    void increaseNOP();
    void addBulk(int NOP);
    void undo();
}
