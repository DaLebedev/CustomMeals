package customMeals.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 9, 2024
 */

@Entity
public class Meal {

	@Id
	@GeneratedValue
	private long id;
	
	private String mealName;
	
	@ManyToMany
	@JoinTable(name="meal_entree",
			   joinColumns = @JoinColumn(name = "entree_id"),
		       inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private List<Entree> entrees;
	
	@ManyToMany
	@JoinTable(name="meal_side",
			   joinColumns = @JoinColumn(name = "side_id"),
		       inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private List<Side> sides;
	
	@ManyToMany
	@JoinTable(name="meal_appetizer",
			   joinColumns = @JoinColumn(name = "appetizer_id"),
		       inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private List<Appetizer> appetizers;
	
	private double price;
	
	public Meal() {
		super();
	}

	public Meal(String mealName, List<Entree> entrees, List<Side> sides, List<Appetizer> appetizers, double price) {
	    this.mealName = mealName;
	    this.entrees = entrees;
	    this.sides = sides;
	    this.appetizers = appetizers;
	    this.price = price;
	}
	
	public Meal(long id, String mealName, List<Entree> entrees, List<Side> sides, List<Appetizer> appetizers, double price) {
		super();
		this.id = id;
		this.mealName = mealName;
		this.entrees = entrees;
		this.sides = sides;
		this.appetizers = appetizers;
		this.price = price;	
	}

	public double calculateMealPrice() {
	    double mealPrice = 0.0;

	    if (appetizers != null) {
	        for (Appetizer appetizer : appetizers) {
	        	mealPrice += appetizer.getPrice();
	        }
	    }

	    if (entrees != null) {
	        for (Entree entree : entrees) {
	        	mealPrice += entree.getPrice();
	        }
	    }

	    return mealPrice;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public List<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(List<Entree> entrees) {
		this.entrees = entrees;
	}

	public List<Side> getSides() {
		return sides;
	}

	public void setSides(List<Side> sides) {
		this.sides = sides;
	}

	public List<Appetizer> getAppetizers() {
		return appetizers;
	}

	public void setAppetizers(List<Appetizer> appetizers) {
		this.appetizers = appetizers;
	}

	public double getPrice() {
		price = calculateMealPrice();
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return mealName + " - Entrees: " + entrees + " - Sides: " + sides
				+ " - Appetizers: " + appetizers;
	}
	
}
