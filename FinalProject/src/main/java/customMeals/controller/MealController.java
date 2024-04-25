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
import customMeals.beans.Entree;
import customMeals.beans.Meal;
import customMeals.beans.Side;
import customMeals.repositories.AppetizerRepository;
import customMeals.repositories.EntreeRepository;
import customMeals.repositories.MealRepository;
import customMeals.repositories.SideRepository;

/**
 * @author Jeff Johnson - jjohnson190
 * CIS175 - Spring 2024
 * Apr 9, 2024
 */

@Controller
public class MealController {
	
	@Autowired
	MealRepository repo;
	
	@Autowired
	EntreeRepository entreeRepo;
	
	@Autowired
	SideRepository sideRepo;
	
	@Autowired
	AppetizerRepository appetizerRepo;
	
		@GetMapping({"/", "viewAllMeals"})
	public String viewAllMeals(Model model) {
	    if (repo.findAll().isEmpty()) {
	        return addNewMeal(model); 
	    } else {
	        model.addAttribute("newMeal", repo.findAll());
	        return "mealList";
	    }
	}

	@GetMapping("/inputMeal")
	public String addNewMeal(Model model) {
		Meal m = new Meal();
		List<Entree> allEntrees = entreeRepo.findAll();
		List<Side> allSides = sideRepo.findAll();
		List<Appetizer> allAppetizers = appetizerRepo.findAll();
		model.addAttribute("newMeal", m);
        model.addAttribute("allEntrees", allEntrees);
        model.addAttribute("allSides", allSides);
        model.addAttribute("allAppetizers", allAppetizers);
		return "inputMeal";
	}
	
	
	@PostMapping("/inputMeal")
	public String addNewMeal(@ModelAttribute Meal m, Model model) {
		repo.save(m);
		return viewAllMeals(model);
	}
	
	
	@GetMapping("/editMeal/{id}")
	public String showUpdateMeal(@PathVariable("id") long id, Model model) {
		Meal m = repo.findById(id).orElse(null);
		List<Entree> allEntrees = entreeRepo.findAll();
		List<Side> allSides = sideRepo.findAll();
		List<Appetizer> allAppetizers = appetizerRepo.findAll();
		model.addAttribute("newMeal", m);
        model.addAttribute("allEntrees", allEntrees);
        model.addAttribute("allSides", allSides);
        model.addAttribute("allAppetizers", allAppetizers);
		return "inputMeal";
	}
	
	@PostMapping("/updateMeal/{id}")
	public String reviseMeal(Meal m, Model model) {
		repo.save(m);
		return viewAllMeals(model);
	}
	
	@GetMapping("/deleteMeal/{id}")
	public String deleteMeal(@PathVariable("id") long id, Model model) {
		Meal m = repo.findById(id).orElse(null);
		repo.delete(m);
		return viewAllMeals(model);
		
	}	

}
