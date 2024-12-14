package Project6;

public class Alcohol extends Beverage {

	 // Instance variable to indicate if the alcohol is offered on the weekend
    private boolean isWeekend;

    // Constant for the additional weekend cost
    public static final double WEEKEND_COST = 0.60;  // Additional cost for weekend alcohol

    // Constructor for Alcohol class
    public Alcohol(String beverageName, Size size, boolean isWeekend) {
        super(beverageName, Type.ALCOHOL, size);  // Calling the constructor of the superclass (Beverage)
        this.isWeekend = isWeekend;
    }
    
 // Implement the abstract method from Beverage class
    @Override
    public Type getType() {
        return Type.ALCOHOL;  // Return the appropriate Type for Alcohol
    }

    // Override calcPrice method to calculate the price for Alcohol
    @Override
    public double calcPrice() {
        double price = addSizePrice();  // Get base price with size adjustment

        // Add additional cost for weekend alcohol
        if (isWeekend) {
            price += WEEKEND_COST;
        }

        return price;
    }

    // Override the toString method for Alcohol
    @Override
    public String toString() {
        return "Alcohol [Name: " + beverageName + ", Size: " + size +
               ", Offered on Weekend: " + isWeekend + ", Price: " + calcPrice() + "]";
    }

    // Override equals method to check equality including isWeekend
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Alcohol other = (Alcohol) obj;
        return super.equals(obj) && isWeekend == other.isWeekend;
    }

    // Getter and setter for the isWeekend variable
    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

   
}
