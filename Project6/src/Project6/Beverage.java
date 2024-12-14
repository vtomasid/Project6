package Project6;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class is a blueprint for beverage
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/
public abstract class Beverage {

	 // Instance variables
    protected String beverageName;
    protected Type beverageType;
    protected Size size;
    
    // Constant values for base price and size price
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

    // Constructor to initialize beverage name, type, and size
    public Beverage(String beverageName, Type beverageType, Size size) {
        this.beverageName = beverageName;
        this.beverageType = beverageType;
        this.size = size;
    }

    // Method to add size price to base price
    public double addSizePrice() {
        switch (this.size) {
            case SMALL:
                return BASE_PRICE; // No additional cost for small size
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE; // Add 0.5 for medium size
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE; // Add 1.0 for large size
            default:
                return BASE_PRICE; // Default to base price if invalid
        }
    }

    // Abstract method to calculate price, will be implemented in subclasses
    public abstract double calcPrice();

    // toString method to return a string representation of the beverage
    @Override
    public String toString() {
        return "Beverage Name: " + beverageName + ", Type: " + beverageType + ", Size: " + size;
    }

    // Overridden equals method to check equality based on name, type, and size
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Beverage other = (Beverage) obj;
        return beverageName.equals(other.beverageName) &&
               beverageType == other.beverageType &&
               size == other.size;
    }

    // Getters and Setters
    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public Type getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(Type beverageType) {
        this.beverageType = beverageType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    // Optional: A method to display the basic price of the beverage
    public double getBasePrice() {
        return BASE_PRICE;
    }

	protected abstract Type getType();
}
