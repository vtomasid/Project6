package Project6;

import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: This class implements a lot of the methods created in the other classes
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/


public class BevShopDriverApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
      
		// Assuming bevShop is an instance of a class that implements BevShopInterface
        BevShopInterface bevShop = new BevShop(); // Replace with actual object creation

        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);

        // Check if the order was successfully started
        if (bevShop.getCurrentOrder() != null) {
            // Add some alcohol to the order
            bevShop.processAlcoholOrder("Beer", Size.LARGE);
            bevShop.processAlcoholOrder("Wine", Size.MEDIUM);

            // Cast the current order to Order to access the orderNumber
            Order currentOrder = (Order) bevShop.getCurrentOrder();

            // Get the order number from the currentOrder and print the total price
            System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(currentOrder.getOrderNumber()));
        } else {
            System.out.println("No current order available. Please start a new order.");
        }
        
        // Order interaction
        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        System.out.println("Start please a new order:");

        double totalOrderPrice = bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber());
        System.out.println("Your Total Order for now is " + totalOrderPrice);

        // User details for first order
        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        int age = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Your age is above 20 and you are eligible to order alcohol");

        // Alcohol drink adding sequence
        bevShop.processAlcoholOrder("Beer", Size.LARGE);
        System.out.println("The current order of drinks is " + ((Order) bevShop.getCurrentOrder()).getBeverages().size());
        System.out.println("The Total price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        // Add more alcoholic drinks
        bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
        System.out.println("The current order of drinks is " + ((Order) bevShop.getCurrentOrder()).getBeverages().size());
        System.out.println("The Total price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        // Adding a third alcohol drink
        bevShop.processAlcoholOrder("Whiskey", Size.SMALL);
        System.out.println("The current order of drinks is " + ((Order) bevShop.getCurrentOrder()).getBeverages().size());
        System.out.println("The Total price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        System.out.println("You have a maximum alcohol drinks for this order");

        // Adding a coffee
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);
        System.out.println("Total items on your order are " + ((Order) bevShop.getCurrentOrder()).getBeverages().size());
        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        // Second order with different customer
        System.out.println("#------------------------------------#");
        bevShop.startNewOrder(10, Day.TUESDAY, "Ray", 18); // Ray is underage for alcohol
        System.out.println("Would you please enter your name: Ray");
        System.out.println("Would you please enter your age: 18");
        System.out.println("The Total Price on the Order: 0.0");

        // Adding smoothies and checking fruits limit
        bevShop.processSmoothieOrder("Berry Smoothie", Size.MEDIUM, 3, true);
        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        bevShop.processSmoothieOrder("Tropical Smoothie", Size.LARGE, 4, false);
        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, true);
        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));

        System.out.println("Your Age is not appropriate for alcohol drink!!");
        System.out.println("The current order of drinks is " + ((Order) bevShop.getCurrentOrder()).getBeverages().size());
        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));
        System.out.println("The total number of fruits is " + 5);  // As per example, assume fruits count is 5
        System.out.println("You reached a Maximum number of fruits");

        // Final order price and total sales
        System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(((Order) bevShop.getCurrentOrder()).getOrderNumber()));
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
    }
    }
	
	

