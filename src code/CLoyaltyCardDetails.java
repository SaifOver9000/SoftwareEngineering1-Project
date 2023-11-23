import java.util.HashMap;
import java.util.Map;

/**
 * Represents details related to loyalty cards, including card numbers and unique codes.
*/
public class CLoyaltyCardDetails 

{
    // Map to store card details (card number -> unique code)
    private Map<String, Integer> _cardDetails;

    /**
     * Constructs a loyalty card details object with an empty map.
     */
    public CLoyaltyCardDetails() {
        this._cardDetails = new HashMap<>();
    }

    /**
     * Adds a loyalty card to the details with the provided card number and unique code.
     *
     * @param cardNumber The card number to be added
     * @param uniqueCode The unique code associated with the card
     */
    public void addCard(String cardNumber, int uniqueCode) {
        _cardDetails.put(cardNumber, uniqueCode);
    }

}