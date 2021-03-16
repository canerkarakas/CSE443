package MidTermPack;

/**
 * global Store
 */
public class GlobalStore extends MobileStore{
    /**
     * Constructor for GlobalStore
     * @param globalFactoryName String is taken for object creation
     */
    public GlobalStore(String globalFactoryName){
        if (globalFactoryName.equals("Global Factory")) {
            this._mobilePhoneFactory = new GlobalFactory();
            this.set_storeName("Global Store's mobile phone");
        }
    }
}
