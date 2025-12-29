package OOP.InterfaceExample;

public class Client {
    private PaymentProcessor paymentProcessor;

    {
        paymentProcessor = new PayPalPaymentProcessor(); //setting default payment process
    }

    public void checkout(PaymentData paymentData){
        paymentProcessor.processPayment(paymentData);
        paymentProcessor.setRetryAttempts();
        PaymentProcessor.getPaymentMethod();
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }
}
