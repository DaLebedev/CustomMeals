package customMeals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customMeals.beans.Ingredient;
import customMeals.repositories.IngredientRepo;

@Controller
public class IngredientController {
	@Autowired
	IngredientRepo repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllIngredients(Model model) {
	    if (repo.findAll().isEmpty()) {
	        return addNewIngredient(model); 
	    } else {
	        model.addAttribute("newIngredient", repo.findAll());
	        return "ingredientList";
	    }
	}
	
	@GetMapping("/inputContact")
	public String addNewIngredient(Model model) {
		Ingredient i = new Ingredient();
		model.addAttribute("newIngredient", i);
		return "inputIngredient";
	}
	
	@PostMapping("/inputIngredient")
	public String addNewIngredient(@ModelAttribute Ingredient i, Model model) {
		repo.save(i);
		return viewAllIngredients(model);
	}
	
	
	@GetMapping("/edit/{id}")
	public String showUpdateIngredient(@PathVariable("id") long id, Model model) {
		Ingredient i = repo.findById(id).orElse(null);
		model.addAttribute("newIngredient", i);
		return "inputIngredient";
	}
	
	@PostMapping("/update/{id}")
	public String reviseIngredient(Ingredient i, Model model) {
		repo.save(i);
		return viewAllIngredients(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteIngredient(@PathVariable("id") long id, Model model) {
		Ingredient i = repo.findById(id).orElse(null);
		repo.delete(i);
		return viewAllIngredients(model);
		
	}
	
	
}
