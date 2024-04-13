package customMeals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import customMeals.beans.MealOrder;

public interface OrderRepository extends JpaRepository<MealOrder, Long>{

}
