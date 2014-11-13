import java.util.ArrayList;

/**
 * Created by alex on 13/11/14.
 */
public class PowerJuiceComposite implements FoodProduct {

    private ArrayList<FoodProduct> childList;

    public PowerJuiceComposite() {
        childList = new ArrayList<FoodProduct>();
    }

    public double getPrice() {
        double total = 0.0;

        for (FoodProduct food : childList) {
            total += food.getPrice();
        }

        return total;
    }
}
