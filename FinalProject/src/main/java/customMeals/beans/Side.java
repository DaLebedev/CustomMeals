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
public class Side {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String sideName;
	
	@ManyToMany
	@JoinTable(name = "sideingredients",
    joinColumns = @JoinColumn(name = "side_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;

	public Side() {
		super();
	}

	public Side(String sideName, List<Ingredient> ingredients) {
		super();
		this.sideName = sideName;
		this.ingredients = ingredients;
	}

	public Side(long id, String sideName, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.sideName = sideName;
		this.ingredients = ingredients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSideName() {
		return sideName;
	}

	public void setSideName(String sideName) {
		this.sideName = sideName;
	}


	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return sideName + " | Ingredients: " + ingredients;
	}

}
