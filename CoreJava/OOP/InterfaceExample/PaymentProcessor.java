package OOP.InterfaceExample;

public interface PaymentProcessor {
    int RETRY_ATTEMPTS = 5;

    void processPayment(PaymentData paymentData); //abstract method doesn't have body

    default void setRetryAttempts(){ //default method has body
        System.out.println("Retrying payment process...");
    }

    static void getPaymentMethod(){ //static method has body. static method can be called without an object.
        System.out.println("Retriving payment method...");
    }
}
