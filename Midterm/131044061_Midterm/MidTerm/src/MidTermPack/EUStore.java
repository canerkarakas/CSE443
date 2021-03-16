package MidTermPack;

/**
 * European Store
 */
public class EUStore extends MobileStore{
    /**
     * Constructor for EUStore
     * @param euFactoryName String is taken for object creation
     */
    public EUStore(String euFactoryName){
        if (euFactoryName.equals("EU Factory")) {
            this._mobilePhoneFactory = new EUFactory();
            this.set_storeName("EU Store's mobile phone");
        }
    }
}
