package customMeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customMeals.beans.CompletedOrder;
import customMeals.beans.Meal;
import customMeals.beans.MealOrder;
import customMeals.repositories.AppetizerRepository;
import customMeals.repositories.CompletedOrderRepository;
import customMeals.repositories.EntreeRepository;
import customMeals.repositories.MealRepository;
import customMeals.repositories.OrderRepository;
import customMeals.repositories.SideRepository;


@Controller
public class OrderController {
	
	@Autowired
	OrderRepository repo;
	
	@Autowired
	MealRepository mealRepo;
	
	@Autowired
	CompletedOrderRepository completedOrderRepo;
	
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
	public String addNewOrder(@ModelAttribute MealOrder mo, Model model) {
		repo.save(mo);
		return viewAllOrders(model);
	}
	
	
	@GetMapping("/editOrder/{id}")
	public String showUpdateOrder(@PathVariable long id, Model model) {
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
	public String deleteOrder(@PathVariable long id, Model model) {
		MealOrder mo = repo.findById(id).orElse(null);
		CompletedOrder completedOrder = new CompletedOrder(mo.getUserName());
        completedOrderRepo.save(completedOrder);
		repo.delete(mo);
		return viewAllOrders(model);
		
	}
	
	@GetMapping("/confirmOrder/{id}")
	public String confirmOrder(@PathVariable long id, Model model) {
		MealOrder mo = repo.findById(id).orElse(null);
		if (mo != null) {
			model.addAttribute("currentOrder", mo);
			return "confirmation";
		} else {
			return viewAllOrders(model);
		}
	}

}