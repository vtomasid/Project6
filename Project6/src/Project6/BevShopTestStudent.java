package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class tests methods created in the BevShop class
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class BevShopTestStudent {
	
	private BevShop bevShop;
    private OrderInterface currentOrder;

    // Runs before each test method
    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testStartNewOrder_ValidTimeAndAge() {
        // Assuming 10:00 is a valid time and the customer is 21 (valid age for alcohol)
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 21);

        // Get the current order and verify it is initialized correctly
        currentOrder = bevShop.getCurrentOrder();
        assertNotNull(currentOrder, "Current order should not be null.");
        
       
    }

    @Test
    public void testStartNewOrder_InvalidTime() {
        // Start an order with an invalid time (e.g., 25:00 is not valid)
        assertThrows(IllegalArgumentException.class, () -> {
            bevShop.startNewOrder(25, Day.MONDAY, "John Doe", 21);
        }, "Expected IllegalArgumentException for invalid time.");
    }

    @Test
    public void testStartNewOrder_InvalidAge() {
        // Start an order with an invalid age (e.g., underage)
        assertThrows(IllegalArgumentException.class, () -> {
            bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 17);
        }, "Expected IllegalArgumentException for underage.");
    }

    @Test
    public void testProcessSmoothieOrder() {
        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 21);

        // Process a smoothie order
        bevShop.processSmoothieOrder("Berry Blast", Size.MEDIUM, 3, true);

        // Verify that the current order contains the beverage
        currentOrder = bevShop.getCurrentOrder();
        assertEquals(1, ((Order) currentOrder).getBeverages().size(), "Order should contain one beverage.");
    }

    @Test
    public void testProcessCoffeeOrder() {
        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "Jane Doe", 25);

        // Process a coffee order
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);

        // Verify that the current order contains the coffee
        currentOrder = bevShop.getCurrentOrder();
        assertEquals(1, ((Order) currentOrder).getBeverages().size(), "Order should contain one coffee.");
    }

    @Test
    public void testProcessAlcoholOrder_EligibleForMore() {
        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);

        // Process an alcohol order
        bevShop.processAlcoholOrder("Beer", Size.LARGE);

        // Verify the alcohol count
        assertEquals(1, bevShop.getNumOfAlcoholDrink(), "Alcohol count should be 1.");
    }

    @Test
    public void testProcessAlcoholOrder_ExceededMax() {
        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "Jane Doe", 30);

        // Try to process alcohol orders beyond the limit
        bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
        bevShop.processAlcoholOrder("Wine", Size.LARGE);

        // Verify that the alcohol count does not exceed the max limit
        assertFalse(bevShop.isEligibleForMore(), "Should not be eligible for more alcohol orders.");
    }

    @Test
    public void testFindOrder_ValidOrderNumber() {
        // Start two orders
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processSmoothieOrder("Berry Smoothie", Size.LARGE, 3, true);

        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Doe", 30);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);

        // Find the order by its order number (we can assume order numbers are sequential)
        OrderInterface order = bevShop.getOrderAtIndex(1); // Find the second order (index 1)

    }

    @Test
    public void testFindOrder_InvalidOrderNumber() {
        // Start an order
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);

        // Try finding an order with an invalid order number (e.g., a non-existent order number)
        Order order = bevShop.findOrderByNumber(999);

        // Assert that the order is not found
        assertNull(order, "Order should not be found for a non-existent order number.");
    }

    @Test
    public void testTotalMonthlySale() {
        // Start and process orders
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Doe", 30);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);

        // Verify the total monthly sale
        double totalSale = bevShop.totalMonthlySale();
        assertTrue(totalSale > 0, "Total monthly sale should be greater than zero.");
    }

    @Test
    public void testSortOrders() {
        // Start orders with different order numbers
        bevShop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        bevShop.startNewOrder(12, Day.TUESDAY, "Jane Doe", 30);
        bevShop.startNewOrder(8, Day.SUNDAY, "Jake Doe", 28);

        // Sort the orders by order number
        bevShop.sortOrders();

    }

}
