package ecommerce;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PaymentHandlerTest class tests the functionality of the PaymentHandler class.
 * Ensures that payments are processed correctly with valid and invalid inputs.
 */
public class PaymentHandlerTest {
    @Test
    public void testHandlePaymentSuccess() {
        PaymentHandler paymentHandler = new PaymentHandler();
        double amount = 100.0;
        String paymentMethod = "Credit Card";
        assertTrue(paymentHandler.handlePayment(amount, paymentMethod));
    }

    @Test
    public void testHandlePaymentInvalidAmount() {
        PaymentHandler paymentHandler = new PaymentHandler();
        double invalidAmount = -50.0;
        String paymentMethod = "Credit Card";
        assertFalse(paymentHandler.handlePayment(invalidAmount, paymentMethod));
    }

    @Test
    public void testHandlePaymentInvalidMethod() {
        PaymentHandler paymentHandler = new PaymentHandler();
        double amount = 50.0;
        String invalidMethod = "Invalid Method";
        assertFalse(paymentHandler.handlePayment(amount, invalidMethod));
    }
}
