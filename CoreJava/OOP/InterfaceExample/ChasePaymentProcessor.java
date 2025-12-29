package OOP.InterfaceExample;

public class ChasePaymentProcessor implements PaymentProcessor, PaymentValidator{
    @Override
    public void processPayment(PaymentData paymentData) {
        System.out.println("Proceeding with Chase payment process...");
    }

    @Override
    public void setRetryAttempts() {
        PaymentProcessor.super.setRetryAttempts();
        System.out.println("Retrying the payment process inside the Chase payment processor...");
    }

    @Override
    public void validatePayment(PaymentData paymentData) {
        System.out.println("Validating Chase payment...");
    }
}
