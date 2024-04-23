package customMeals.beans;
import java.text.DecimalFormat;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class MealOrder {

	@Id
	@GeneratedValue
	private long id;
	
	private String userName;
	
	private String email;
	
	private String phoneNumber;
	
	private String pickupTime = "30 mins";
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "meal_id"),
		       inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Meal> meals;
	
	private double tip;
	
	private double subTotal;
	
	private double tax;
	
	private double total;
	
	public MealOrder() {
		super();
		this.tax = 7;
	}


	public MealOrder(String userName, String email, String phoneNumber, String pickupTime, List<Meal> meals, double subTotal, double tip, double tax, double total) {
		super();
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.pickupTime = pickupTime;
		this.meals = meals;
		this.subTotal = subTotal;
		this.tip = tip;
		this.tax = tax;
		this.total = total;
	}


	public MealOrder(long id, String userName, String email, String phoneNumber, String pickupTime, List<Meal> meals, double subTotal, double tip, double tax, double total) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.pickupTime = pickupTime;
		this.meals = meals;
		this.subTotal = subTotal;
		this.tip = tip;
		this.tax = tax;
		this.total = total;
	}

	public double calculateSubTotal() {
	    double orderSubTotal = 0.0;

	    if (meals != null) {
        	for (Meal meal : meals) {
        		orderSubTotal += meal.getPrice();
        	}	        
	    }
	    
	    return orderSubTotal;
	}
	
	public double calculateTotal() {
	    double orderSubTotal = calculateSubTotal();
	    
	    double taxxedTotal = orderSubTotal * ((this.tax / 100) + 1);

	    double orderTotal = taxxedTotal * ((this.tip / 100) + 1);
	        
	    DecimalFormat df = new DecimalFormat("#.00");
	    String formattedTotal = df.format(orderTotal);
	    
	    orderTotal = Double.parseDouble(formattedTotal);
	    
	    return orderTotal;
	}

	public CompletedOrder toCompletedOrder() {
        return new CompletedOrder(this.userName);
    }
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getPickupTime() {
		return pickupTime;
	}


	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}


	public List<Meal> getMeals() {
		return meals;
	}


	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public double getSubTotal() {
		subTotal = calculateSubTotal();
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		this.tip = tip;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		total = calculateTotal();
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [ID: " + id + ", User Name: " + userName + ", Email: " + email + ", Phone #: " + phoneNumber
				+ ", Pickup: " + pickupTime + ", Meals: " + meals + ", Total: " + subTotal + ", Tip %: " + tip + ", Tax: " + tax + "Total: " + total + "]";
	}
	
}
