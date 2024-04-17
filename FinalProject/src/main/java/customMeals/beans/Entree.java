package customMeals.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Entree {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String entreeName;
	private double price;
	
	@ManyToMany
	@JoinTable(name = "entreeingredients",
    joinColumns = @JoinColumn(name = "entree_id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;

	public Entree() {
		super();
	}
	
	public Entree(String entreeName, double price, List<Ingredient> ingredients) {
		super();
		this.entreeName = entreeName;
		this.price = price;
		this.ingredients = ingredients;
	}

	public Entree(long id, String entreeName, double price, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.entreeName = entreeName;
		this.price = price;
		this.ingredients = ingredients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEntreeName() {
		return entreeName;
	}

	public void setEntreeName(String entreeName) {
		this.entreeName = entreeName;
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
		return entreeName + " | $" + price + " | Ingredients: " + ingredients;
	}
	
}
