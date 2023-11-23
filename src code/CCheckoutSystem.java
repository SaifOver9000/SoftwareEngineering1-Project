import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a checkout system for processing product purchases.
 */
public class CCheckoutSystem {

    // Formatting currency values
    private final DecimalFormat currencyFormat = new DecimalFormat("$#.00");

    // Map of product serial numbers to products
    private final Map<Integer, CProduct> products;

    // Loyalty card for handling loyalty points
    private final CLoyaltyCard loyaltyCard;

    /**
     * Constructs a checkout system with the given products and loyalty card details.
     *
     * @param products           Map of product serial numbers to products
     * @param loyaltyCardDetails Loyalty card details (currently not used)
     */
    public CCheckoutSystem(Map<Integer, CProduct> products, CLoyaltyCardDetails loyaltyCardDetails) {
        this.products = products;
        this.loyaltyCard = new CLoyaltyCard();
    }

    /**
     * Initiates the checkout process, allowing the user to select products and complete the purchase.
     */
    public void checkout() {
        Scanner scanner = new Scanner(System.in);
        double subtotal = 0;

        List<CProduct> purchasedProducts = new ArrayList<>();
        System.out.println("Available Products:");
        products.forEach((key, value) -> System.out.println("Serial Number: " + key + ", Name: " + value.getName() +
                ", Price: $" + value.getPrice()));

        System.out.println("Select items to add to the cart (enter serial number, -1 to finish): ");
        int serialNumber;

        while (true) {
            try {
                serialNumber = scanner.nextInt();
                if (serialNumber == -1) {
                    break;
                } else if (products.containsKey(serialNumber)) {
                    CProduct product = products.get(serialNumber);
                    System.out.println("Added: " + product.getName() + " - $" + product.getPrice());
                    purchasedProducts.add(product);
                    subtotal += product.getPrice();
                } else {
                    System.out.println("Invalid serial number. Please try again.");
                }
            } catch (Exception e) {
                System.err.println(e);
                return;
            }
        }

        double tax = 0.15 * subtotal;
        double total = subtotal + tax;

        displayOrderDetails(subtotal, tax, total);
        System.out.println();
        boolean hasLoyaltyCard = handleLoyaltyCard(scanner, total);
        processPayment(scanner, new CPaymentMethod(), hasLoyaltyCard);
    }

    /**
     * Displays the order details, including subtotal, tax, and total.
     *
     * @param subtotal The subtotal of the purchase
     * @param tax      The tax amount
     * @param total    The total amount to be paid
     */
    private void displayOrderDetails(double subtotal, double tax, double total) {
        System.out.println("------ YOUR ORDER ------");
        System.out.println("Subtotal: " + currencyFormat.format(subtotal) + "\n");
        System.out.printf("Tax: " + currencyFormat.format(tax) + "\n");
        System.out.printf("Total: " + currencyFormat.format(total) + "\n");
    }

    /**
     * Handles the loyalty card details input from the user.
     *
     * @param scanner The scanner for user input
     * @param total   The total amount of the purchase
     * @return True if the user has a loyalty card, false otherwise
     */
    private boolean handleLoyaltyCard(Scanner scanner, double total) {
        System.out.print("Do you have a loyalty card? (yes/no): ");
        String hasLoyaltyCard = scanner.next();

        if (hasLoyaltyCard.equalsIgnoreCase("yes")) {
            System.out.print("Enter your loyalty card number: ");
            String cardNumber = scanner.next();

            System.out.print("Enter the unique code on your card: ");
            int uniqueCode = scanner.nextInt();

            if (validCardChecker(cardNumber, uniqueCode)) {
                loyaltyCard.add_points((int) total);
                System.out.println("Points added to your loyalty card: " + (int) total);
                System.out.println("Total points in your account: " + loyaltyCard.get_points());
                return true;
            } else {
                System.out.println("Invalid loyalty card details. Points not added.");
            }
        }
        return false;
    }

    /**
     * Processes the payment based on the chosen payment method.
     *
     * @param scanner        The scanner for user input
     * @param paymentMethod  The payment method to be used
     * @param hasLoyaltyCard True if the user has a loyalty card, false otherwise
     */
    private void processPayment(Scanner scanner, CPaymentMethod paymentMethod, boolean hasLoyaltyCard) {
        while (true) {
            System.out.print("Enter your payment method (Debit, Credit, Cash, Loyalty Card): ");
            String chosenPaymentMethod = scanner.nextLine();

            if (chosenPaymentMethod.equalsIgnoreCase("Loyalty Card") && !hasLoyaltyCard) {
                System.out.println("Loyalty card not present. You cannot use it as a payment method.");
                System.out.println("Transaction failed. Please enter a valid payment method");
            } else {
                int paymentResult = paymentMethod.processPayment(chosenPaymentMethod);

                if (paymentResult == CPaymentMethod.PAYMENT_SUCCESS) {
                    System.out.println("Transaction completed.");
                    break;
                } else {
                    System.out.println("Transaction failed. Please enter a valid payment method");
                }
            }
        }
    }

    /**
     * Checks the validity of the loyalty card details by comparing them with stored data.
     *
     * @param givenCardNumber  The loyalty card number provided by the user
     * @param givenUniqueCode  The unique code provided by the user
     * @return True if the card details are valid, false otherwise
     */
    private boolean validCardChecker(String givenCardNumber, int givenUniqueCode) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("LoyaltyProgramMembers.txt"));
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] sections = line.split(",");

                String containedCardNumber = sections[0];
                int containedUniqueCode = Integer.parseInt(sections[1]);

                if (containedCardNumber.equals(givenCardNumber) && (containedUniqueCode == givenUniqueCode)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error");
        }
        return false;
    }
}
