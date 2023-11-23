import java.util.HashMap;
import java.util.Map;

/**
 * Represents a product with a serial number, name, price, and quantity.
*/

public class CProduct 
{
    // Product attributes
    private int _serialNumber;
    private String _name;
    private double _price;
    private int _quantity;

    /**
     * Constructs a product with the given serial number, name, and price.
     *
     * @param _serialNumber The serial number of the product
     * @param _name         The name of the product
     * @param _price        The price of the product
     */

    public CProduct(int _serialNumber, String _name, double _price) 
    {
        this._serialNumber = _serialNumber;
        this._name = _name;
        this._price = _price;
        this._quantity = 1;
    }

    /**
     * Gets the serial number of the product.
     *
     * @return The serial number of the product
     */
    public int get_serialNumber() {
        return _serialNumber;
    }
    /**
     * Gets the name of the product.
     *
     * @return The name of the product
     */
    public String getName() {
        return _name;
    }
    /**
     * Gets the price of the product.
     *
     * @return The price of the product
     */
    public double getPrice() {
        return _price;
    }
    /**
     * Gets the quantity of the product.
     *
     * @return The quantity of the product
     */
    public int getQuantity() {
        return _quantity;
    }
    /**
     * Sets the quantity of the product, ensuring it is at least 1.
     *
     * @param _quantity The quantity to set
     */
    public void setQuantity(int _quantity) 
    {   
        if (_quantity >= 1)
        {
            this._quantity = _quantity;
        }

        else
        {
            System.out.println("Quantity must be at least 1.");
        }
        
    }
    /**
     * Retrieves a map of all available products with their serial numbers as keys.
     *
     * @return A map of all available products
     */
    public static Map<Integer, CProduct> getAllCProducts() {
        Map<Integer, CProduct> CProducts = new HashMap<>();
        CProducts.put(1, new CProduct(1, "Milk", 2.99));
        CProducts.put(2, new CProduct(2, "Bread", 1.49));
        CProducts.put(3, new CProduct(3, "Eggs", 2.29));
        CProducts.put(4, new CProduct(4, "Butter", 3.99));
        CProducts.put(5, new CProduct(5, "Cereal", 4.49));
        CProducts.put(6, new CProduct(6, "Pasta", 1.19));
        CProducts.put(7, new CProduct(7, "Rice", 2.79));
        CProducts.put(8, new CProduct(8, "Chicken", 5.99));
        CProducts.put(9, new CProduct(9, "Ground Beef", 4.49));
        CProducts.put(10, new CProduct(10, "Cheese", 3.79));
        CProducts.put(11, new CProduct(11, "Yoghurt", 1.99));
        CProducts.put(12, new CProduct(12, "Frozen Pizza", 6.99));
        CProducts.put(13, new CProduct(13, "Coffee", 7.49));
        CProducts.put(14, new CProduct(14, "Tea Bags", 3.29));
        CProducts.put(15, new CProduct(15, "Canned Soup", 1.79));
        CProducts.put(16, new CProduct(16, "Peanut Butter", 2.59));
        CProducts.put(17, new CProduct(17, "Jelly", 2.19));
        CProducts.put(18, new CProduct(18, "Spaghetti Sauce", 2.49));
        CProducts.put(19, new CProduct(19, "Toilet Paper", 6.99));
        CProducts.put(20, new CProduct(20, "Shampoo", 3.99));
        CProducts.put(21, new CProduct(21, "Toothpaste", 1.99));
        CProducts.put(22, new CProduct(22, "Laundry Detergent", 7.49));
        CProducts.put(23, new CProduct(23, "Dish soap", 1.79));
        CProducts.put(24, new CProduct(24, "Paper Towels", 5.49));
        CProducts.put(25, new CProduct(25, "Toothbrush", 2.29));
        CProducts.put(26, new CProduct(26, "Socks", 4.99));
        CProducts.put(27, new CProduct(27, "Garbage Bags", 8.99));
        CProducts.put(28, new CProduct(28, "Aluminium Foil", 2.99));
        CProducts.put(29, new CProduct(29, "Plastic Wrap", 1.49));
        CProducts.put(30, new CProduct(30, "Canned Tuna", 0.99));
        CProducts.put(31, new CProduct(31, "Olive Oil", 4.99));
        CProducts.put(32, new CProduct(32, "Vinegar", 1.29));
        CProducts.put(33, new CProduct(33, "Peanuts", 3.49));
        CProducts.put(34, new CProduct(34, "Chocolate Bars", 1.79));
        CProducts.put(35, new CProduct(35, "Potato Chips", 2.99));
        CProducts.put(36, new CProduct(36, "Coca-Cola", 2.99));
        CProducts.put(37, new CProduct(37, "Mineral Water", 3.49));
        CProducts.put(38, new CProduct(38, "Lemonade", 2.29));
        CProducts.put(39, new CProduct(39, "Ketchup", 2.49));
        CProducts.put(40, new CProduct(40, "Mustard", 1.29));
        CProducts.put(41, new CProduct(41, "Salad Dressing", 1.99));
        CProducts.put(42, new CProduct(42, "Mayonnaise", 2.79));
        CProducts.put(43, new CProduct(43, "Canned Vegetable", 0.99));
        CProducts.put(44, new CProduct(44, "Instant Noodles", 0.79));
        CProducts.put(45, new CProduct(45, "Dishwasher Liquid", 4.79));
        CProducts.put(46, new CProduct(46, "Cleaning wipes", 3.49));
        CProducts.put(47, new CProduct(47, "Hand Sanitizer", 2.99));
        CProducts.put(48, new CProduct(48, "Tissues", 1.29));
        CProducts.put(49, new CProduct(49, "Dental Floss", 1.99));
        CProducts.put(50, new CProduct(50, "Wiper Fluid", 3.99));
        
        return CProducts;
    }
}
