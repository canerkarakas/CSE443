package MidTermPack;

/**
 * 32 gb storage class
 */
public class GB32Storage implements Storage{
    private String _storageName = "Max 32 GB";
    @Override
    public String get_storageName() {
        return _storageName;
    }

    @Override
    public void set_storageName(String storageName) {
        _storageName = storageName;
    }


}
