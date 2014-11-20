import org.junit.Test;

import static org.junit.Assert.*;

public class FoodProductCompositeTest {

    private double TWENTYFOURDISCOUNT = 2.50;
    private double SIXDISCOUNT = 0.50;
    private double DEFAULTCANPRICE = 2.00;

    /**
     * This method tests the getPrice method of the FoodProductComposite class.
     * @throws Exception
     */
    @Test
    public void testGetPrice() throws Exception {
        FoodProductComposite composite = new FoodProductComposite();

        // A new FoodProductComposite should have a total price of $0.00.
        assertEquals(0.00, composite.getPrice(), 0.001);

        composite.addChild(new PowerJuiceCan());

        // With a single can added, the price should be equal to a single can.
        assertEquals(DEFAULTCANPRICE, composite.getPrice(), 0.001);

        // For a total of two through five cans, the price should be the
        // number of cans multiplied by the cost of a single can.
        for (int i = 2; i < 6; ++i) {
            composite.addChild(new PowerJuiceCan());
            assertEquals(DEFAULTCANPRICE * i, composite.getPrice(), 0.001);
        }

        composite.addChild(new PowerJuiceCan()); // now there are six cans

        // The cost of six cans should be the cost of a single can multiplied
        // by six minus the discount for six cans.
        assertEquals(DEFAULTCANPRICE * 6 - SIXDISCOUNT, composite.getPrice(), 0.001);

        composite.addChild(new PowerJuiceCan()); // now there are seven cans

        // The cost of seven cans should be the cost of a single can multiplied
        // by seven minus the discount for six cans.
        assertEquals(DEFAULTCANPRICE * 7 - SIXDISCOUNT, composite.getPrice(), 0.001);

        // innerComposite is a six pack
        FoodProductComposite innerComposite = new FoodProductComposite();
        innerComposite.addChild(new PowerJuiceCan());
        innerComposite.addChild(new PowerJuiceCan());
        innerComposite.addChild(new PowerJuiceCan());
        innerComposite.addChild(new PowerJuiceCan());
        innerComposite.addChild(new PowerJuiceCan());
        innerComposite.addChild(new PowerJuiceCan());

        composite.addChild(innerComposite); // now there are 7 + 6 = 13 cans

        // The cost of 13 cans should be the cost of a single can multiplied
        // by 13 minus the discount for six cans twice.
        assertEquals((DEFAULTCANPRICE * 13) - (SIXDISCOUNT * 2), composite.getPrice(), 0.001);

        // innerComposite2 is another six pack
        FoodProductComposite innerComposite2 = new FoodProductComposite();
        innerComposite2.addChild(new PowerJuiceCan());
        innerComposite2.addChild(new PowerJuiceCan());
        innerComposite2.addChild(new PowerJuiceCan());
        innerComposite2.addChild(new PowerJuiceCan());
        innerComposite2.addChild(new PowerJuiceCan());
        innerComposite2.addChild(new PowerJuiceCan());

        // innerComposite3 in another six pack
        FoodProductComposite innerComposite3 = new FoodProductComposite();
        innerComposite3.addChild(new PowerJuiceCan());
        innerComposite3.addChild(new PowerJuiceCan());
        innerComposite3.addChild(new PowerJuiceCan());
        innerComposite3.addChild(new PowerJuiceCan());
        innerComposite3.addChild(new PowerJuiceCan());
        innerComposite3.addChild(new PowerJuiceCan());

        composite.addChild(innerComposite2); // 7 + 6 + 6 cans
        composite.addChild(innerComposite3); // 7 + 6 + 6 + 6 = 25 cans

        // The cost of 25 cans should be the cost of a single can multiplied
        // by 25 minus the discount for twenty-four cans.
        assertEquals(DEFAULTCANPRICE * 25 - TWENTYFOURDISCOUNT, composite.getPrice(), 0.001);


    }

    /**
     * This method tests the addChild and getCount methods of the
     * FoodProductComposite class.
     * @throws Exception
     */
    @Test
    public void testAddAndCount() throws Exception {
        FoodProductComposite composite = new FoodProductComposite();

        // A new FoodProductComposite shouldn't have any children.
        assertEquals(0, composite.getCount());

        composite.addChild(new PowerJuiceCan());

        // After adding a single can, the composite should have one child.
        assertEquals(1, composite.getCount());

        FoodProductComposite innerComposite = new FoodProductComposite();
        innerComposite.addChild(new PowerJuiceCan());
        innerComposite.addChild(new PowerJuiceCan());

        composite.addChild(composite);

        // Adding a composite as a child with two of its own child should
        // result in a total of three children for the outer composite.
        assertEquals(3, composite.getCount());

    }
}