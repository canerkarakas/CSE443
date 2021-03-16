package MidTermPack2;

public class Main {
    public static void main(String[] args) {
        ModernPayment modernPayment = new ModernPaymentClass();
        TurboPayment modernPaymentAdapter = new ModernPaymentAdapter(modernPayment);
        modernPaymentAdapter.payInTurbo("asdsada", 3, "asdsad", "sdfdsfg");
    }
}
