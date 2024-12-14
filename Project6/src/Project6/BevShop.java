package Project6;

import java.util.ArrayList;

import java.util.List;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class represents a beverage shop
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class BevShop implements BevShopInterface {

	 // Instance variables
    private int currentAlcoholCount;  // Track the number of alcohol beverages in the current order
    private Order currentOrder;  // Track the current order being processed
    private List<OrderInterface> orders= new ArrayList<>();  // List of all orders placed in the sho
	  
 // Constructor to initialize the beverage shop
    public BevShop() {
        this.currentAlcoholCount = 0;
        this.orders = new ArrayList<>();
    }

    // Implementing the BevShopInterface methods
    
    @Override
    public int findOrder(int orderNo) {
        // Iterate through the orders list to find the order with the matching order number
        for (int i = 0; i < orders.size(); i++) {
            if (((Order) orders.get(i)).getOrderNumber() == orderNo) {
                return i;  // Return the index if the order is found
            }
        }
        return -1;  // Return -1 if the order is not found
    }
    
    @Override
    public void sortOrders() {
        int n = orders.size();
        
        // Selection sort algorithm
        for (int i = 0; i < n - 1; i++) {
            // Assume the current position i has the minimum element
            int minIndex = i;

            // Find the index of the smallest element in the remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (((Order) orders.get(j)).getOrderNumber() < ((Order) orders.get(minIndex)).getOrderNumber()) {
                    minIndex = j;  // Update the index of the smallest element
                }
            }

            // If the minimum element is not at the current position, swap them
            if (minIndex != i) {
                // Swap the orders at indices i and minIndex
                OrderInterface temp = orders.get(i);
                orders.set(i, orders.get(minIndex));
                orders.set(minIndex, temp);
            }
        }
    }
    
    @Override
    public OrderInterface getCurrentOrder() {
        if (currentOrder != null) {
            return currentOrder;  // Return the current order if it exists
        } else {
            throw new IllegalStateException("No current order available.");
        }
    }
    
    @Override
    public OrderInterface getOrderAtIndex(int index) {
        // Check if index is within the valid range
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);  // Return the order at the specified index
        } else {
            // Handle invalid index (you can throw an exception if desired)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
    
 // Implementation of findOrderByNumber
    public Order findOrderByNumber(int orderNo) {
        // Iterate through the orders list and check for the matching order number
        for (OrderInterface order : orders) {
            if (((Order) order).getOrderNumber() == orderNo) {
                return (Order) order; // Return the order if found
            }
        }
        return null; // Return null if no matching order is found
    }
    // Implement the processSmoothieOrder method from BevShopInterface
    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        // Create a new smoothie object based on the provided parameters
        // For this example, I assume you have a Smoothie class that extends Beverage
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        
        // Add the smoothie to the current order
        Order currentOrder = (Order) getCurrentOrder(); // Assuming getCurrentOrder() gives you the current order
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return currentAlcoholCount < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return currentAlcoholCount;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }
    
    @Override
    public double totalMonthlySale() {
        double totalSale = 0.0;
        
        // Iterate over each order in the list
        for (OrderInterface order : orders) {
            // Add the total price of each order to the total sale
            totalSale += totalOrderPrice(((Order) order).getOrderNumber());
        }
        
        return totalSale;
    }
    
 // Implementing the totalOrderPrice method
    @Override
    public double totalOrderPrice(int orderNo) {
        // Find the order by its order number
        Order order = findOrderByNumber(orderNo);
        
        // If the order is found, calculate the total price
        if (order != null) {
            return order.calcOrderTotal(); // 
        } else {
            return 0.0; // If order not found, return 0 or handle as per your logic
        }
    }
    
    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();  // Return the size of the list, which represents the total orders
    }
    
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (isValidTime(time) && isValidAge(customerAge)) {
            this.currentOrder = new Order(time, day, customerName, customerAge);
            this.orders.add(currentOrder);  // Add the new order to the list of orders
            this.currentAlcoholCount = 0;  // Reset alcohol count for the new order
        } else {
            throw new IllegalArgumentException("Invalid time or age");
        }
    }
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (currentOrder != null) {
            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
        }
    }
    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (currentOrder != null && isEligibleForMore()) {
            boolean isWeekend = currentOrder.isWeekend();  // Check if the order is placed on a weekend
            currentOrder.addNewBeverage(bevName, size);
            currentAlcoholCount++;  // Increase the alcohol count for the current order
        
    }

    }
}
