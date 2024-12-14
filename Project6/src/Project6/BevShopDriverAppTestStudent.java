package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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


public class BevShopDriverAppTestStudent {

	private BevShopInterface bevShop;

    @BeforeEach
    public void setUp() {
        // Initialize an actual instance of BevShop
        BevShop shop = new BevShop();
        
    }

    @Test
    public void testStartNewOrder() {
        // Arrange
        String customerName = "John";
        int customerAge = 23;
        int orderTime = 10;
        Day orderDay = Day.MONDAY;

        // Act
        bevShop.startNewOrder(orderTime, orderDay, customerName, customerAge);

        Order currentOrder = (Order) bevShop.getCurrentOrder();  // Cast to Order

     // Assert that the order is not null
     assertNotNull(currentOrder, "Current order should not be null.");

     // Assert that the order time matches the expected value
     assertEquals(orderTime, currentOrder.getOrderTime(), "Order time should match.");

     // Assert that the order day matches the expected value
     assertEquals(orderDay, currentOrder.getOrderDay(), "Order day should match.");

     // Assert that the customer name matches the expected value
     assertEquals(customerName, currentOrder.getCustomer().getName(), "Customer name should match.");

     // Assert that the customer age matches the expected value
     assertEquals(customerAge, currentOrder.getCustomer().getAge(), "Customer age should match.");
    }

    @Test
    public void testProcessAlcoholOrder() {
        // Arrange
        String alcoholName1 = "Beer";
        String alcoholName2 = "Wine";
        Size size1 = Size.LARGE;
        Size size2 = Size.MEDIUM;

        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);

        // Act
        bevShop.processAlcoholOrder(alcoholName1, size1);
        bevShop.processAlcoholOrder(alcoholName2, size2);

        // Assert: Check if alcohol beverages are added correctly to the current order
        int alcoholCount = bevShop.getNumOfAlcoholDrink();
        assertEquals(2, alcoholCount, "There should be 2 alcohol beverages in the order.");
    }

    @Test
    public void testTotalOrderPrice() {
        // Arrange
        int orderNumber = 12345;  // Assuming this is the order number of the current order

        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);
        bevShop.processAlcoholOrder("Beer", Size.LARGE);
        bevShop.processAlcoholOrder("Wine", Size.MEDIUM);

        // Add beverages to the order (like Coffee, Alcohol, etc.)

        // Act: Get the total price for the current order
        double totalPrice = bevShop.totalOrderPrice(orderNumber);

        // Assert: Verify the total order price (assuming the price is calculated correctly)
        assertTrue(totalPrice > 0, "Total order price should be greater than zero.");
    }

    @Test
    public void testAlcoholLimit() {
        // Arrange: Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);
        
        // Act & Assert: Ensure that alcohol limit is not exceeded
        bevShop.processAlcoholOrder("Beer", Size.LARGE);
        bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
        
        // Check if the alcohol count is still within the allowed limit
        assertTrue(bevShop.isEligibleForMore(), "Should be eligible for more alcohol.");
        
        // Add a third alcohol beverage
        bevShop.processAlcoholOrder("Whiskey", Size.SMALL);
        
        // Now, check if alcohol limit is reached
        assertFalse(bevShop.isEligibleForMore(), "Should not be eligible for more alcohol.");
    }

    @Test
    public void testStartNewOrderWithInvalidTime() {
        // Arrange
        String customerName = "John";
        int customerAge = 23;
        int invalidTime = 25;  // Invalid time (should be between 8 and 23)

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bevShop.startNewOrder(invalidTime, Day.MONDAY, customerName, customerAge);
        });
        assertEquals("Invalid time or age", exception.getMessage());
    }

    @Test
    public void testStartNewOrderWithInvalidAge() {
        // Arrange
        String customerName = "John";
        int invalidAge = 18;  // Invalid age for alcohol
        int orderTime = 10;
        Day orderDay = Day.MONDAY;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bevShop.startNewOrder(orderTime, orderDay, customerName, invalidAge);
        });
        assertEquals("Invalid time or age", exception.getMessage());
    }

    @Test
    public void testProcessSmoothieOrder() {
        // Arrange: Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);

        // Act: Process a smoothie order
        bevShop.processSmoothieOrder("Tropical Smoothie", Size.MEDIUM, 3, true);

        // Assert: Verify that the smoothie was added to the order
        int numOfSmoothies = bevShop.getCurrentOrder().findNumOfBeveType(Type.SMOOTHIE);
        assertEquals(1, numOfSmoothies, "There should be 1 smoothie in the order.");
    }
}
