package customMeals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import customMeals.beans.CompletedOrder;
import customMeals.repositories.CompletedOrderRepository;


@Controller
public class CompletedOrderController {
	
	@Autowired
	CompletedOrderRepository completedOrderRepo;
	
	@GetMapping({"viewAllCompletedOrders"})
	public String viewAllCompletedOrders(Model model) {
		if (completedOrderRepo.findAll().isEmpty()) {
	        return "noneCompleted";
	    } else {
	    	model.addAttribute("completedOrders", completedOrderRepo.findAll());
	        return "completedOrderList";
	    }
	}
	
	@GetMapping("/deleteCompletedOrder/{id}")
	public String deleteCompletedOrder(@PathVariable long id, Model model) {
		CompletedOrder co = completedOrderRepo.findById(id).orElse(null);
		completedOrderRepo.delete(co);
		return viewAllCompletedOrders(model);
		
	}

}