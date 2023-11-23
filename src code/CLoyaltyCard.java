/**
 * Represents a loyalty card with points for a customer.
 */
public class CLoyaltyCard 
{
    // Points associated with the loyalty card
    private int _points;

    /**
     * Constructs a loyalty card with zero points.
     */

    public CLoyaltyCard() {
        this._points = 0;
    }
    /**
     * Gets the current points on the loyalty card.
     *
     * @return The current points on the loyalty card
     */
    public int get_points() {
        return _points;
    }
    /**
     * Adds points to the loyalty card.
     *
     * @param points The points to be added to the loyalty card
     */
    public void add_points(int _points) {
        this._points += _points;
    }
}