package Project6;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class contains additional info about a smoothie
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class Smoothie extends Beverage {

	// Instance variables for additional costs
    private int numOfFruits;  // Number of fruits in the smoothie
    private boolean addProtein;  // Whether protein powder is added to the smoothie

    // Constants for additional costs
    public static final double FRUIT_COST = 0.5;  // Cost for each additional fruit
    public static final double PROTEIN_COST = 1.5;  // Cost for adding protein

    // Constructor for Smoothie class
    public Smoothie(String beverageName, Size size, int numOfFruits, boolean addProtein) {
        super(beverageName, Type.SMOOTHIE, size);  // Calling the constructor of the superclass (Beverage)
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    // Override calcPrice method to calculate the price for Smoothie
    @Override
    public double calcPrice() {
        double price = addSizePrice();  // Get base price with size adjustment

        // Add additional costs for fruits and protein powder
        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST;
        }

        return price;
    }
    
    // Implementing the abstract method getType() from Beverage class
    @Override
    public Type getType() {
        return Type.SMOOTHIE;  // Return the type as SMOOTHIE
    }

    // Override the toString method for Smoothie
    @Override
    public String toString() {
        return "Smoothie [Name: " + beverageName + ", Size: " + size +
               ", Protein: " + addProtein + ", Fruits: " + numOfFruits + 
               ", Price: " + calcPrice() + "]";
    }

    // Override equals method to check equality including numOfFruits and addProtein
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Smoothie other = (Smoothie) obj;
        return super.equals(obj) && numOfFruits == other.numOfFruits && addProtein == other.addProtein;
    }

    // Getters and setters for the additional variables
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isAddProtein() {
        return addProtein;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }

    // Optional: Override the hashCode method for consistency with equals()
    @Override
    public int hashCode() {
        return super.hashCode() + numOfFruits + (addProtein ? 1 : 0);
    }
}
