import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main 
{
    public static void main(String[] args) 
    {
        DecimalFormat currencyFormat = new DecimalFormat("$#.00");
        
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Wolfville store");
        System.out.println("Please select between our 3 options");

        System.out.println("1 -- to buy and checkout");
        System.out.println("2 -- to Return");
        System.out.println("3 -- to join our Special program");

        System.out.println("Enter your choice (1, 2 or 3): ");

        choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Please enter either 1, 2 or 3");
            choice = input.nextInt();
        }

        Map<Integer, CProduct> products = CProduct.getAllCProducts(); // Create a map of products
        CLoyaltyCardDetails loyaltyCardDetails = new CLoyaltyCardDetails(); // Create an instance of LoyaltyCardDetails
    

        switch (choice) 
        {
            case 1:
                CCheckoutSystem checkoutSystem = new CCheckoutSystem(products, loyaltyCardDetails);
                checkoutSystem.checkout();
                break;

            case 2:
                processReturns(products);
                break;

            case 3:
                joinLoyaltyProgram(loyaltyCardDetails);
                break;
                
        }
        input.close();
    }

    public static void processReturns(Map<Integer, CProduct> products) 
    {   
        DecimalFormat currencyFormat = new DecimalFormat("$#.00");
        double totalReturnedAmount = 0.0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the Serial number of the item you want to return (-1 to finish): ");
        
        while (true) 
        {   int serialNumber = input.nextInt();

            if (serialNumber == -1) 
            {
                break;
            }
            if (products.containsKey(serialNumber)) 
            {
                CReturns returnHandler = new CReturns(0, 0);
                double returnedAmount = returnHandler.makeReturn(serialNumber, products);
                System.out.println("amount returned: " + currencyFormat.format(returnedAmount));
                totalReturnedAmount += returnedAmount;
            } 
            else 
            {
                System.out.println("Product not found with the given serial number.");
            }
        }

        System.out.println("Total amount returned: " + totalReturnedAmount);
        input.close();
    }

    public static void joinLoyaltyProgram(CLoyaltyCardDetails loyaltyCardDetails)  
    {
        // Implement the logic for joining the loyalty program
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a unique card number you want to have: ");
        String card_number = input.nextLine();

        System.out.println("Please enter a unique code  you want to have: ");
        int code = input.nextInt();

        // Write the loyalty card information to a file
        writeLoyaltyCardToFile(card_number, code);

        loyaltyCardDetails.addCard(card_number, code);
        System.out.println("You have successfully joined the loyalty program.");
        input.close();
    }
    private static void writeLoyaltyCardToFile(String cardNumber, int code) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("LoyaltyProgramMembers.txt", true))) 
        {
            // Append the loyalty card information to the file
            writer.write(cardNumber + "," + code);

            writer.newLine();  // Add a new line for the next entry
        } 
        catch (IOException e) 

        {
            e.printStackTrace();
        }
    }
}