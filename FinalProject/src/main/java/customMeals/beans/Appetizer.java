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
public class Appetizer {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String appetizerName;
	private double price;
	
	@ManyToMany
	@JoinTable(name = "appetizeringredients",
    joinColumns = @JoinColumn(name = "appetizer_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;
	
	

	public Appetizer() {
		super();
	}

	public Appetizer(String appetizerName, double price, List<Ingredient> ingredients) {
		super();
		this.appetizerName = appetizerName;
		this.price = price;
		this.ingredients = ingredients;
	}

	public Appetizer(long id, String appetizerName, double price, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.appetizerName = appetizerName;
		this.price = price;
		this.ingredients = ingredients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAppetizerName() {
		return appetizerName;
	}

	public void setAppetizerName(String appetizerName) {
		this.appetizerName = appetizerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Appetizer [id=" + id + ", appetizerName=" + appetizerName + ", price=" + price + ", ingredients="
				+ ingredients + "]";
	}
	
	
	
}
