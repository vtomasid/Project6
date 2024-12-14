package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class tests the methods created in the Coffee class
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class CoffeeTestStudent {
	
	private Coffee smallCoffee;
    private Coffee mediumCoffeeWithExtraShot;
    private Coffee largeCoffeeWithExtraShotAndSyrup;

    @BeforeEach
    public void setUp() {
        // Initialize coffee objects for testing
        smallCoffee = new Coffee("Small Coffee", Size.SMALL, false, false);
        mediumCoffeeWithExtraShot = new Coffee("Medium Coffee", Size.MEDIUM, true, false);
        largeCoffeeWithExtraShotAndSyrup = new Coffee("Large Coffee", Size.LARGE, true, true);
    }

    // Test: Verifying price calculation for a basic coffee without extra shot or syrup
    @Test
    public void testCalcPriceBasicCoffee() {
        double expectedPrice = Beverage.BASE_PRICE;  // Small size coffee should be base price only
        assertEquals(expectedPrice, smallCoffee.calcPrice(), "The price should be equal to the base price.");
    }

    // Test: Verifying price calculation for a medium coffee with an extra shot
    @Test
    public void testCalcPriceMediumWithExtraShot() {
        double expectedPrice = Beverage.BASE_PRICE + Beverage.SIZE_PRICE + Coffee.EXTRA_SHOT_COST;  // Medium size + extra shot
        assertEquals(expectedPrice, mediumCoffeeWithExtraShot.calcPrice(), "The price should include extra shot cost.");
    }

    // Test: Verifying price calculation for a large coffee with an extra shot and extra syrup
    @Test
    public void testCalcPriceLargeWithExtraShotAndSyrup() {
        double expectedPrice = Beverage.BASE_PRICE + 2 * Beverage.SIZE_PRICE + Coffee.EXTRA_SHOT_COST + Coffee.EXTRA_SYRUP_COST;  // Large size + extra shot + extra syrup
        assertEquals(expectedPrice, largeCoffeeWithExtraShotAndSyrup.calcPrice(), "The price should include extra shot and syrup costs.");
    }

    // Test: Verifying toString() for a basic coffee
    @Test
    public void testToStringBasicCoffee() {
        String expectedString = "Coffee [Name: Small Coffee, Size: SMALL, Extra Shot: false, Extra Syrup: false, Price: " + smallCoffee.calcPrice() + "]";
        assertEquals(expectedString, smallCoffee.toString(), "The toString method should return the correct string representation.");
    }

    // Test: Verifying toString() for a coffee with extra shot and extra syrup
    @Test
    public void testToStringWithExtras() {
        String expectedString = "Coffee [Name: Large Coffee, Size: LARGE, Extra Shot: true, Extra Syrup: true, Price: " + largeCoffeeWithExtraShotAndSyrup.calcPrice() + "]";
        assertEquals(expectedString, largeCoffeeWithExtraShotAndSyrup.toString(), "The toString method should include the extras and the correct price.");
    }

    // Test: Verifying equals() for two identical coffee objects
    @Test
    public void testEqualsIdenticalCoffees() {
        Coffee anotherSmallCoffee = new Coffee("Small Coffee", Size.SMALL, false, false);
        assertTrue(smallCoffee.equals(anotherSmallCoffee), "Two identical coffee objects should be considered equal.");
    }

    // Test: Verifying equals() for two different coffee objects (different size)
    @Test
    public void testEqualsDifferentSizeCoffees() {
        Coffee anotherMediumCoffee = new Coffee("Medium Coffee", Size.MEDIUM, false, false);
        assertFalse(smallCoffee.equals(anotherMediumCoffee), "Coffees with different sizes should not be considered equal.");
    }

    // Test: Verifying equals() for two different coffee objects (different extras)
    @Test
    public void testEqualsDifferentExtrasCoffees() {
        Coffee coffeeWithExtraShot = new Coffee("Small Coffee", Size.SMALL, true, false);
        assertFalse(smallCoffee.equals(coffeeWithExtraShot), "Coffees with different extras should not be considered equal.");
    }

    // Test: Verifying hashCode consistency with equals()
    @Test
    public void testHashCode() {
        Coffee anotherSmallCoffee = new Coffee("Small Coffee", Size.SMALL, false, false);
        assertEquals(smallCoffee.hashCode(), anotherSmallCoffee.hashCode(), "Coffees that are equal should have the same hash code.");
    }

    // Test: Verifying getter and setter for extraShot
    @Test
    public void testExtraShotGetterSetter() {
        smallCoffee.setExtraShot(true);
        assertTrue(smallCoffee.isExtraShot(), "The extra shot flag should be correctly set and retrieved.");
    }

    // Test: Verifying getter and setter for extraSyrup
    @Test
    public void testExtraSyrupGetterSetter() {
        smallCoffee.setExtraSyrup(true);
        assertTrue(smallCoffee.isExtraSyrup(), "The extra syrup flag should be correctly set and retrieved.");
    }

}
