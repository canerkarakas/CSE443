package MidTermPack;

/**
 * CPU AND RAM interface
 */
public interface CPURAM {
    /**
     * @return cpu and ram name
     */
    String get_cpuramName();

    /**
     * @param cpuramyName determining the cpu and ram name
     */
    void set_cpuramName(String cpuramyName);
}
