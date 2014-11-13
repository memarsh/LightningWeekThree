/**
 * COMP 3721
 * LW3
 * Mariah Martin-Shein & Alex Keeling
 * Nov. 13, 2014
 */

import java.util.ArrayList;

public class PowerJuiceComposite implements FoodProduct {

    private ArrayList<FoodProduct> childList;

    /**
     * The constructor simply initializes the list of child
     * composites & leaves.
     */
    public PowerJuiceComposite() {
        childList = new ArrayList<FoodProduct>();
    }

    /**
     * The getPrice method sums the price of all its children and returns
     * the total with a discount to encourage buying in bulk.
     * @return
     */
    public double getPrice() {
        double total = 0.0;

        for (FoodProduct food : childList) {
            total += food.getPrice();
        }

        return total - 0.50;
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
