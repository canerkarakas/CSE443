package MidTermPack;

/**
 * 8 core cpu ram
 */
public class Cores8CPURAM implements CPURAM{
    private String _cpuramName = "8 cores";

    @Override
    public String get_cpuramName() {
        return _cpuramName;
    }

    @Override
    public void set_cpuramName(String cpuramyName) {
        this._cpuramName = cpuramyName;
    }
}
