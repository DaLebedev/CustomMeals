package customMeals.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customMeals.beans.Entree;
import customMeals.beans.Ingredient;
import customMeals.repositories.EntreeRepository;
import customMeals.repositories.IngredientRepository;

@Controller
public class EntreeController {
	@Autowired
	EntreeRepository repo;
	
    @Autowired
    IngredientRepository ingredientRepo;
	
	@GetMapping({"viewAllEntrees"})
	public String viewAllEntrees(Model model) {
	    if (repo.findAll().isEmpty()) {
	        return addNewEntree(model); 
	    } else {
	        model.addAttribute("newEntree", repo.findAll());
	        return "entreeList";
	    }
	}

	@GetMapping("/inputEntree")
	public String addNewEntree(Model model) {
		Entree e = new Entree();
		List<Ingredient> allIngredients = ingredientRepo.findAll();
		model.addAttribute("newEntree", e);
        model.addAttribute("allIngredients", allIngredients);
		return "inputEntree";
	}
	
	
	@PostMapping("/inputEntree")
	public String addNewEntree(@ModelAttribute Entree e, Model model) {
		repo.save(e);
		return viewAllEntrees(model);
	}
	
	
	@GetMapping("/editEntree/{id}")
	public String showUpdateEntree(@PathVariable("id") long id, Model model) {
		Entree e = repo.findById(id).orElse(null);
		List<Ingredient> allIngredients = ingredientRepo.findAll();
		model.addAttribute("newEntree", e);
        model.addAttribute("allIngredients", allIngredients);
		return "inputEntree";
	}
	
	@PostMapping("/updateEntree/{id}")
	public String reviseEntree(Entree i, Model model) {
		repo.save(i);
		return viewAllEntrees(model);
	}
	
	@GetMapping("/deleteEntree/{id}")
	public String deleteEntree(@PathVariable("id") long id, Model model) {
		Entree e = repo.findById(id).orElse(null);
		repo.delete(e);
		return viewAllEntrees(model);
		
	}	
	
}