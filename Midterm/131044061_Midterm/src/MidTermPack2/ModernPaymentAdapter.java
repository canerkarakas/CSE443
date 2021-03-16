package MidTermPack2;

/**
 * modern payment adapter from turbo payment to modern payment
 */
public class ModernPaymentAdapter implements TurboPayment{

    private ModernPayment modernPayment;

    public ModernPaymentAdapter(ModernPayment modernPayment){
        if (modernPayment.getClass() == ModernPaymentClass.class)
            this.modernPayment = modernPayment;
    }

    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return this.modernPayment.pay(turboCardNo, turboAmount, destinationTurboOfCourse, installmentsButInTurbo);
    }
}
