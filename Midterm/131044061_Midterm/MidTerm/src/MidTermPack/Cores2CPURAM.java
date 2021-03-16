package MidTermPack;

/**
 * 2 core cpu ram
 */
public class Cores2CPURAM implements CPURAM{
    private String _cpuramName = "2 cores";

    @Override
    public String get_cpuramName() {
        return _cpuramName;
    }

    @Override
    public void set_cpuramName(String cpuramyName) {
        this._cpuramName = cpuramyName;
    }

}
