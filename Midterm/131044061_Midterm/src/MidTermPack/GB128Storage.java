package MidTermPack;

/**
 * 128 gb storage class
 */
public class GB128Storage implements Storage{
    private String _storageName = "Max 128 GB";
    @Override
    public String get_storageName() {
        return _storageName;
    }

    @Override
    public void set_storageName(String storageName) {
        _storageName = storageName;
    }
}
