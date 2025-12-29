package OOP.InterfaceExample;

public class PayPalPaymentProcessor implements PaymentProcessor, PaymentValidator{
    @Override
    public void processPayment(PaymentData paymentData) {
        System.out.println("Proceeding with PayPal payment process...");
    }

    @Override
    public void validatePayment(PaymentData paymentData) {
        System.out.println("Validating PayPal Payment...");
    }
}
