package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlcoholTestStudent {
	
	private Alcohol alcohol1;
    private Alcohol alcohol2;
    private Alcohol alcohol3;

    @BeforeEach
    public void setUp() {
        // Set up a few different alcohol instances for testing
        alcohol1 = new Alcohol("Beer", Size.MEDIUM, false); // Alcohol without weekend cost
        alcohol2 = new Alcohol("Beer", Size.MEDIUM, true);  // Alcohol with weekend cost
        alcohol3 = new Alcohol("Wine", Size.LARGE, true);   // Alcohol with weekend cost
    }

    // Test: Checking price calculation without weekend cost
    @Test
    public void testCalcPriceWithoutWeekend() {
        double expectedPrice = alcohol1.addSizePrice(); // Calculate the price for MEDIUM size
        assertEquals(expectedPrice, alcohol1.calcPrice(), "Price should match the expected base price for non-weekend alcohol.");
    }

    // Test: Checking price calculation with weekend cost
    @Test
    public void testCalcPriceWithWeekend() {
        double expectedPrice = alcohol2.addSizePrice() + Alcohol.WEEKEND_COST; // Price with weekend cost
        assertEquals(expectedPrice, alcohol2.calcPrice(), "Price should include the weekend cost.");
    }

    // Test: Checking if equals method works for identical objects
    @Test
    public void testEqualsForIdenticalObjects() {
        Alcohol anotherAlcohol = new Alcohol("Beer", Size.MEDIUM, true);
        assertTrue(alcohol2.equals(anotherAlcohol), "Two identical alcohol objects should be considered equal.");
    }

    // Test: Checking if equals method works for different objects
    @Test
    public void testEqualsForDifferentObjects() {
        Alcohol differentAlcohol = new Alcohol("Wine", Size.LARGE, true);
        assertFalse(alcohol2.equals(differentAlcohol), "Two different alcohol objects should not be considered equal.");
    }

    // Test: Checking if toString method is correct
    @Test
    public void testToString() {
        String expectedString = "Alcohol [Name: Beer, Size: MEDIUM, Offered on Weekend: true, Price: " 
                                + (alcohol2.addSizePrice() + Alcohol.WEEKEND_COST) + "]";
        assertEquals(expectedString, alcohol2.toString(), "The toString method should return the correct string representation.");
    }

    // Test: Checking getter and setter for isWeekend
    @Test
    public void testIsWeekendGetterAndSetter() {
        // Initially, alcohol3 should be set to true (weekend).
        assertTrue(alcohol3.isWeekend(), "Initially, alcohol should be available on the weekend.");

        // Change to false using the setter and check again
        alcohol3.setWeekend(false);
        assertFalse(alcohol3.isWeekend(), "After setting, alcohol should no longer be available on the weekend.");
    }

    // Test: Checking correct pricing for different sizes
    @Test
    public void testPricingForDifferentSizes() {
        Alcohol smallAlcohol = new Alcohol("Small Beer", Size.SMALL, false);
        Alcohol largeAlcohol = new Alcohol("Large Beer", Size.LARGE, false);

        double smallPrice = smallAlcohol.addSizePrice();
        double largePrice = largeAlcohol.addSizePrice();

        assertTrue(smallPrice < largePrice, "Price for large alcohol should be greater than the price for small alcohol.");
    }

}
