package Project6;

public class Coffee extends Beverage{

	 // Instance variables for additional costs
    private boolean extraShot;
    private boolean extraSyrup;
    
    // Constants for additional costs
    public static final double EXTRA_SHOT_COST = 0.5;
    public static final double EXTRA_SYRUP_COST = 0.5;

    // Constructor for Coffee class
    public Coffee(String beverageName, Size size, boolean extraShot, boolean extraSyrup) {
        super(beverageName, Type.COFFEE, size); // Calling the constructor of the superclass (Beverage)
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    // Override calcPrice method to calculate the price for Coffee
    @Override
    public double calcPrice() {
        double price = addSizePrice(); // Get base price with size adjustment
        
        // Add additional costs for extra shot and extra syrup if applicable
        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }
        
        return price;
    }

    // Override the toString method for Coffee
    @Override
    public String toString() {
        return "Coffee [Name: " + beverageName + ", Size: " + size + 
               ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + 
               ", Price: " + calcPrice() + "]";
    }

    // Override equals method to check equality including extraShot and extraSyrup
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coffee other = (Coffee) obj;
        return super.equals(obj) && extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }

    // Getters and setters for the additional variables
    // Implement the abstract method getType()
    @Override
    public Type getType() {
        return Type.COFFEE;  // Return the type as COFFEE
    }
    
    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

    
}
