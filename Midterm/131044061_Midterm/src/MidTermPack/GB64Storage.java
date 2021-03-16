package MidTermPack;

/**
 * 64 gb storage class
 */
public class GB64Storage implements Storage{

    private String _storageName = "Max 64 GB";
    @Override
    public String get_storageName() {
        return _storageName;
    }

    @Override
    public void set_storageName(String storageName) {
        _storageName = storageName;
    }
}
