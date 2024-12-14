package Project6;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: this class represents a customer
 * Due: 12/13/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Victoria  Moody_________
*/

public class Customer {

	// Instance variables
    private String name;
    private int age;

    // Parameterized constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "Customer [Name: " + name + ", Age: " + age + "]";
    }

    // Overridden equals method to compare customers based on name and age
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return name.equals(other.name) && age == other.age;
    }

    // Optional: Override the hashCode method to maintain consistency with equals
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
