package customMeals.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue
	private long id;
	private String ingredientName;
	private int quantity;
	
	
	public Ingredient() {
		super();
	}

	public Ingredient(String ingredientName, int quantity) {
		super();
		this.ingredientName = ingredientName;
		this.quantity = quantity;
	}

	public Ingredient(long id, String ingredientName, int quantity) {
		super();
		this.id = id;
		this.ingredientName = ingredientName;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return ingredientName;
	}
}