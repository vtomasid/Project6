package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class tests methods created in the Order class
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class OrderTestStudent {
	
	private Order order1;
    private Order order2;
    private Order order3;

    @BeforeEach
    public void setUp() {
        // Initialize the orders
        order1 = new Order(1200, Day.MONDAY, "Alice", 25);
        order2 = new Order(1300, Day.SATURDAY, "Bob", 30);
        order3 = new Order(1400, Day.SUNDAY, "Charlie", 35);
        
        // Add some beverages
        order1.addNewBeverage("Latte", Size.MEDIUM, true, false);  // Coffee with extra shot
        order1.addNewBeverage("Smoothie", Size.LARGE, 3, true);      // Smoothie with 3 fruits and protein
    }

    // Test: Verify that the order is initialized correctly
    @Test
    public void testOrderInitialization() {
        assertEquals(1200, order1.getOrderTime(), "The order time should be 1200.");
        assertEquals(Day.MONDAY, order1.getOrderDay(), "The order day should be MONDAY.");
        assertEquals("Alice", order1.getCustomer().getName(), "The customer name should be Alice.");
        assertEquals(25, order1.getCustomer().getAge(), "The customer age should be 25.");
        assertEquals(2, order1.getTotalItems(), "The total items in the order should be 2.");
    }

    // Test: Add a beverage and check the total number of items in the order
    @Test
    public void testAddNewBeverage() {
        order2.addNewBeverage("Coffee", Size.SMALL, true, true); // Add Coffee with extra shot and syrup
        assertEquals(1, order2.getTotalItems(), "The order should have 1 beverage.");
    }

    // Test: Verify that the total order price is calculated correctly
    @Test
    public void testCalcOrderTotal() {
        double expectedTotal = 2.0 + 0.5 + 3 * 0.5 + 1.5; // Coffee with size, extra shot, smoothie with fruits and protein
        assertEquals(expectedTotal, order1.calcOrderTotal(), 0.01, "The order total should match the expected price.");
    }

    // Test: Verify getting a beverage by index
    @Test
    public void testGetBeverage() {
        Beverage beverage = order1.getBeverage(0); // Get the first beverage
        assertNotNull(beverage, "The beverage should not be null.");
        assertTrue(beverage instanceof Coffee, "The beverage should be a Coffee.");
    }

    // Test: Verify counting the number of beverages of a specific type (Coffee)
    @Test
    public void testFindNumOfBeveType() {
        int coffeeCount = order1.findNumOfBeveType(Type.COFFEE);
        assertEquals(1, coffeeCount, "There should be 1 Coffee beverage in the order.");
    }

    // Test: Verify isWeekend method works correctly
    @Test
    public void testIsWeekend() {
        assertTrue(order2.isWeekend(), "The order on Saturday should be considered a weekend.");
        assertTrue(order3.isWeekend(), "The order on Sunday should be considered a weekend.");
        assertFalse(order1.isWeekend(), "The order on Monday should not be considered a weekend.");
    }

    // Test: Verify that compareTo works based on order number
    @Test
    public void testCompareTo() {
        assertTrue(order1.compareTo(order2) < 0, "Order 1 should have a smaller order number than Order 2.");
        assertTrue(order2.compareTo(order3) < 0, "Order 2 should have a smaller order number than Order 3.");
    }

    // Test: Verify toString method returns correct string representation
    @Test
    public void testToString() {
        String expectedString = "Order Number: " + order1.getOrderNumber() + 
                                "\nTime: 1200" +
                                "\nDay: MONDAY" +
                                "\nCustomer: Alice, Age: 25" +
                                "\nBeverages in the Order:\nCoffee [Name: Latte, Size: MEDIUM, Extra Shot: true, Extra Syrup: false, Price: 3.0]\nSmoothie [Name: Smoothie, Size: LARGE, Protein: true, Fruits: 3, Price: 4.5]\n" +
                                "Total Order Price: 7.5\n";
        assertEquals(expectedString, order1.toString(), "The toString method should return the correct order details.");
    }

    // Test: Verify that getCustomer returns a deep copy of the customer
    @Test
    public void testGetCustomer() {
        Customer customer = order1.getCustomer();
        assertNotSame(customer, order1.getCustomer(), "The customer returned should not be the same instance.");
        assertEquals("Alice", customer.getName(), "The customer name should be Alice.");
        assertEquals(25, customer.getAge(), "The customer age should be 25.");
    }

}
