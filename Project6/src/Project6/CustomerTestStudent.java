package Project6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class tests methods created in the customer class
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class CustomerTestStudent {

	private Customer customer1;
    private Customer customer2;
    private Customer customer3;
    private Customer customer4;

    @BeforeEach
    public void setUp() {
        // Initialize customer objects for testing
        customer1 = new Customer("Alice", 25);
        customer2 = new Customer("Alice", 25);  // Same name and age
        customer3 = new Customer("Bob", 30);    // Different name and age
        customer4 = new Customer("Alice", 30);  // Same name but different age
    }

    // Test: Verifying the parameterized constructor
    @Test
    public void testCustomerConstructor() {
        assertEquals("Alice", customer1.getName(), "The name should be Alice.");
        assertEquals(25, customer1.getAge(), "The age should be 25.");
    }

    // Test: Verifying the copy constructor
    @Test
    public void testCopyConstructor() {
        Customer copiedCustomer = new Customer(customer1);
        assertEquals(customer1, copiedCustomer, "The copied customer should be equal to the original customer.");
        assertNotSame(customer1, copiedCustomer, "The copied customer should be a new object.");
    }

    // Test: Verifying the setter and getter for name
    @Test
    public void testSetName() {
        customer1.setName("Charlie");
        assertEquals("Charlie", customer1.getName(), "The name should be updated to Charlie.");
    }

    // Test: Verifying the setter and getter for age
    @Test
    public void testSetAge() {
        customer1.setAge(26);
        assertEquals(26, customer1.getAge(), "The age should be updated to 26.");
    }

    // Test: Verifying the toString method
    @Test
    public void testToString() {
        String expectedString = "Customer [Name: Alice, Age: 25]";
        assertEquals(expectedString, customer1.toString(), "The toString method should return the correct string representation.");
    }

    // Test: Verifying the equals method for identical customers
    @Test
    public void testEqualsIdenticalCustomers() {
        assertTrue(customer1.equals(customer2), "Customers with the same name and age should be considered equal.");
    }

    // Test: Verifying the equals method for different customers (different name and age)
    @Test
    public void testEqualsDifferentCustomers() {
        assertFalse(customer1.equals(customer3), "Customers with different names and ages should not be considered equal.");
    }

    // Test: Verifying the equals method for customers with the same name but different age
    @Test
    public void testEqualsDifferentAge() {
        assertFalse(customer1.equals(customer4), "Customers with the same name but different ages should not be considered equal.");
    }

    // Test: Verifying hashCode consistency with equals
    @Test
    public void testHashCode() {
        assertEquals(customer1.hashCode(), customer2.hashCode(), "Customers that are equal should have the same hash code.");
    }

    // Test: Verifying hashCode consistency for different customers
    @Test
    public void testHashCodeForDifferentCustomers() {
        assertNotEquals(customer1.hashCode(), customer3.hashCode(), "Customers that are not equal should have different hash codes.");
    }
}
