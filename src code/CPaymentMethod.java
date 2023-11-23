/**
 * Represents a payment method handler with methods to process different payment types.
 */
public class CPaymentMethod 
{
    // Constants representing payment outcomes
    public static final int PAYMENT_SUCCESS = 0;
    public static final int INVALID_PAYMENT_METHOD = 1;

    /**
     * Processes the payment based on the provided payment method.
     *
     * @param paymentMethod The payment method to be processed
     * @return The payment outcome (success or failure)
     */
    public int processPayment(String paymentMethod) 
    {
        if (paymentMethod.equalsIgnoreCase("debit")) 
        {
            System.out.println("Processing Debit card payment...");
            return PAYMENT_SUCCESS;

        } 
        else if (paymentMethod.equalsIgnoreCase("credit")) 
        {
            System.out.println("Processing Credit card payment...");
            return PAYMENT_SUCCESS;

        } 

        else if (paymentMethod.equalsIgnoreCase("cash")) 
        {
            System.out.println("Processing Cash payment...");
            return PAYMENT_SUCCESS;

        } 

        else if (paymentMethod.equalsIgnoreCase("loyalty card")) 
        {
            System.out.println("Processing Loyalty Card payment...");
            return PAYMENT_SUCCESS;

        }
         
        else 
        {
            System.out.println("Invalid payment method. Please choose a valid option.");
            return INVALID_PAYMENT_METHOD;
        }
    }
}
