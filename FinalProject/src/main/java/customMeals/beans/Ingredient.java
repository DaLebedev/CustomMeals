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
	
	public Ingredient() {
		super();
	}

	public Ingredient(String ingredientName) {
		super();
		this.ingredientName = ingredientName;
	}

	public Ingredient(long id, String ingredientName) {
		super();
		this.id = id;
		this.ingredientName = ingredientName;
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

	@Override
	public String toString() {
		return ingredientName;
	}
}