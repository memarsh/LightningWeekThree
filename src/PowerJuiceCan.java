/**
 * COMP 3721
 * LW3
 * Mariah Martin-Shein & Alex Keeling
 * Nov. 13, 2014
 */
public class PowerJuiceCan implements FoodProduct {

    private double DEFAULTPRICE = 2.00;
    private double price;

    /**
     * The default contructor sets the price to two dollars.
     */
    public PowerJuiceCan() {
        price = DEFAULTPRICE;
    }

    /**
     * This constructor takes a double to set the price to any value.
     * @param price
     */
    public PowerJuiceCan(double price) {
        this.price = price;
    }

    /**
     * Simply returns this can's price.
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Simply returns the number of cans (1).
     * @return
     */
    public int getCount() {
        return 1;
    }

}
