package MidTermPack;

/**
 * Turkey Store
 */
public class TurkeyStore extends MobileStore {
    /**
     * Constructor for TurkeyStore
     * @param mobileFactoryName String is taken for object creation
     */
    public TurkeyStore(String mobileFactoryName){
        if (mobileFactoryName.equals("Turkey Factory")){
            this._mobilePhoneFactory = new TurkeyFactory();
            this.set_storeName("Turkey Store's mobile phone");
        }
    }

}
