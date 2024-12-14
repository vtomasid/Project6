package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class tests the methods created in the Beverage class
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class BeverageTestStudent {
	
	private TestBeverage smallBeverage;
    private TestBeverage mediumBeverage;
    private TestBeverage largeBeverage;

    @BeforeEach
    public void setUp() {
        // Initialize test beverages for various sizes
        smallBeverage = new TestBeverage("Small Coffee", Type.COFFEE, Size.SMALL);
        mediumBeverage = new TestBeverage("Medium Coffee", Type.COFFEE, Size.MEDIUM);
        largeBeverage = new TestBeverage("Large Coffee", Type.COFFEE, Size.LARGE);
    }

    // Test: Verifying the size price for small, medium, and large beverages
    @Test
    public void testAddSizePrice() {
        assertEquals(Beverage.BASE_PRICE, smallBeverage.addSizePrice(), "Price for SMALL size should be the base price.");
        assertEquals(Beverage.BASE_PRICE + Beverage.SIZE_PRICE, mediumBeverage.addSizePrice(), "Price for MEDIUM size should be base price + 0.5.");
        assertEquals(Beverage.BASE_PRICE + 2 * Beverage.SIZE_PRICE, largeBeverage.addSizePrice(), "Price for LARGE size should be base price + 1.0.");
    }

    // Test: Verifying equality for beverages with identical properties
    @Test
    public void testEqualsIdenticalBeverages() {
        TestBeverage anotherSmallBeverage = new TestBeverage("Small Coffee", Type.COFFEE, Size.SMALL);
        assertTrue(smallBeverage.equals(anotherSmallBeverage), "Beverages with identical properties should be equal.");
    }

    // Test: Verifying equality for beverages with different properties
    @Test
    public void testEqualsDifferentBeverages() {
        TestBeverage anotherLargeBeverage = new TestBeverage("Large Coffee", Type.COFFEE, Size.LARGE);
        assertFalse(smallBeverage.equals(anotherLargeBeverage), "Beverages with different properties should not be equal.");
    }

    // Test: Verifying the toString method
    @Test
    public void testToString() {
        String expectedString = "Beverage Name: Small Coffee, Type: COFFEE, Size: SMALL";
        assertEquals(expectedString, smallBeverage.toString(), "The toString method should return the correct string representation.");
    }

    // Test: Verifying getter and setter for beverageName
    @Test
    public void testBeverageNameSetterGetter() {
        smallBeverage.setBeverageName("Small Tea");
        assertEquals("Small Tea", smallBeverage.getBeverageName(), "The beverage name should be set correctly.");
    }

    

    // Test: Verifying getter and setter for size
    @Test
    public void testSizeSetterGetter() {
        smallBeverage.setSize(Size.LARGE);
        assertEquals(Size.LARGE, smallBeverage.getSize(), "The beverage size should be set correctly.");
    }

    // Test: Verifying the base price is correctly retrieved
    @Test
    public void testBasePrice() {
        assertEquals(Beverage.BASE_PRICE, smallBeverage.getBasePrice(), "The base price should be correctly retrieved.");
    }

    // Test: Verifying the price calculation of the beverage (since calcPrice() is abstract)
    @Test
    public void testCalcPrice() {
        // For TestBeverage, we'll assume that calcPrice returns the same price as addSizePrice for testing purposes
        assertEquals(smallBeverage.addSizePrice(), smallBeverage.calcPrice(), "calcPrice() should return the expected price.");
    }
}

// Simple subclass of Beverage to implement the abstract methods for testing purposes
class TestBeverage extends Beverage {

    public TestBeverage(String beverageName, Type beverageType, Size size) {
        super(beverageName, beverageType, size);
    }

    @Override
    public double calcPrice() {
        return addSizePrice();  // For testing, we return the same price as addSizePrice
    }

    @Override
    protected Type getType() {
        return this.beverageType;  // Just return the beverage type for testing purposes
    }

}
