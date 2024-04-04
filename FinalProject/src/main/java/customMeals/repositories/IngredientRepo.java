package customMeals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import customMeals.beans.Ingredient;


@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long>{

}

