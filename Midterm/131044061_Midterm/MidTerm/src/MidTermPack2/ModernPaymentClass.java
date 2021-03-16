package MidTermPack2;

public class ModernPaymentClass implements ModernPayment{



    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("ModernPaymentClass!!!");
        return 0;
    }
}
