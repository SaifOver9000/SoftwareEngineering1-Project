import java.util.Map;

/**
 * Represents a class for processing returns, including quantity and amount information.
 */

public class CReturns 
{  
    // Attributes for quantity and amount
    private int _quantity;
    private double _amount;

    /**
     * Constructs a return object with the given amount and quantity.
     *
     * @param _amount   The amount associated with the return
     * @param _quantity The quantity associated with the return
     */
    public CReturns(double _amount,int _quantity) 
    {   
        
        this._quantity = _quantity;
        this._amount = _amount;   
    }

    /**
     * Gets the amount associated with the return.
     *
     * @return The amount associated with the return
     */

    public double get_amount() 
    {
        return _amount;
    }

    /**
     * Gets the quantity associated with the return.
     *
     * @return The quantity associated with the return
     */
    public int get_quantity() 
    {
        return _quantity;
    }

    /**
     * Sets the amount associated with the return.
     *
     * @param _amount The amount to set
     */

    public void set_amount(double _amount) 
    {
        this._amount = _amount;
    }
    /**
     * Sets the quantity associated with the return.
     *
     * @param _quantity The quantity to set
     */

    public void set_quantity(int _quantity) 
    {
        this._quantity = _quantity;
    }

    /**
     * Processes a return for the specified product serial number.
     *
     * @param _serialNumber The serial number of the product to be returned
     * @param products      The map of products where the product is looked up
     * @return The amount to be refunded for the return
     */

    public double makeReturn(int _serialNumber, Map<Integer, CProduct> products) 
    {
        double returnedAmount = 0.0;

        CProduct product = products.get(_serialNumber);
        if (product != null) 
        {   
            returnedAmount = product.getPrice();
            System.out.println("Return processed successfully."); 
            return returnedAmount; 
        
        }
        else 
        {
            System.out.println("Product not found with the given serial number.");
            return returnedAmount;
            
        }
        


    }


       

    
}
