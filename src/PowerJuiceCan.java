/**
 * Created by alex on 13/11/14.
 */
public class PowerJuiceCan implements FoodProduct {

    private double price;

    public PowerJuiceCan() {
        price = 2.00;
    }

    public PowerJuiceCan(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
