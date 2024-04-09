package customMeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customMeals.beans.Ingredient;
import customMeals.beans.Side;
import customMeals.repositories.IngredientRepository;
import customMeals.repositories.SideRepository;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 9, 2024
 */

@Controller
public class SideController {
	
	@Autowired
	SideRepository repo;
	
	@Autowired
    IngredientRepository ingredientRepo;
	
	@GetMapping({"viewAllSides"})
	public String viewAllSides(Model model) {
	    if (repo.findAll().isEmpty()) {
	        return addNewSide(model); 
	    } else {
	        model.addAttribute("newSide", repo.findAll());
	        return "sideList";
	    }
	}

	@GetMapping("/inputSide")
	public String addNewSide(Model model) {
		Side s = new Side();
		List<Ingredient> allIngredients = ingredientRepo.findAll();
		model.addAttribute("newSide", s);
        model.addAttribute("allIngredients", allIngredients);
		return "inputSide";
	}
	
	
	@PostMapping("/inputSide")
	public String addNewSide(@ModelAttribute Side s, Model model) {
		repo.save(s);
		return viewAllSides(model);
	}
	
	
	@GetMapping("/editSide/{id}")
	public String showUpdateSide(@PathVariable("id") long id, Model model) {
		Side s = repo.findById(id).orElse(null);
		List<Ingredient> allIngredients = ingredientRepo.findAll();
		model.addAttribute("newSide", s);
        model.addAttribute("allIngredients", allIngredients);
		return "inputSide";
	}
	
	@PostMapping("/updateSide/{id}")
	public String reviseSide(Side s, Model model) {
		repo.save(s);
		return viewAllSides(model);
	}
	
	@GetMapping("/deleteSide/{id}")
	public String deleteSide(@PathVariable("id") long id, Model model) {
		Side s = repo.findById(id).orElse(null);
		repo.delete(s);
		return viewAllSides(model);
		
	}

}
