package MidTermPack2;

/**
 * modern payment interface
 */
public interface ModernPayment {
    int pay(String cardNo, float amount, String destination, String installments);
}
