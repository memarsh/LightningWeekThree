/**
 * COMP 3721
 * LW3
 * Mariah Martin-Shein & Alex Keeling
 * Nov. 13, 2014
 */
public interface FoodProduct {

    /**
     * The getPrice method is necessary for computing
     * the total price of a pack of food products.
     * @return
     */
    public double getPrice();

    /**
     * The getCount method returns the total number
     * of items composing this FoodProduct.
     * @return
     */
    public int getCount();

}
