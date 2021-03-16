package MidTermPack2;

/**
 * Turbo payment interface
 */
public interface TurboPayment {
    int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo);
}
