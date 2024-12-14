package Project6;

import java.util.ArrayList;
import java.util.List;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class represent an order. This class implements two interfaces: OrderInterface and Comparable
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/


public class Order implements OrderInterface, Comparable <Order> {

	 private int orderNumber;
	    private int orderTime;
	    private Day orderDay;
	    private Customer customer;
	    private List<Beverage> beverages;

	    // Parameterized constructor that initializes order details
	    public Order(int orderTime, Day orderDay, String customerName, int customerAge) {
	        this.orderNumber = generateRandomOrderNumber(); // Generate random order number
	        this.orderTime = orderTime;  // Initialize order time
	        this.orderDay = orderDay;    // Initialize order day
	        this.customer = new Customer(customerName, customerAge);  // Deep copy of customer object
	        this.beverages = new ArrayList<>();  // Initialize empty list for beverages
	    }

	    // Method to generate a random order number between 10000 and 90000
	    private int generateRandomOrderNumber() {
	        return (int) (Math.random() * (90000 - 10000 + 1)) + 10000;
	    }

	    // Overloaded method to add a Coffee beverage to the order
	    @Override
	    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
	        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
	        beverages.add(coffee);
	    }

	    // Overloaded method to add an Alcohol beverage to the order
	    @Override
	    public void addNewBeverage(String bevName, Size size) {
	    	boolean isWeekend = this.isWeekend();
	        Alcohol alcohol = new Alcohol(bevName, size, isWeekend);
	        beverages.add(alcohol);
	    }

	    // Overloaded method to add a Smoothie beverage to the order
	    @Override
	    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
	        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
	        beverages.add(smoothie);
	    }

	    // Method to calculate the total order price by summing the price of all beverages in the order
	    @Override
	    public double calcOrderTotal() {
	        double total = 0.0;
	        for (Beverage beverage : beverages) {
	            total += beverage.calcPrice();
	        }
	        return total;
	    }

	    // Method to get the beverage at a specific index (itemNo)
	    @Override
	    public Beverage getBeverage(int itemNo) {
	        if (itemNo >= 0 && itemNo < beverages.size()) {
	            return beverages.get(itemNo);
	        }
	        return null;  // Return null if invalid index
	    }

	    // Method to count the number of beverages of a specific type in the order
	    @Override
	    public int findNumOfBeveType(Type type) {
	        int count = 0;
	        for (Beverage beverage : beverages) {
	            if (beverage.getType() == type) {
	                count++;
	            }
	        }
	        return count;
	    }

	    // Method to check if the order is placed on a weekend (Saturday or Sunday)
	    @Override
	    public boolean isWeekend() {
	        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
	    }

	    // Method to compare this order to another order based on order number
	    @Override
	    public int compareTo(Order otherOrder) {
	        return Integer.compare(this.orderNumber, otherOrder.orderNumber);
	    }

	    // Method to return a string representation of the order with all details
	    @Override
	    public String toString() {
	        StringBuilder orderDetails = new StringBuilder();
	        orderDetails.append("Order Number: ").append(orderNumber)
	                    .append("\nTime: ").append(orderTime)
	                    .append("\nDay: ").append(orderDay)
	                    .append("\nCustomer: ").append(customer.getName())
	                    .append(", Age: ").append(customer.getAge())
	                    .append("\nBeverages in the Order:\n");

	        for (Beverage beverage : beverages) {
	            orderDetails.append(beverage.toString()).append("\n");
	        }

	        orderDetails.append("Total Order Price: ").append(calcOrderTotal()).append("\n");
	        return orderDetails.toString();
	    }

	    // Getter method for customer (returns a deep copy)
	    public Customer getCustomer() {
	        return new Customer(this.customer);  // Return a deep copy of the customer
	    }

	    // Getter for order number
	    public int getOrderNumber() {
	        return orderNumber;
	    }

	    // Getter for order time
	    public int getOrderTime() {
	        return orderTime;
	    }

	    // Getter for order day
	    public Day getOrderDay() {
	        return orderDay;
	    }

	    // Getter for list of beverages
	    public List<Beverage> getBeverages() {
	        return beverages;
	    }

	    // Setter for order number
	    public void setOrderNumber(int orderNumber) {
	        this.orderNumber = orderNumber;
	    }

	    // Setter for order time
	    public void setOrderTime(int orderTime) {
	        this.orderTime = orderTime;
	    }

	    // Setter for order day
	    public void setOrderDay(Day orderDay) {
	        this.orderDay = orderDay;
	    }

	    // Setter for customer
	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    // Setter for beverages list
	    public void setBeverages(List<Beverage> beverages) {
	        this.beverages = beverages;
	    }
	 // Method to return the total number of items (beverages) in the order
	    public int getTotalItems() {
	        return beverages.size();
	    }
}
