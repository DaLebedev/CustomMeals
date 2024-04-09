package customMeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customMeals.beans.Appetizer;
import customMeals.beans.Ingredient;
import customMeals.repositories.AppetizerRepository;
import customMeals.repositories.IngredientRepository;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 9, 2024
 */

@Controller
public class AppetizerController {

	@Autowired
	AppetizerRepository repo;
	
	@Autowired
    IngredientRepository ingredientRepo;
	
	@GetMapping({"viewAllAppetizers"})
	public String viewAllAppetizers(Model model) {
	    if (repo.findAll().isEmpty()) {
	        return addNewAppetizer(model); 
	    } else {
	        model.addAttribute("newAppetizer", repo.findAll());
	        return "appetizerList";
	    }
	}

	@GetMapping("/inputAppetizer")
	public String addNewAppetizer(Model model) {
		Appetizer a = new Appetizer();
		List<Ingredient> allIngredients = ingredientRepo.findAll();
		model.addAttribute("newAppetizer", a);
        model.addAttribute("allIngredients", allIngredients);
		return "inputAppetizer";
	}
	
	
	@PostMapping("/inputAppetizer")
	public String addNewEntree(@ModelAttribute Appetizer a, Model model) {
		repo.save(a);
		return viewAllAppetizers(model);
	}
	
	
	@GetMapping("/editAppetizer/{id}")
	public String showUpdateAppetizer(@PathVariable("id") long id, Model model) {
		Appetizer a = repo.findById(id).orElse(null);
		List<Ingredient> allIngredients = ingredientRepo.findAll();
		model.addAttribute("newAppetizer", a);
        model.addAttribute("allIngredients", allIngredients);
		return "inputAppetizer";
	}
	
	@PostMapping("/updateAppetizer/{id}")
	public String reviseAppetizer(Appetizer a, Model model) {
		repo.save(a);
		return viewAllAppetizers(model);
	}
	
	@GetMapping("/deleteAppetizer/{id}")
	public String deleteAppetizer(@PathVariable("id") long id, Model model) {
		Appetizer a = repo.findById(id).orElse(null);
		repo.delete(a);
		return viewAllAppetizers(model);
		
	}
	
}
