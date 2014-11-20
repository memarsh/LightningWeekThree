/**
 * COMP 3721
 * LW3
 * Mariah Martin-Shein & Alex Keeling
 * Nov. 13, 2014
 */

import java.util.ArrayList;

public class FoodProductComposite implements FoodProduct {

    private double TWENTYFOURDISCOUNT = 2.50;
    private double SIXDISCOUNT = 0.50;
    private ArrayList<FoodProduct> childList;

    /**
     * The constructor simply initializes the list of child
     * composites & leaves.
     */
    public FoodProductComposite() {
        childList = new ArrayList<FoodProduct>();
    }

    /**
     * The getDiscountedPrice method takes the total non-discounted price, and
     * applies any relevant discounts to it.
     * @return
     */
    public double getDiscountedPrice() {
        double totalPrice = getPrice();

        // Now that we have the total price, we find out the total count of
        // items, and calculate if there are any discounts based on quantity.

        int totalCount = getCount();

        while (totalCount - 24 >= 0) {
            totalCount -= 24;
            totalPrice -= TWENTYFOURDISCOUNT;
        }

        while (totalCount - 6 >= 0) {
            totalCount -= 6;
            totalPrice -= SIXDISCOUNT;
        }

        return totalPrice;
    }

    /**
     * The getPrice method sums the price of all its children and returns
     * the total with a discount to encourage buying in bulk.
     * @return
     */
    public double getPrice() {
        double totalPrice = 0.0;

        for (FoodProduct food : childList) {
            totalPrice += food.getPrice();
        }

        return totalPrice;
    }

    /**
     * The getCount method sums the count of all its children and returns
     * the total count.
     * @return
     */
    public int getCount() {
        int totalCount = 0;

        for (FoodProduct food : childList) {
            totalCount += food.getCount();
        }

        return totalCount;
    }

    /**
     * Takes a FoodProduct and adds it to this composite's list
     * of children.
     * @param food
     */
    public void addChild(FoodProduct food) {
        childList.add(food);
    }
}
