package MidTermPack;

/**
 * 4 core cpu ram
 */
public class Cores4CPURAM implements CPURAM{

    private String _cpuramName = "4 cores";

    @Override
    public String get_cpuramName() {
        return _cpuramName;
    }

    @Override
    public void set_cpuramName(String cpuramyName) {
        this._cpuramName = cpuramyName;
    }

}
