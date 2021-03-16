package MidTermPack3;

/**
 * Command interface
 */
public interface Command {

    void execute(String _data);
    void undo();
}
