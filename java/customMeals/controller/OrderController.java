package customMeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customMeals.beans.Meal;
import customMeals.beans.MealOrder;
import customMeals.repositories.MealRepository;
import customMeals.repositories.OrderRepository;


@Controller
public class OrderController {
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	MealRepository mealRepo;
	
	@GetMapping({"viewAllOrders"})
	public String viewAllOrders(Model model) {
		if (repo.findAll().isEmpty()) {
	        return addNewOrder(model); 
	    } else {
	    	model.addAttribute("orders", repo.findAll());
	        return "orderList";
	    }
	}

	@GetMapping("/inputOrder")
	public String addNewOrder(Model model) {
		MealOrder mo = new MealOrder();
		List<Meal> allMeals = mealRepo.findAll();
		model.addAttribute("newOrder", mo);
        model.addAttribute("allMeals", allMeals);
		return "inputOrder";
	}
	
	
	@PostMapping("/inputOrder")
	public String addNewMeal(@ModelAttribute MealOrder mo, Model model) {
		repo.save(mo);
		return viewAllOrders(model);
	}
	
	
	@GetMapping("/editOrder/{id}")
	public String showUpdateOrder(@PathVariable("id") long id, Model model) {
		MealOrder mo = repo.findById(id).orElse(null);
		List<Meal> allMeals = mealRepo.findAll();
		model.addAttribute("newOrder", mo);
        model.addAttribute("allMeals", allMeals);
		return "inputOrder";
	}
	
	@PostMapping("/updateOrder/{id}")
	public String reviseOrder(MealOrder mo, Model model) {
		repo.save(mo);
		return viewAllOrders(model);
	}
	
	@GetMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable("id") long id, Model model) {
		MealOrder mo = repo.findById(id).orElse(null);
		repo.delete(mo);
		return viewAllOrders(model);
		
	}	

}