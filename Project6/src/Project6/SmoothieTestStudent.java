package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class tests the methods created in the Smoothie class
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class SmoothieTestStudent {

	 private Smoothie smallSmoothie;
	    private Smoothie mediumSmoothieWithFruits;
	    private Smoothie largeSmoothieWithFruitsAndProtein;

	    @BeforeEach
	    public void setUp() {
	        // Initialize smoothie objects for testing
	        smallSmoothie = new Smoothie("Small Smoothie", Size.SMALL, 0, false);
	        mediumSmoothieWithFruits = new Smoothie("Medium Smoothie", Size.MEDIUM, 3, false);
	        largeSmoothieWithFruitsAndProtein = new Smoothie("Large Smoothie", Size.LARGE, 5, true);
	    }

	    // Test: Verifying price calculation for a basic smoothie (no fruits, no protein)
	    @Test
	    public void testCalcPriceBasicSmoothie() {
	        double expectedPrice = Beverage.BASE_PRICE;  // Small size smoothie should be base price only
	        assertEquals(expectedPrice, smallSmoothie.calcPrice(), "The price should be equal to the base price.");
	    }

	    // Test: Verifying price calculation for a medium smoothie with 3 fruits (no protein)
	    @Test
	    public void testCalcPriceMediumWithFruits() {
	        double expectedPrice = Beverage.BASE_PRICE + Beverage.SIZE_PRICE + (3 * Smoothie.FRUIT_COST);  // Medium size + 3 fruits
	        assertEquals(expectedPrice, mediumSmoothieWithFruits.calcPrice(), "The price should include the cost for 3 fruits.");
	    }

	    // Test: Verifying price calculation for a large smoothie with 5 fruits and protein
	    @Test
	    public void testCalcPriceLargeWithFruitsAndProtein() {
	        double expectedPrice = Beverage.BASE_PRICE + 2 * Beverage.SIZE_PRICE + (5 * Smoothie.FRUIT_COST) + Smoothie.PROTEIN_COST;  // Large size + 5 fruits + protein cost
	        assertEquals(expectedPrice, largeSmoothieWithFruitsAndProtein.calcPrice(), "The price should include the cost for 5 fruits and protein.");
	    }

	    // Test: Verifying toString() for a basic smoothie
	    @Test
	    public void testToStringBasicSmoothie() {
	        String expectedString = "Smoothie [Name: Small Smoothie, Size: SMALL, Protein: false, Fruits: 0, Price: " + smallSmoothie.calcPrice() + "]";
	        assertEquals(expectedString, smallSmoothie.toString(), "The toString method should return the correct string representation.");
	    }

	    // Test: Verifying toString() for a smoothie with fruits and protein
	    @Test
	    public void testToStringWithFruitsAndProtein() {
	        String expectedString = "Smoothie [Name: Large Smoothie, Size: LARGE, Protein: true, Fruits: 5, Price: " + largeSmoothieWithFruitsAndProtein.calcPrice() + "]";
	        assertEquals(expectedString, largeSmoothieWithFruitsAndProtein.toString(), "The toString method should include the protein and fruit details, along with the correct price.");
	    }

	    // Test: Verifying equals() for two identical smoothie objects
	    @Test
	    public void testEqualsIdenticalSmoothies() {
	        Smoothie anotherSmallSmoothie = new Smoothie("Small Smoothie", Size.SMALL, 0, false);
	        assertTrue(smallSmoothie.equals(anotherSmallSmoothie), "Two identical smoothie objects should be considered equal.");
	    }

	    // Test: Verifying equals() for two different smoothie objects (different size)
	    @Test
	    public void testEqualsDifferentSizeSmoothies() {
	        Smoothie anotherMediumSmoothie = new Smoothie("Medium Smoothie", Size.MEDIUM, 0, false);
	        assertFalse(smallSmoothie.equals(anotherMediumSmoothie), "Smoothies with different sizes should not be considered equal.");
	    }

	    // Test: Verifying equals() for two different smoothie objects (different fruits)
	    @Test
	    public void testEqualsDifferentFruitsSmoothies() {
	        Smoothie smoothieWithFruits = new Smoothie("Small Smoothie", Size.SMALL, 3, false);
	        assertFalse(smallSmoothie.equals(smoothieWithFruits), "Smoothies with different numbers of fruits should not be considered equal.");
	    }

	    // Test: Verifying equals() for two different smoothie objects (different protein)
	    @Test
	    public void testEqualsDifferentProteinSmoothies() {
	        Smoothie smoothieWithProtein = new Smoothie("Small Smoothie", Size.SMALL, 0, true);
	        assertFalse(smallSmoothie.equals(smoothieWithProtein), "Smoothies with different protein status should not be considered equal.");
	    }

	    // Test: Verifying hashCode consistency with equals()
	    @Test
	    public void testHashCode() {
	        Smoothie anotherSmallSmoothie = new Smoothie("Small Smoothie", Size.SMALL, 0, false);
	        assertEquals(smallSmoothie.hashCode(), anotherSmallSmoothie.hashCode(), "Smoothies that are equal should have the same hash code.");
	    }

	    // Test: Verifying getter and setter for numOfFruits
	    @Test
	    public void testNumOfFruitsGetterSetter() {
	        smallSmoothie.setNumOfFruits(2);
	        assertEquals(2, smallSmoothie.getNumOfFruits(), "The number of fruits should be correctly set and retrieved.");
	    }

	    // Test: Verifying getter and setter for addProtein
	    @Test
	    public void testAddProteinGetterSetter() {
	        smallSmoothie.setAddProtein(true);
	        assertTrue(smallSmoothie.isAddProtein(), "The addProtein flag should be correctly set and retrieved.");
	    }
}
