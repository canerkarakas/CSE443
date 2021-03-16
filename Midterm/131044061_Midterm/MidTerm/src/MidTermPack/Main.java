package MidTermPack;

public class Main {
    public static void main(String[] args) {
        MobileStore mobileStore = new TurkeyStore("Turkey Factory");
        Model model = mobileStore.createMobilePhone("MaximumEffort");
        System.out.println(model);
        System.out.println("----------");
        model = mobileStore.createMobilePhone("IIAmanIflas");
        System.out.println(model);
        System.out.println("----------");
        model = mobileStore.createMobilePhone("IflasDeluxe");
        System.out.println(model);
        System.out.println("----------");
        mobileStore = new GlobalStore("Global Factory");
        model = mobileStore.createMobilePhone("MaximumEffort");
        System.out.println(model);
        System.out.println("----------");
        model = mobileStore.createMobilePhone("IIAmanIflas");
        System.out.println(model);
        System.out.println("----------");
        model = mobileStore.createMobilePhone("IflasDeluxe");
        System.out.println(model);
        System.out.println("----------");
        mobileStore = new EUStore("EU Factory");
        model = mobileStore.createMobilePhone("MaximumEffort");
        System.out.println(model);
        System.out.println("----------");
        model = mobileStore.createMobilePhone("IIAmanIflas");
        System.out.println(model);
        System.out.println("----------");
        model = mobileStore.createMobilePhone("IflasDeluxe");
        System.out.println(model);
        System.out.println("----------");
    }
}
