package ecommerce;

/**
 * PaymentHandler class simulates payment processing.
 * Follows the Single Responsibility Principle by focusing on payment validation and processing.
 */
public class PaymentHandler {
    /**
     * Processes a payment with the specified amount and payment method.
     * 
     * @param amount The amount to be paid.
     * @param paymentMethod The method of payment.
     * @return True if the payment is successful, false otherwise.
     */
    public boolean handlePayment(double amount, String paymentMethod) {
        if (isValidPaymentMethod(paymentMethod)) {
            if (amount > 0) {
                System.out.println("Processing payment of $" + amount + " via " + paymentMethod);
                System.out.println("Payment successful.");
                return true;
            } else {
                System.out.println("Invalid payment amount.");
            }
        } else {
            System.out.println("Invalid payment method.");
        }
        System.out.println("Payment processing failed.");
        return false;
    }

    /**
     * Validates the payment method.
     * 
     * @param paymentMethod The payment method to validate.
     * @return True if the payment method is valid, false otherwise.
     */
    private boolean isValidPaymentMethod(String paymentMethod) {
        return !"Invalid Method".equals(paymentMethod);
    }
}
